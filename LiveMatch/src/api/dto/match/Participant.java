/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

import java.util.List;

/**
 *
 * @author Dennis
 */
public class Participant {
    private long championId;
    private String highestAchievedSeasonTier;
    private List<Mastery> masteries;
    private int participantId;
    private List<Rune> runes;
    
    private long spell1Id;
    private long spell2Id;
    
    private ParticipantStats stats;

    private long teamId;
    private ParticipantTimeline timeline;

    public long getChampionId() {
        return championId;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public int getParticipantId() {
        return participantId;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public ParticipantStats getStats() {
        return stats;
    }

    public long getTeamId() {
        return teamId;
    }

    public ParticipantTimeline getTimeline() {
        return timeline;
    }
    
    
}
