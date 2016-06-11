/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import api.dto.game.CurrentGameAPI;
import api.dto.LeagueAPI;
import api.dto.RankedStatsAPI;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import model.Region;
import api.dto.SummonerAPI;
import api.dto.champion.ChampionAPI;
import api.dto.champion.ChampionMasteryAPI;
import api.dto.game.RecentGamesAPI;
import api.dto.summoner.SummonerSpellAPI;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dennis
 */
public class Api {

    RequestManager rm;

    public Api() {
        rm = new RequestManager("2af15e13-c544-451f-a890-30d2aa2f8294");
    }
    
    public Map<String, SummonerAPI> getSummonerBySummonerNames(ArrayList<String> summonerNames, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getSummonerByNames(region, summonerNames));
        Type mapType = new TypeToken<HashMap<String,SummonerAPI>>(){}.getType(); 
        
        Map<String, SummonerAPI> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    } 
    
    public Map<String, ArrayList<LeagueAPI>> getLeagueBySummonerIds(ArrayList<Integer> summonerIds, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getLeagueByIds(region, summonerIds));
        Type mapType = new TypeToken<HashMap<String,ArrayList<LeagueAPI>>>(){}.getType(); 
        
        Map<String, ArrayList<LeagueAPI>> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public Map<String, SummonerAPI> getSummonerBySummonerIds(ArrayList<Integer> summonerIds, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getSummonerByIds(region, summonerIds));
        Type mapType = new TypeToken<HashMap<String,SummonerAPI>>(){}.getType(); 
        
        Map<String, SummonerAPI> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }
    
    public CurrentGameAPI getCurrentGameBySummonerId(int summonerId, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getCurrentGameBySummonerId(region, summonerId));
        CurrentGameAPI currentGame = new Gson().fromJson(x, CurrentGameAPI.class);
        
        return currentGame;
    }
    
    public ArrayList<ChampionMasteryAPI> getTopChampionsBySummonerId(int summonerId, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getTopChampionsBySummonerId(region, summonerId, 5));
        Type mapType = new TypeToken<ArrayList<ChampionMasteryAPI>>(){}.getType(); 
        
        ArrayList<ChampionMasteryAPI> championMastery = new Gson().fromJson(x, mapType);
        
        return championMastery;
    }
    
    public RecentGamesAPI getRecentGamesBySummonerid(int summonerId, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getRecentGamesBySummonerId(region, summonerId));
        RecentGamesAPI currentGame = new Gson().fromJson(x, RecentGamesAPI.class);
        
        return currentGame;
    }
    
    public RankedStatsAPI getChampionStatsBySummonerId(int summonerId, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getChampionStatsBySummonerId(region, summonerId));
        RankedStatsAPI currentGame = new Gson().fromJson(x, RankedStatsAPI.class);
        
        return currentGame;
    }
    
    public ChampionAPI getChampionById(int id, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getChampionById(region, id));
        ChampionAPI currentGame = new Gson().fromJson(x, ChampionAPI.class);
        
        return currentGame;
    }
    
    public SummonerSpellAPI getSummonerSpellById(int id, Region region) throws IOException {
        JsonElement x = rm.sendRequest(Query.getSummonerSpellById(region, id));
        SummonerSpellAPI summonerSpell = new Gson().fromJson(x, SummonerSpellAPI.class);
        
        return summonerSpell;
    }
}
