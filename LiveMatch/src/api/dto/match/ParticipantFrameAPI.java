/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

/**
 *
 * @author Dennis
 */
public class ParticipantFrameAPI {

    private int currentGold;
    private int dominionScore;
    private int jungleMinionsKilled;
    private int level;
    private int minionsKilled;
    private int participantId;
    private PositionAPI position;
    private int teamScore;
    private int totalGold;
    private int xp;

    public int getCurrentGold() {
        return currentGold;
    }

    public int getDominionScore() {
        return dominionScore;
    }

    public int getJungleMinionsKilled() {
        return jungleMinionsKilled;
    }

    public int getLevel() {
        return level;
    }

    public int getMinionsKilled() {
        return minionsKilled;
    }

    public int getParticipantId() {
        return participantId;
    }

    public PositionAPI getPosition() {
        return position;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public int getXp() {
        return xp;
    }
}
