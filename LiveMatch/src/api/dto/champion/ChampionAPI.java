/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.champion;

import api.dto.ImageAPI;
import api.dto.InfoAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class ChampionAPI {
    private ArrayList<String> allytips;
    private String blurb;
    private ArrayList<String> enemytips;
    private int id;
    private ImageAPI image;
    private InfoAPI info;
    private String key;
    private String lore;
    private String name;
    private String partype;
    
    private PassiveAPI passive;
    private ArrayList<RecommendedAPI> recommended;
    private ArrayList<ChampionSpellAPI> spells;
    private StatsAPI stats;
    private ArrayList<String> tags;
    private String title;
}
