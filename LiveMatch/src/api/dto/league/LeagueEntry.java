/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.league;

/**
 *
 * @author Dennis
 */
public class LeagueEntry {
    private String division;
    private boolean isFreshBlood;
    private boolean isHotStreak;
    private boolean isInactive;
    private boolean isVeteran;
    private int leaguePoints;
    private int losses;
    private MiniSeries miniSeries = null;
    private String playerOrTeamId;
    private String playerOrTeamName;
    private int wins;

    public String getDivision() {
        return division;
    }

    public boolean isIsFreshBlood() {
        return isFreshBlood;
    }

    public boolean isIsHotStreak() {
        return isHotStreak;
    }

    public boolean isIsInactive() {
        return isInactive;
    }

    public boolean isIsVeteran() {
        return isVeteran;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getLosses() {
        return losses;
    }

    public MiniSeries getMiniSeries() {
        return miniSeries;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public int getWins() {
        return wins;
    }
    
    
}
