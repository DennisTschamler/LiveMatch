/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import api.dto.Region;
import api.dto.champion_mastery.ChampionMastery;
import api.dto.current_game.CurrentGame;
import api.dto.game.RecentGames;
import api.dto.league.League;
import api.dto.match.MatchDetail;
import api.dto.static_data.Champion;
import api.dto.static_data.SummonerSpell;
import api.dto.stats.RankedStats;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;

import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import api.dto.summoner.Summoner;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class RiotApi {
    
    public static final Logger log = Logger.getLogger(RiotApi.class.getName());
    
    private String apiKey;

    public RiotApi() {
        this.apiKey = "2af15e13-c544-451f-a890-30d2aa2f8294";
    }

    public Map<String, Summoner> getSummonerBySummonerNames(List<String> summonerNames, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getSummonerByNames(region, summonerNames), apiKey);

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        Type mapType = new TypeToken<HashMap<String, Summoner>>() {
        }.getType();

        Map<String, Summoner> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public Map<String, List<League>> getLeagueBySummonerIds(ArrayList<Integer> summonerIds, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getLeagueByIds(region, summonerIds), apiKey);

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        Type mapType = new TypeToken<HashMap<String, List<League>>>() {
        }.getType();

        Map<String, List<League>> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public Map<String, Summoner> getSummonerBySummonerIds(ArrayList<Integer> summonerIds, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getSummonerByIds(region, summonerIds), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        Type mapType = new TypeToken<HashMap<String, Summoner>>() {
        }.getType();

        Map<String, Summoner> summoners = new Gson().fromJson(x, mapType);
        return summoners;
    }

    public CurrentGame getCurrentGameBySummonerId(long summonerId, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getCurrentGameBySummonerId(region, summonerId), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        CurrentGame currentGame = new Gson().fromJson(x, CurrentGame.class);

        return currentGame;
    }

    public List<ChampionMastery> getTopChampionsBySummonerId(int summonerId, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getTopChampionsBySummonerId(region, summonerId, 5), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        Type mapType = new TypeToken<List<ChampionMastery>>() {
        }.getType();

        List<ChampionMastery> championMastery = new Gson().fromJson(x, mapType);

        return championMastery;
    }
    
    public MatchDetail getMatchById(long matchId, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getMatchById(region, matchId), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        MatchDetail matchDetail = new Gson().fromJson(x, MatchDetail.class);

        return matchDetail;
    }

    public RecentGames getRecentGamesBySummonerid(int summonerId, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getRecentGamesBySummonerId(region, summonerId), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        RecentGames currentGame = new Gson().fromJson(x, RecentGames.class);

        return currentGame;
    }

    public RankedStats getChampionStatsBySummonerId(int summonerId, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getChampionStatsBySummonerId(region, summonerId), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        RankedStats currentGame = new Gson().fromJson(x, RankedStats.class);

        return currentGame;
    }

    public Champion getChampionById(int id, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getChampionById(region, id), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        Champion currentGame = new Gson().fromJson(x, Champion.class);

        return currentGame;
    }

    public SummonerSpell getSummonerSpellById(int id, Region region) throws RiotApiException, IOException {
        Request r = new Request(Query.getSummonerSpellById(region, id), apiKey);
        r.execute();

        JsonElement x = new JsonParser().parse(r.getResponse().getBody());

        SummonerSpell summonerSpell = new Gson().fromJson(x, SummonerSpell.class);

        return summonerSpell;
    }
}
