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
public class CurrentGameParticipant {
    private boolean bot;
    private long championId;
    private ArrayList<Mastery> masteries;
    private long profileIconId;
    private ArrayList<Rune> runes;
    
    private long spell1Id;
    private long spell2Id;
    
    private long summonerId;
    private String summonerName;
    private long teamId;

    public boolean isBot() {
        return bot;
    }

    public long getChampionId() {
        return championId;
    }

    public ArrayList<Mastery> getMasteries() {
        return masteries;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public ArrayList<Rune> getRunes() {
        return runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public long getTeamId() {
        return teamId;
    }
    
    
}
