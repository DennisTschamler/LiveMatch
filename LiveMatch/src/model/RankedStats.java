/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.dto.MiniSeriesAPI;
import javax.swing.ImageIcon;

/**
 *
 * @author Dennis
 */
public class RankedStats {

    private String tier = "";
    private String division = "";
    
    boolean isInSeries = false;

    private int wins = 0;
    private int losses = 0;
    private int leaguePoints = 0;
    
    private MiniSeriesAPI miniSeries = null;
    
    private long summoenerId;
    
    float winRatio = 0.0f;

    public RankedStats(long summonerId, String tier, String division, int wins, int losses, int leaguePoints, MiniSeriesAPI miniSeries) {
        this.summoenerId = summonerId;
        this.tier = tier;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.leaguePoints = leaguePoints;
        this.miniSeries = miniSeries;
        
        this.winRatio = (float) wins/(wins+losses);
    }

    public MiniSeriesAPI getMiniSeries() {
        return miniSeries;
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

    public long getSummoenerId() {
        return summoenerId;
    }
    
    
}
