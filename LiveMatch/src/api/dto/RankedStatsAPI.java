/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

import api.dto.champion.ChampionStatsAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class RankedStatsAPI {
    private ArrayList<ChampionStatsAPI> champions;
    private long modifyDate;
    private long summonerId;

    public ArrayList<ChampionStatsAPI> getChampions() {
        return champions;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public long getSummonerId() {
        return summonerId;
    }
    
}
