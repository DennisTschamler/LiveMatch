/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.stats;

/**
 *
 * @author Dennis
 */
public class ChampionStats {
    private int id;
    private AggregatedStats stats;

    public int getId() {
        return id;
    }

    public AggregatedStats getStats() {
        return stats;
    }
    
}
