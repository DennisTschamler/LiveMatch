/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

import api.dto.summoner.MasteryAPI;
import api.dto.summoner.RuneAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class ParticipantAPI {
    private long championId;
    private String highestAchievedSeasonTier;
    private ArrayList<MasteryAPI> masteries;
    private int participantId;
    private ArrayList<RuneAPI> runes;
    
    private long spell1Id;
    private long spell2Id;
    
    private ParticipantStatsAPI stats;

    private long teamId;
    private ParticipantTimelineAPI timeline;

    public long getChampionId() {
        return championId;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public ArrayList<MasteryAPI> getMasteries() {
        return masteries;
    }

    public int getParticipantId() {
        return participantId;
    }

    public ArrayList<RuneAPI> getRunes() {
        return runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public ParticipantStatsAPI getStats() {
        return stats;
    }

    public long getTeamId() {
        return teamId;
    }

    public ParticipantTimelineAPI getTimeline() {
        return timeline;
    }
    
    
}
