/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.league;

/**
 *
 * @author Dennis
 */
public class MiniSeries {
    private int losses;
    private String progress;
    private int target;
    private int wins;

    public int getLosses() {
        return losses;
    }

    public String getProgress() {
        return progress;
    }

    public int getTarget() {
        return target;
    }

    public int getWins() {
        return wins;
    }
    
    
}
