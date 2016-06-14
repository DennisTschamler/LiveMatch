/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.stats;

import java.util.List;

/**
 *
 * @author Dennis
 */
public class PlayerStatsSummaryList {
    private List<PlayerStatsSummary> playerStatSummaries;
    private long summonerId;

    public List<PlayerStatsSummary> getPlayerStatSummaries() {
        return playerStatSummaries;
    }

    public long getSummonerId() {
        return summonerId;
    }
    
    
}
