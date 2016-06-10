/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.summoner;

import api.dto.ImageAPI;

/**
 *
 * @author Dennis
 */
public class SummonerSpellAPI {
    private int id;
    private String description;
    private String name;
    private ImageAPI image;
    private String key;
    private int summmonerLevel;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public ImageAPI getImage() {
        return image;
    }

    public String getKey() {
        return key;
    }

    public int getSummmonerLevel() {
        return summmonerLevel;
    }
    
    
}
