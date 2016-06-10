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
public class Champion {

    private String name;
    private String imageName;
    
    private float winrate;
    
    private int totalGamesPlayed;

    public Champion(String name, String imageName) {
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
    
}
