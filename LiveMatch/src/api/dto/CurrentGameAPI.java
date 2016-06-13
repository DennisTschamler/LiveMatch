/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.game;

import api.dto.ObserverAPI;
import api.dto.CurrentGameParticipantAPI;
import api.dto.champion.BannedChampionAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class CurrentGameAPI {
    private ArrayList<BannedChampionAPI> bannedChampions;
    private long gameId;
    private long gameLength;
    private String gameMode;
    private long gameQueueConfigId;
    private long gameStartTime;
    private String gameType;
    private long mapId;
    
    private ObserverAPI observers;
    
    private ArrayList<CurrentGameParticipantAPI> participants;
    
    private String platformId;

    public ArrayList<BannedChampionAPI> getBannedChampions() {
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

    public ObserverAPI getObservers() {
        return observers;
    }

    public ArrayList<CurrentGameParticipantAPI> getParticipants() {
        return participants;
    }

    public String getPlatformId() {
        return platformId;
    }
    
    
}
