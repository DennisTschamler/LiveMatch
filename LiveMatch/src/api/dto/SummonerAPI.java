/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

/**
 *
 * @author Dennis
 */
public class SummonerAPI {
    private int id;
    private String name;
    private int profileIconId;
    private long revisionDate;
    private long summonerLevel;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }
    
    
}
