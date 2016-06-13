/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utils.TextUtils;
import api.Api;
import api.RiotApiException;
import api.constants.GameSubType;
import api.constants.SeasonTier;
import api.dto.game.CurrentGameAPI;
import api.dto.LeagueAPI;
import api.dto.LeagueEntryAPI;
import api.dto.CurrentGameParticipantAPI;
import api.dto.RankedStatsAPI;
import api.dto.SummonerAPI;
import api.dto.champion.ChampionAPI;
import api.dto.champion.ChampionMasteryAPI;
import api.dto.champion.ChampionStatsAPI;
import api.dto.game.GameAPI;
import api.dto.game.RecentGamesAPI;
import api.dto.match.MatchDetailAPI;
import api.dto.match.ParticipantAPI;
import api.dto.match.ParticipantIdentityAPI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Champion;
import model.Match;
import model.Region;
import model.Player;
import model.RankedStats;
import view.LiveMatchView;

/**
 *
 * @author Dennis
 */
public class LiveMatchController {

    private Match match;

    private LiveMatchView liveMatchView;

    Api api = new Api();
    Region server;

    public LiveMatchController(String summonerName, Region server) throws RiotApiException, IOException {

        this.server = server;

        ArrayList<CurrentGameParticipantAPI> team1 = new ArrayList<>();
        ArrayList<CurrentGameParticipantAPI> team2 = new ArrayList<>();

        //match = api.getMatchBySummonerName(summonerName);
        match = new Match();

        ArrayList<String> summonerNames = new ArrayList<>();
        summonerNames.add(TextUtils.normalizeSummonerName(summonerName));

        Map<String, SummonerAPI> summoners = api.getSummonerBySummonerNames(summonerNames, server);

        int summonerId = summoners.get(TextUtils.normalizeSummonerName(summonerName)).getId();

        CurrentGameAPI currentGame = null;
        
        try {
            currentGame = api.getCurrentGameBySummonerId(summonerId, server);
        } catch(RiotApiException e) {
            JOptionPane.showMessageDialog(null, "Summoner "+summonerNames.get(0)+" is not in a game.");
            throw new RiotApiException(e.getErrorCode());
        }
        
        ArrayList<Integer> summIds = new ArrayList<>();

        ArrayList<Player> players = new ArrayList<>();

        for (CurrentGameParticipantAPI summoner : currentGame.getParticipants()) {
            summIds.add((int) summoner.getSummonerId());

            if (summoner.getTeamId() == 100) {
                team1.add(summoner);
            } else {
                team2.add(summoner);
            }
            Player player = new Player(summoner.getSummonerName(), (int) summoner.getSummonerId());

            // PLAYERS CHAMPION
            player.setChampion(getChampionWithStats(summoner));

            // PLAYERS TEAM ID
            player.setTeamId((int) summoner.getTeamId());

            // PLAYERS PREVIOUS SEASON TIER
            player.setPreviousSeasonTier(getPreviousSeasonTier(summoner));

            // PLAYERS MOST PLAYED CHAMPIONS
            player.setMostPlayedChampions(getMostPlayedChampions(summoner));

            // PLAYERS RECENT GAMES
            player.setRecentRankedGames(getRecentGames(summoner));

            players.add(player);
        }

        System.out.println("Participants size: " + summIds.size());

        // PLAYERS RANKED STATS
        ArrayList<RankedStats> rankedStats = getRankedStatsForPlayer(summIds);

        for (int i = 0; i < players.size(); i++) {

            for (int j = 0; j < rankedStats.size(); j++) {
                if (rankedStats.get(j).getSummoenerId() == players.get(i).getId()) {
                    players.get(i).setRankedStats(rankedStats.get(j));
                    break;
                }
            }

            if (players.get(i).getTeamId() == 100) {
                match.getFirstTeam().addMember(players.get(i));
            } else {
                match.getSecondTeam().addMember(players.get(i));
            }
        }

        liveMatchView = new LiveMatchView(match.getFirstTeam().getMembers(), match.getSecondTeam().getMembers());

        liveMatchView.pack();
    }

    public Champion getChampionWithStats(CurrentGameParticipantAPI summoner) {

        ChampionAPI champion = null;

        try {
            // SETTING CHAMPION
            champion = api.getChampionById((int) summoner.getChampionId(), server);

            RankedStatsAPI rankedStatsApi = api.getChampionStatsBySummonerId((int) summoner.getSummonerId(), server);
            Champion champ = new Champion(champion.getName(), champion.getImage().getFull());

            for (ChampionStatsAPI c : rankedStatsApi.getChampions()) {
                if (c.getId() == summoner.getChampionId()) {
                    champ.setWinrate((float) c.getStats().getTotalSessionsWon() / c.getStats().getTotalSessionsPlayed());
                    champ.setTotalGamesPlayed(c.getStats().getTotalSessionsPlayed());
                    champ.setTotalKills(c.getStats().getTotalChampionKills());
                    champ.setTotalAssits(c.getStats().getTotalAssists());
                    champ.setTotalDeaths(c.getStats().getTotalDeathsPerSession());
                }
            }

            return champ;
        } catch (RiotApiException ex) {
            Logger.getLogger(LiveMatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LiveMatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Champion(champion.getName(), champion.getImage().getFull());
    }

    public ArrayList<Champion> getMostPlayedChampions(CurrentGameParticipantAPI summoner) throws RiotApiException, IOException {

        ArrayList<ChampionMasteryAPI> champions = api.getTopChampionsBySummonerId((int) summoner.getSummonerId(), server);

        ArrayList<Champion> champs = new ArrayList<>();

        for (int i = 0; i < champions.size(); i++) {
            ChampionAPI c = api.getChampionById((int) champions.get(i).getChampionId(), server);

            Champion c1 = new Champion(c.getName(), c.getImage().getFull());

            champs.add(c1);
        }

        return champs;
    }

    public ArrayList<GameAPI> getRecentGames(CurrentGameParticipantAPI summoner) throws RiotApiException, IOException {

        RecentGamesAPI recentGamesAPI = api.getRecentGamesBySummonerid((int) summoner.getSummonerId(), server);

        ArrayList<GameAPI> recentRankedGames = new ArrayList<>();

        for (GameAPI g : recentGamesAPI.getGames()) {
            System.out.println("Recent game: " + g.getSubType());
            if (g.getSubType().equals(GameSubType.RANKED_SOLO_5x5.getName())) {
                if (recentRankedGames.size() != 5) {
                    recentRankedGames.add(g);
                }
            }
        }

        return recentRankedGames;
    }

    public ArrayList<RankedStats> getRankedStatsForPlayer(ArrayList<Integer> summIds) {

        try {
            Map<String, ArrayList<LeagueAPI>> leagueAPI = api.getLeagueBySummonerIds(summIds, server);

            ArrayList<RankedStats> rankedStats = new ArrayList<>();

            for (Map.Entry<String, ArrayList<LeagueAPI>> entry : leagueAPI.entrySet()) {

                LeagueEntryAPI entryAPI = entry.getValue().get(0).getEntries().get(0);

                int wins = entryAPI.getWins();
                int losses = entryAPI.getLosses();
                int leaguePoints = entryAPI.getLeaguePoints();

                String tier = entry.getValue().get(0).getTier();
                String division = entryAPI.getDivision();

                rankedStats.add(new RankedStats(Long.parseLong(entry.getKey()), tier, division, wins, losses, leaguePoints, entryAPI.getMiniSeries()));
            }

            return rankedStats;
        } catch (RiotApiException ex) {
            System.out.println("ahoj");
            Logger.getLogger(LiveMatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LiveMatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<RankedStats>();
    }

    private SeasonTier getPreviousSeasonTier(CurrentGameParticipantAPI summoner) throws IOException, RiotApiException {
        RecentGamesAPI recentGamesAPI = api.getRecentGamesBySummonerid((int) summoner.getSummonerId(), server);
        GameAPI game = null;

        for (GameAPI g : recentGamesAPI.getGames()) {
            System.out.println("GAME SUB TYPE: "+g.getSubType());
            if (g.getSubType().equals(GameSubType.RANKED_SOLO_5x5.getName())) {
                game = g;
                break;
            }
        }

        if (game == null) {
            return SeasonTier.UNRANKED;
        }

        long matchId = game.getGameId();

        MatchDetailAPI match = api.getMatchById((int) matchId, server);

        int participantId = 0;
        
        for (ParticipantIdentityAPI i : match.getParticipantIdentities()) {
            if (i.getPlayer().getSummonerId() == summoner.getSummonerId()) {
                participantId = i.getParticipantId();
                break;
            }
        }
        
        for(ParticipantAPI p : match.getParticipants()) {
            if(p.getParticipantId() == participantId) {
                return SeasonTier.valueOfTier(p.getHighestAchievedSeasonTier());
            }
        }

        return SeasonTier.UNRANKED;
    }

}
