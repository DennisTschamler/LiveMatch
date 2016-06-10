/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Utils.TextUtils;
import java.util.ArrayList;
import model.Region;

/**
 *
 * @author Dennis
 */
public class Query {
    
    public static String getSummonerByNames(Region region, ArrayList<String> names) {
        String summoners = TextUtils.seperateListByComma(names);
        String query = region.getName()+".api.pvp.net/api/lol/"+region.getName()+"/v1.4/summoner/by-name/"+summoners+"?";
        
        return query;
    }
    
    public static String getSummonerByIds(Region region, ArrayList<Integer> ids) {
        String summoners = TextUtils.seperateListByComma(ids);
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/v1.4/summoner/"+summoners+"?";
        
        return query;
    }
    
     public static String getLeagueByIds(Region region, ArrayList<Integer> ids) {
        String summoners = TextUtils.seperateListByComma(ids);
        String query =  region.getName() + ".api.pvp.net/api/lol/"+region.getName()+"/v2.5/league/by-summoner/"+summoners+"/entry?";
        
        return query;
    }
    
    public static String getCurrentGameBySummonerId(Region region, int summonerId) {
        String query =  region.getName() + ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/"+region.getCode()+"/"+summonerId+"?champData=image&";
        return query;
    }
    
    public static String getChampionById(Region region, int id) {
        String query =  "global.api.pvp.net/api/lol/static-data/"+region.getCode()+"/v1.2/champion/"+id+"?";
        return query;
    }
    
    public static String getSummonerSpellById(Region region, int id) {
        String query = "global.api.pvp.net/api/lol/static-data/"+region.getName()+"/v1.2/summoner-spell/"+id+"?spellData=image&";
        return query;
    }
}