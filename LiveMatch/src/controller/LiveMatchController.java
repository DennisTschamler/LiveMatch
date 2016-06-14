/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utils.TextUtils;
import api.RiotApi;
import api.RiotApiException;
import api.constants.GameSubType;
import api.constants.SeasonTier;
import api.dto.Region;
import api.dto.champion_mastery.ChampionMastery;
import api.dto.current_game.CurrentGame;
import api.dto.current_game.CurrentGameParticipant;
import api.dto.game.Game;
import api.dto.game.RecentGames;
import api.dto.league.League;
import api.dto.league.LeagueEntry;
import api.dto.stats.ChampionStats;
import api.dto.stats.RankedStats;

import api.dto.match.MatchDetail;
import api.dto.match.Participant;
import api.dto.match.ParticipantIdentity;
import api.dto.static_data.Champion;
import api.dto.summoner.Summoner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Match;
import model.Player;
import model.PlayerChampionStats;
import model.PlayerStats;
import view.LiveMatchView;

/**
 *
 * @author Dennis
 */
public class LiveMatchController {

    private Match match;

    private LiveMatchView liveMatchView;

    RiotApi api = new RiotApi();
    Region server;

    public LiveMatchController(String summonerName, Region server) throws RiotApiException, IOException {

        this.server = server;

        ArrayList<CurrentGameParticipant> team1 = new ArrayList<>();
        ArrayList<CurrentGameParticipant> team2 = new ArrayList<>();

        //match = api.getMatchBySummonerName(summonerName);
        match = new Match();

        ArrayList<String> summonerNames = new ArrayList<>();
        summonerNames.add(TextUtils.normalizeSummonerName(summonerName));

        Map<String, Summoner> summoners = api.getSummonerBySummonerNames(summonerNames, server);

        long summonerId = summoners.get(TextUtils.normalizeSummonerName(summonerName)).getId();

        CurrentGame currentGame = null;
        
        try {
            currentGame = api.getCurrentGameBySummonerId(summonerId, server);
        } catch(RiotApiException e) {
            JOptionPane.showMessageDialog(null, "Summoner "+summonerNames.get(0)+" is not in a game.");
            throw new RiotApiException(e.getErrorCode());
        }
        
        ArrayList<Integer> summIds = new ArrayList<>();

        ArrayList<Player> players = new ArrayList<>();

        for (CurrentGameParticipant summoner : currentGame.getParticipants()) {
            summIds.add((int) summoner.getSummonerId());

            if (summoner.getTeamId() == 100) {
                team1.add(summoner);
            } else {
                team2.add(summoner);
            }
            Player player = new Player(summoner.getSummonerName(), (int) summoner.getSummonerId());

            // PLAYERS CHAMPION
            player.setChampionStats(getChampionWithStats(summoner));

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

        // PLAYERS RANKED STATS
        ArrayList<PlayerStats> rankedStats = getPlayerStats(summIds);

        for (int i = 0; i < players.size(); i++) {

            for (int j = 0; j < rankedStats.size(); j++) {
                if (rankedStats.get(j).getSummonerId() == players.get(i).getId()) {
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

    public PlayerChampionStats getChampionWithStats(CurrentGameParticipant summoner) {

        Champion champion = null;

        try {
            // SETTING CHAMPION
            champion = api.getChampionById((int) summoner.getChampionId(), server);

            RankedStats rankedStatsApi = api.getChampionStatsBySummonerId((int) summoner.getSummonerId(), server);
            PlayerChampionStats champ = new PlayerChampionStats(champion.getName(), champion.getImage().getFull());

            for (ChampionStats c : rankedStatsApi.getChampions()) {
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

        return new PlayerChampionStats(champion.getName(), champion.getImage().getFull());
    }

    public ArrayList<PlayerChampionStats> getMostPlayedChampions(CurrentGameParticipant summoner) throws RiotApiException, IOException {

        List<ChampionMastery> champions = api.getTopChampionsBySummonerId((int) summoner.getSummonerId(), server);

        ArrayList<PlayerChampionStats> champs = new ArrayList<>();

        for (int i = 0; i < champions.size(); i++) {
            Champion c = api.getChampionById((int) champions.get(i).getChampionId(), server);

            PlayerChampionStats c1 = new PlayerChampionStats(c.getName(), c.getImage().getFull());

            champs.add(c1);
        }

        return champs;
    }

    public ArrayList<Game> getRecentGames(CurrentGameParticipant summoner) throws RiotApiException, IOException {

        RecentGames recentGamesAPI = api.getRecentGamesBySummonerid((int) summoner.getSummonerId(), server);

        ArrayList<Game> recentRankedGames = new ArrayList<>();

        for (Game g : recentGamesAPI.getGames()) {
            if (g.getSubType().equals(GameSubType.RANKED_SOLO_5x5.getName())) {
                if (recentRankedGames.size() != 5) {
                    recentRankedGames.add(g);
                }
            }
        }

        return recentRankedGames;
    }

    public ArrayList<PlayerStats> getPlayerStats(ArrayList<Integer> summIds) {

        try {
            Map<String, List<League>> leagueAPI = api.getLeagueBySummonerIds(summIds, server);

            ArrayList<PlayerStats> playerStats = new ArrayList<>();

            for (Map.Entry<String, List<League>> entry : leagueAPI.entrySet()) {

                LeagueEntry entryAPI = entry.getValue().get(0).getEntries().get(0);

                int wins = entryAPI.getWins();
                int losses = entryAPI.getLosses();
                int leaguePoints = entryAPI.getLeaguePoints();

                String tier = entry.getValue().get(0).getTier();
                String division = entryAPI.getDivision();

                playerStats.add(new PlayerStats(Long.parseLong(entry.getKey()), tier, division, wins, losses, leaguePoints, entryAPI.getMiniSeries()));
            }

            return playerStats;
        } catch (RiotApiException ex) {
            if(ex.getErrorCode() == RiotApiException.DATA_NOT_FOUND) {
                System.out.println("RiotApiException: League not found");
            }
            Logger.getLogger(LiveMatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LiveMatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<PlayerStats>();
    }

    private SeasonTier getPreviousSeasonTier(CurrentGameParticipant summoner) throws IOException, RiotApiException {
        RecentGames recentGames = api.getRecentGamesBySummonerid((int) summoner.getSummonerId(), server);
        Game game = null;

        for (Game g : recentGames.getGames()) {
            if (g.getSubType().equals(GameSubType.RANKED_SOLO_5x5.getName())) {
                game = g;
                break;
            }
        }

        if (game == null) {
            return SeasonTier.UNRANKED;
        }

        long matchId = game.getGameId();

        MatchDetail match = api.getMatchById(matchId, server);

        int participantId = 0;
        
        for (ParticipantIdentity i : match.getParticipantIdentities()) {
            if (i.getPlayer().getSummonerId() == summoner.getSummonerId()) {
                participantId = i.getParticipantId();
                break;
            }
        }
        
        for(Participant p : match.getParticipants()) {
            if(p.getParticipantId() == participantId) {
                return SeasonTier.valueOfTier(p.getHighestAchievedSeasonTier());
            }
        }

        return SeasonTier.UNRANKED;
    }

}
