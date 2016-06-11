/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utils.TextUtils;
import api.Api;
import api.constants.GameSubType;
import api.dto.game.CurrentGameAPI;
import api.dto.LeagueAPI;
import api.dto.LeagueEntryAPI;
import api.dto.ParticipantAPI;
import api.dto.RankedStatsAPI;
import api.dto.SummonerAPI;
import api.dto.champion.ChampionAPI;
import api.dto.champion.ChampionMasteryAPI;
import api.dto.champion.ChampionStatsAPI;
import api.dto.game.GameAPI;
import api.dto.game.RecentGamesAPI;
import api.dto.summoner.SummonerSpellAPI;
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
import model.Spell;
import view.LiveMatchView;

/**
 *
 * @author Dennis
 */
public class LiveMatchController {

    private Match match;

    private LiveMatchView liveMatchView;

    public LiveMatchController(String summonerName, Region server) {
        Api api = new Api();

        ArrayList<ParticipantAPI> team1 = new ArrayList<>();
        ArrayList<ParticipantAPI> team2 = new ArrayList<>();

        //match = api.getMatchBySummonerName(summonerName);
        Match match = new Match();

        ArrayList<String> summonerNames = new ArrayList<>();
        summonerNames.add(TextUtils.normalizeSummonerName(summonerName));

        Map<String, SummonerAPI> summoners = null;
        try {
            summoners = api.getSummonerBySummonerNames(summonerNames, server);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Summoner name "+summonerName+ " doesnt exists int region "+server.getName());
            return;
        }

        int summonerId = summoners.get(TextUtils.normalizeSummonerName(summonerName)).getId();

        CurrentGameAPI currentGame = null;
        try {
            currentGame = api.getCurrentGameBySummonerId(summonerId, server);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Summoner "+summonerName+ " is not in a game");
            return;
        }

        ArrayList<Integer> summIds = new ArrayList<>();

        ArrayList<Player> players = new ArrayList<>();

        for (ParticipantAPI summoner : currentGame.getParticipants()) {

            if (summoner.getTeamId() == 100) {
                team1.add(summoner);
            } else {
                team2.add(summoner);
            }
            Player player = new Player(summoner.getSummonerName(), (int) summoner.getSummonerId());

            // SETTING CHAMPION
            ChampionAPI champion = null;
            try {
                champion = api.getChampionById((int) summoner.getChampionId(), server);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Champion with id "+summoner.getChampionId()+ " not found");
                return;
            }

            RankedStatsAPI rankedStatsApi = null;
            try {
                rankedStatsApi = api.getChampionStatsBySummonerId((int) summoner.getSummonerId(), server);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No ranked stats for summoner "+summoner.getSummonerName());
                return;
            }

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

            player.setChampion(champ);

            player.setTeamId((int) summoner.getTeamId());

            ArrayList<ChampionMasteryAPI> champions = null;
            try {
                champions = api.getTopChampionsBySummonerId((int) summoner.getSummonerId(), server);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No mastered champions for summoner "+summoner.getSummonerName());
                return;
            }
            
            ArrayList<Champion> champs = new ArrayList<>();

            for (int i = 0; i < champions.size(); i++) {
                ChampionAPI c = null;
                
                try {
                    c = api.getChampionById((int) champions.get(i).getChampionId(), server);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Champion with id "+champions.get(i).getChampionId()+ " not found");
                    return;
                }
                
                Champion c1 = new Champion(c.getName(), c.getImage().getFull());

                champs.add(c1);
            }

            player.setMostPlayedChampions(champs);

            players.add(player);
            System.out.println(summoner.getSummonerName() + " " + summoner.getTeamId());

            summIds.add((int) summoner.getSummonerId());
            
            RecentGamesAPI recentGamesAPI = null;
            try {
                recentGamesAPI = api.getRecentGamesBySummonerid((int)summoner.getSummonerId(), server);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No recent games found for summoner "+summoner.getSummonerName());
                return;
            }
            
            ArrayList<GameAPI> recentRankedGames = new ArrayList<>();
            
            for(GameAPI g : recentGamesAPI.getGames()) {
                System.out.println("Recent game: "+g.getSubType());
                if(g.getSubType().equals(GameSubType.RANKED_SOLO_5x5.getName())) {
                    if(recentRankedGames.size() != 5)
                        recentRankedGames.add(g);
                }
            }
            
            player.setRecentRankedGames(recentRankedGames);
        }

        System.out.println("Participants size: " + summIds.size());

        Map<String, ArrayList<LeagueAPI>> leagueAPI = null;
        try {
            leagueAPI = api.getLeagueBySummonerIds(summIds, server);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No league entry for summoners found");
            return;
        }

        ArrayList<RankedStats> rankedStats = new ArrayList<>();

        for (Map.Entry<String, ArrayList<LeagueAPI>> entry : leagueAPI.entrySet()) {
            String tier = entry.getValue().get(0).getTier();

            LeagueEntryAPI entryAPI = entry.getValue().get(0).getEntries().get(0);

            int wins = entryAPI.getWins();
            int losses = entryAPI.getLosses();
            int leaguePoints = entryAPI.getLeaguePoints();
            String division = entryAPI.getDivision();

            rankedStats.add(new RankedStats(tier, division, wins, losses, leaguePoints, entryAPI.getMiniSeries()));
        }

        System.out.println("RankedStats size: " + rankedStats.size() + " " + leagueAPI.size());

        for (int i = 0; i < players.size(); i++) {
            if (rankedStats.size() > i) {
                players.get(i).setRankedStats(rankedStats.get(i));
            }

            if (players.get(i).getTeamId() == 100) {
                match.getFirstTeam().addMember(players.get(i));
            } else {
                match.getSecondTeam().addMember(players.get(i));
            }
        }

        /*Player summ1 = new Player("ahoj", 54);
         summ1.setChampion(new Champion("Caitlyn", "Caitlyn.png"));
         summ1.setRankedStats(new RankedStats("platinum", "IV", 10, 12, 20));
         summ1.setSpells(new Spell("Flash", "SummonerFlash.png"), new Spell("Teleport", "SummonerTeleport.png"));
        
         ArrayList<Champion> champs = new ArrayList<>();
         champs.add(new Champion("Cait", "Caitlyn.png"));
         champs.add(new Champion("Amumu", "Amumu.png"));
         champs.add(new Champion("Aatrox", "Aatrox.png"));
         champs.add(new Champion("Cait", "Caitlyn.png"));
         champs.add(new Champion("Amumu", "Amumu.png"));
         champs.add(new Champion("Aatrox", "Aatrox.png"));
         champs.add(new Champion("Cait", "Caitlyn.png"));
         champs.add(new Champion("Amumu", "Amumu.png"));
         champs.add(new Champion("Aatrox", "Aatrox.png"));
        
         summ1.setMostPlayedChampions(champs);
        
         Player summ2 = new Player("ahoj", 54);
         summ2.setChampion(new Champion("Thresh", "Thresh.png"));
         summ2.setRankedStats(new RankedStats("platinum", "IV", 10, 12, 20));
         summ2.setMostPlayedChampions(champs);
         summ2.setSpells(new Spell("Flash", "SummonerFlash.png"), new Spell("Teleport", "SummonerTeleport.png"));
        
         match.getFirstTeam().addMember(summ1);
         match.getFirstTeam().addMember(summ1);
         match.getFirstTeam().addMember(summ1);
         match.getFirstTeam().addMember(summ2);
         match.getFirstTeam().addMember(summ1);
        
         match.getSecondTeam().addMember(summ2);
         match.getSecondTeam().addMember(summ1);
         match.getSecondTeam().addMember(summ2);
         match.getSecondTeam().addMember(summ1);
         match.getSecondTeam().addMember(summ2);*/
        //m.getFirstTeam()
        liveMatchView = new LiveMatchView(match.getFirstTeam().getMembers(), match.getSecondTeam().getMembers());

        liveMatchView.pack();
    }
}
