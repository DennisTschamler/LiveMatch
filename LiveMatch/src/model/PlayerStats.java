/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.dto.league.MiniSeries;
import javax.swing.ImageIcon;

/**
 *
 * @author Dennis
 */
public class PlayerStats {

    private String tier = "provisional";
    private String division = "i";
    
    boolean isInSeries = false;

    private int wins = 0;
    private int losses = 0;
    private int leaguePoints = 0;
    
    private MiniSeries miniSeries = null;
    
    private long summonerId;
    
    float winRatio = 0.0f;

    public PlayerStats(long summonerId, String tier, String division, int wins, int losses, int leaguePoints, MiniSeries miniSeries) {
        this.summonerId = summonerId;
        this.tier = tier;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.leaguePoints = leaguePoints;
        this.miniSeries = miniSeries;
        
        this.winRatio = (float) wins/(wins+losses);
    }

    public MiniSeries getMiniSeries() {
        return miniSeries;
    }
    
    public void setIsInSeries(boolean isInSeries) {
        this.isInSeries = isInSeries;
    }
    
    public boolean isInSeries() {
        return isInSeries;
    }
    
    public ImageIcon getTierIcon() {
        System.out.println(tier+" "+division);
        
        return new ImageIcon(getClass().getResource("/assets/base_icons/"+tier.toLowerCase()+".png"));
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

    public long getSummonerId() {
        return summonerId;
    }
    
    
}
