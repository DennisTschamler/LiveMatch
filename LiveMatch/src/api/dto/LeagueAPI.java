/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class LeagueAPI {
    private ArrayList<LeagueEntryAPI> entries;
    private String name;
    private String queue;
    private String tier;

    public ArrayList<LeagueEntryAPI> getEntries() {
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
