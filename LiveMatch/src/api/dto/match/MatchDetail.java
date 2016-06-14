/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class MatchDetail {
    private int mapId;
    private long matchCreation;
    private long matchDuration;
    private long matchId;
    private String matchMode;
    private String matchType;
    private String matchVersion;
    private ArrayList<ParticipantIdentity> participantIdentities;
    private ArrayList<Participant> participants;
    private String platformId;
    private String queueType;
    private String region;
    private String season;
    private ArrayList<Team> teams;
    private Timeline timeline;

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

    public ArrayList<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    public ArrayList<Participant> getParticipants() {
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

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public Timeline getTimeline() {
        return timeline;
    }
    
    
}
