/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.champion;

import api.dto.AggregatedStatsAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class ChampionStatsAPI {
    private int id;
    private AggregatedStatsAPI stats;

    public int getId() {
        return id;
    }

    public AggregatedStatsAPI getStats() {
        return stats;
    }
    
}
