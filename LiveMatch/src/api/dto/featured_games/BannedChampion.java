/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.featured_games;

/**
 *
 * @author Dennis
 */
public class BannedChampion {
    private long championId;
    private int pickTurn;
    private long teamId;

    public long getChampionId() {
        return championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public long getTeamId() {
        return teamId;
    }
    
    
}
