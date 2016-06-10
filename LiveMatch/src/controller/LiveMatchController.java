/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.Api;
import api.dto.CurrentGameAPI;
import api.dto.LeagueAPI;
import api.dto.ParticipantAPI;
import api.dto.SummonerAPI;
import api.dto.champion.ChampionAPI;
import api.dto.summoner.SummonerSpellAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import model.Champion;
import model.Match;
import model.Region;
import model.Player;
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

        //match = api.getMatchBySummonerName(summonerName);
        Match match = new Match();

        ArrayList<String> summonerNames = new ArrayList<>();
        summonerNames.add(summonerName);

        Map<String, SummonerAPI> summoners = api.getSummonerBySummonerNames(summonerNames, server);

        int summonerId = summoners.get(summonerName).getId();

        CurrentGameAPI currentGame = api.getCurrentGameBySummonerId(summonerId, server);

        ArrayList<Integer> summIds = new ArrayList<>();
        
        for (ParticipantAPI summoner : currentGame.getParticipants()) {

            Player player = new Player(summoner.getSummonerName(), (int) summoner.getSummonerId());

            // SETTING SPELLS
            SummonerSpellAPI spell1 = api.getSummonerSpellById((int) summoner.getSpell1Id(), Region.EUNE);
            SummonerSpellAPI spell2 = api.getSummonerSpellById((int) summoner.getSpell2Id(), Region.EUNE);
            player.setSpells(new Spell(spell1.getName(), spell1.getImage().getFull()), new Spell(spell2.getName(), spell2.getImage().getFull()));

            // SETTING CHAMPION
            ChampionAPI champion = api.getChampionById((int) summoner.getChampionId(), server);
            Champion champ = new Champion(champion.getName(), champion.getImage().getFull());
            player.setChampion(champ);
            
            if (summoner.getTeamId() == 100) {
                match.getFirstTeam().addMember(player);
            } else {
                match.getSecondTeam().addMember(player);
            }
            /*System.out.println(summoner.getSummonerName() + " " + summoner.getTeamId());
            

             summIds.add((int) summoner.getSummonerId());*/

            summIds.add((int) summoner.getSummonerId());
        }

        Map<String, ArrayList<LeagueAPI>> leagueAPI = api.getLeagueBySummonerIds(summIds, Region.EUNE);

        Iterator it = leagueAPI.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String key = String.valueOf(pair.getKey());
            ArrayList<LeagueAPI> league = (ArrayList<LeagueAPI>) pair.getValue();
            System.out.println(pair.getKey());
            System.out.println("TIER "+league.get(0).getTier());
            it.remove(); // avoids a ConcurrentModificationException
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
        liveMatchView = new LiveMatchView(summonerName);

        liveMatchView.initTeam1(match.getFirstTeam());
        liveMatchView.initTeam2(match.getSecondTeam());

        liveMatchView.pack();
    }
}
