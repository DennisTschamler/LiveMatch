/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import api.dto.game.CurrentGameAPI;
import api.dto.LeagueAPI;
import api.dto.match.MatchDetailAPI;
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
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class Api {

    RequestManager rm;
    
    public static final Logger log = Logger.getLogger(Api.class.getName());

    public Api() {
        rm = new RequestManager("2af15e13-c544-451f-a890-30d2aa2f8294");
    }

    public Map<String, SummonerAPI> getSummonerBySummonerNames(ArrayList<String> summonerNames, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getSummonerByNames(region, summonerNames)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        Type mapType = new TypeToken<HashMap<String, SummonerAPI>>() {
        }.getType();

        Map<String, SummonerAPI> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public Map<String, ArrayList<LeagueAPI>> getLeagueBySummonerIds(ArrayList<Integer> summonerIds, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getLeagueByIds(region, summonerIds)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        Type mapType = new TypeToken<HashMap<String, ArrayList<LeagueAPI>>>() {
        }.getType();

        Map<String, ArrayList<LeagueAPI>> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public Map<String, SummonerAPI> getSummonerBySummonerIds(ArrayList<Integer> summonerIds, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getSummonerByIds(region, summonerIds)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        Type mapType = new TypeToken<HashMap<String, SummonerAPI>>() {
        }.getType();

        Map<String, SummonerAPI> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public CurrentGameAPI getCurrentGameBySummonerId(int summonerId, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getCurrentGameBySummonerId(region, summonerId)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        CurrentGameAPI currentGame = new Gson().fromJson(x, CurrentGameAPI.class);

        return currentGame;
    }

    public ArrayList<ChampionMasteryAPI> getTopChampionsBySummonerId(int summonerId, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getTopChampionsBySummonerId(region, summonerId, 5)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        Type mapType = new TypeToken<ArrayList<ChampionMasteryAPI>>() {
        }.getType();

        ArrayList<ChampionMasteryAPI> championMastery = new Gson().fromJson(x, mapType);

        return championMastery;
    }
    
    public MatchDetailAPI getMatchById(int matchId, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getMatchById(region, matchId)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        MatchDetailAPI matchDetail = new Gson().fromJson(x, MatchDetailAPI.class);

        return matchDetail;
    }

    public RecentGamesAPI getRecentGamesBySummonerid(int summonerId, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getRecentGamesBySummonerId(region, summonerId)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        RecentGamesAPI currentGame = new Gson().fromJson(x, RecentGamesAPI.class);

        return currentGame;
    }

    public RankedStatsAPI getChampionStatsBySummonerId(int summonerId, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getChampionStatsBySummonerId(region, summonerId)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        RankedStatsAPI currentGame = new Gson().fromJson(x, RankedStatsAPI.class);

        return currentGame;
    }

    public ChampionAPI getChampionById(int id, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getChampionById(region, id)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        ChampionAPI currentGame = new Gson().fromJson(x, ChampionAPI.class);

        return currentGame;
    }

    public SummonerSpellAPI getSummonerSpellById(int id, Region region) throws RiotApiException, IOException {
        rm.setRequest(new Request(Query.getSummonerSpellById(region, id)));
        rm.execute();

        JsonElement x = new JsonParser().parse(rm.getResponse().getBody());

        SummonerSpellAPI summonerSpell = new Gson().fromJson(x, SummonerSpellAPI.class);

        return summonerSpell;
    }
}
