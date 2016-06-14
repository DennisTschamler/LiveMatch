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
public class Event {

    private String ascendedType;
    private ArrayList<Integer> assistingParticipantIds;
    private String buildingType;
    private int creatorId;
    private String eventType;
    private int itemAfter;
    private int itemBefore;
    private int itemId;
    private int killerId;
    private String laneType;
    private String levelUpType;
    private String monsterType;
    private int participantId;
    private String pointCaptured;
    private Position position;
    private int skillSlot;
    private int teamId;
    private long timestamp;
    private String towerType;
    private int victimId;
    private String wardType;

    public String getAscendedType() {
        return ascendedType;
    }

    public ArrayList<Integer> getAssistingParticipantIds() {
        return assistingParticipantIds;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public String getEventType() {
        return eventType;
    }

    public int getItemAfter() {
        return itemAfter;
    }

    public int getItemBefore() {
        return itemBefore;
    }

    public int getItemId() {
        return itemId;
    }

    public int getKillerId() {
        return killerId;
    }

    public String getLaneType() {
        return laneType;
    }

    public String getLevelUpType() {
        return levelUpType;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getPointCaptured() {
        return pointCaptured;
    }

    public Position getPosition() {
        return position;
    }

    public int getSkillSlot() {
        return skillSlot;
    }

    public int getTeamId() {
        return teamId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getTowerType() {
        return towerType;
    }

    public int getVictimId() {
        return victimId;
    }

    public String getWardType() {
        return wardType;
    }
}
