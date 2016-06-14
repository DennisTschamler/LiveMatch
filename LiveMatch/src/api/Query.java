/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import api.dto.Region;
import api.dto.Version;
import cz.dennistschamler.riotapi.api.utils.TextUtils;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Dennis
 */
public class Query {
        
    public static String getSummonerByNames(Region region, List<String> names) {
        String summoners = TextUtils.seperateListByComma(names);
        String query = region.getName()+".api.pvp.net/api/lol/"+region.getName()+"/"+Version.SUMMONER+"/summoner/by-name/"+summoners+"?";
        
        return query;
    }
    
    public static String getChampionStatsBySummonerId(Region region, int summonerId) {
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/"+Version.STATS+"/stats/by-summoner/"+summonerId+"/ranked?";
        
        return query;
    }
    
    public static String getRecentGamesBySummonerId(Region region, int summonerId) {
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/"+Version.GAME+"/game/by-summoner/"+summonerId+"/recent?";
        
        return query;
    }
    
    public static String getSummonerByIds(Region region, ArrayList<Integer> ids) {
        String summoners = TextUtils.seperateListByComma(ids);
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/"+Version.SUMMONER+"/summoner/"+summoners+"?";
        
        return query;
    }
    
     public static String getLeagueByIds(Region region, ArrayList<Integer> ids) {
        String summoners = TextUtils.seperateListByComma(ids);
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/"+Version.LEAGUE+"/league/by-summoner/"+summoners+"/entry?";
        
        return query;
    }
    
    public static String getCurrentGameBySummonerId(Region region, long summonerId) {
        String query =  region.getName() + ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/"+region.getId()+"/"+summonerId+"?";
        return query;
    }
    
    public static String getMatchById(Region region, long id) {
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/"+Version.MATCH+"/match/"+id+"?";
        return query;
    }
    
    public static String getChampionById(Region region, int id) {
        String query =  "global.api.pvp.net/api/lol/static-data/"+region.getName()+"/"+Version.LOL_STATIC_DATA+"/champion/"+id+"?champData=image&";
        return query;
    }
    
    public static String getTopChampionsBySummonerId(Region region, int summonerId, int count) {
        String query =  region.getName()+".api.pvp.net/championmastery/location/"+region.getId()+"/player/"+summonerId+"/topchampions?count="+count+"&";
        return query;
    }
    
    public static String getSummonerSpellById(Region region, int id) {
        String query = "global.api.pvp.net/api/lol/static-data/"+region.getName()+"/"+Version.LOL_STATIC_DATA+"/summoner-spell/"+id+"?spellData=image&";
        return query;
    }
}
