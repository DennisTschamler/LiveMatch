/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.champion;

/**
 *
 * @author Dennis
 */
public class ChampionMasteryAPI {
    private long championId;
    private int championLevel;
    private int championPoints;
    private long championPointsSinceLastLevel;
    private long championPointsUntilNextLevel;
    private boolean chestGranted;
    private String highestGrade;
    private long lastPlayTime;
    private long playerId;

    public long getChampionId() {
        return championId;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public String getHighestGrade() {
        return highestGrade;
    }

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public long getPlayerId() {
        return playerId;
    }
    
    
}
