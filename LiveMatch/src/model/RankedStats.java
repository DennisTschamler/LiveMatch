/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dennis
 */
public class RankedStats {

    private String tier;
    private String division;
    
    boolean isInSeries = false;

    private int wins;
    private int losses;
    private int leaguePoints;
    
    
    float winRatio;

    public RankedStats(String tier, String division, int wins, int losses, int leaguePoints) {
        this.tier = tier;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.leaguePoints = leaguePoints;
        
        this.winRatio = (float) wins/(wins+losses);
    }
    
    public void setIsInSeries(boolean isInSeries) {
        this.isInSeries = isInSeries;
    }
    
    public boolean isInSeries() {
        return isInSeries;
    }
    
    public ImageIcon getTierIcon() {
        return new ImageIcon(getClass().getResource("/assets/tier_icons/"+tier.toLowerCase()+"_"+division.toLowerCase()+".png"));
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public float getWinRatio() {
        return winRatio;
    }
}
