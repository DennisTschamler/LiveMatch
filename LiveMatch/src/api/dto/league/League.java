/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.league;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class League {
    private ArrayList<LeagueEntry> entries;
    private String name;
    private String queue;
    private String tier;

    public ArrayList<LeagueEntry> getEntries() {
        return entries;
    }

    public String getName() {
        return name;
    }

    public String getQueue() {
        return queue;
    }

    public String getTier() {
        return tier;
    }
    
    
}
