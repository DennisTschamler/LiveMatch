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
public class PlayerStatsSummary {
    private AggregatedStats aggregatedStats;
    private int losses;
    private long modifyDate;
    private String playerStatSummaryType;
    private int wins;

    public AggregatedStats getAggregatedStats() {
        return aggregatedStats;
    }

    public int getLosses() {
        return losses;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public String getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public int getWins() {
        return wins;
    }
    
    
}
