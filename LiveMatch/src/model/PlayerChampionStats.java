/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dennis
 */
public class PlayerChampionStats {

    private String name;
    private String imageName;
    
    private float winrate = 0.0f;
    
    private int totalGamesPlayed = 0;
    
    private int totalKills = 0;
    private int totalAssits = 0;
    private int totalDeaths = 0;

    public PlayerChampionStats(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }
    
    public void setWinrate(float winrate) {
        this.winrate = winrate;
    }
    
    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }
    
    public void setTotalGamesPlayed(int total) {
        this.totalGamesPlayed = total;
    }
    
    public float getWinrate() {
        return winrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public ImageIcon getImageIcon() {
        System.out.println(imageName);
        return new ImageIcon(getClass().getResource("/assets/champions/"+imageName));
    }

    public int getTotalKills() {
        return totalKills;
    }

    public int getTotalAssits() {
        return totalAssits;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }
    
    public void setTotalKills(int totalChampionKills) {
       this.totalKills = totalChampionKills;
    }

    public void setTotalAssits(int totalAssists) {
       this.totalAssits = totalAssists;
    }

    public void setTotalDeaths(int totalDeathsPerSession) {
        this.totalDeaths = totalDeathsPerSession;
    }
    
}
