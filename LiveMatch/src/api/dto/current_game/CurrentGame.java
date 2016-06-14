/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.current_game;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class CurrentGame {
    private ArrayList<BannedChampion> bannedChampions;
    private long gameId;
    private long gameLength;
    private String gameMode;
    private long gameQueueConfigId;
    private long gameStartTime;
    private String gameType;
    private long mapId;
    
    private Observer observers;
    
    private ArrayList<CurrentGameParticipant> participants;
    
    private String platformId;

    public ArrayList<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public long getGameId() {
        return gameId;
    }

    public long getGameLength() {
        return gameLength;
    }

    public String getGameMode() {
        return gameMode;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public String getGameType() {
        return gameType;
    }

    public long getMapId() {
        return mapId;
    }

    public Observer getObservers() {
        return observers;
    }

    public ArrayList<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    public String getPlatformId() {
        return platformId;
    }
    
    
}
