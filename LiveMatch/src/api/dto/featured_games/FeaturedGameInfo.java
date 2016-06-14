/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.featured_games;

import java.util.List;

/**
 *
 * @author Dennis
 */
public class FeaturedGameInfo {
    private List<BannedChampion> bannedChampions;
    private long gameId;
    private long gameLength;
    private String gameMode;
    private long gameQueueConfigId;
    private long gameStartTime;
    private String gameType;
    private long mapId;
    private Observer observers;
    private List<Participant> participants;
    private String platformId;

    public List<BannedChampion> getBannedChampions() {
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

    public List<Participant> getParticipants() {
        return participants;
    }

    public String getPlatformId() {
        return platformId;
    }
    
    
}
