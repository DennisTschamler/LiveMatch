/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.dto.champion.ChampionAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class Match {
    Team firstTeam;
    Team secondTeam;
    
    ArrayList<Champion> bannedChampions;
    
    public Match() {
        bannedChampions = new ArrayList<>();
        firstTeam = new Team();
        secondTeam = new Team();
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }    

    @Override
    public String toString() {
        String text = "";
        
        text += "===TEAM 1===\n";
        for(int i = 0; i < firstTeam.members.size(); i++) {
            Player s = firstTeam.members.get(i);
            text += s.getName()+" : "+s.getChampion().getName()+"\n";
            
            text += "MostPlayed: ";
            for(Champion c : s.getMostPlayedChampions()) {
                text += c.getName()+" ";
            }
            
            text += "\n";
        }
        
        System.out.println("===TEAM 2===");
        for(int i = 0; i < secondTeam.members.size(); i++) {
            Player s = secondTeam.members.get(i);
            text += s.getName()+" : "+s.getChampion().getName()+"\n";
            
            text += "MostPlayed: ";
            for(Champion c : s.getMostPlayedChampions()) {
                text += c.getName()+" ";
            }
            
            text += "\n";
        }
        
        return text;
    }    
}
