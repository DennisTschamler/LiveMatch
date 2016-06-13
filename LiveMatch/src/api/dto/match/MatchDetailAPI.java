/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

import api.dto.match.ParticipantAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class MatchDetailAPI {
    private int mapId;
    private long matchCreation;
    private long matchDuration;
    private long matchId;
    private String matchMode;
    private String matchType;
    private String matchVersion;
    private ArrayList<ParticipantIdentityAPI> participantIdentities;
    private ArrayList<ParticipantAPI> participants;
    private String platformId;
    private String queueType;
    private String region;
    private String season;
    private ArrayList<TeamAPI> teams;
    private TimelineAPI timeline;

    public int getMapId() {
        return mapId;
    }

    public long getMatchCreation() {
        return matchCreation;
    }

    public long getMatchDuration() {
        return matchDuration;
    }

    public long getMatchId() {
        return matchId;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public String getMatchType() {
        return matchType;
    }

    public String getMatchVersion() {
        return matchVersion;
    }

    public ArrayList<ParticipantIdentityAPI> getParticipantIdentities() {
        return participantIdentities;
    }

    public ArrayList<ParticipantAPI> getParticipants() {
        return participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getQueueType() {
        return queueType;
    }

    public String getRegion() {
        return region;
    }

    public String getSeason() {
        return season;
    }

    public ArrayList<TeamAPI> getTeams() {
        return teams;
    }

    public TimelineAPI getTimeline() {
        return timeline;
    }
    
    
}
