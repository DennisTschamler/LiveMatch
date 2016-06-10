/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.dto.champion.ChampionAPI;
import api.dto.summoner.SummonerSpellAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class Player {
    private String name;
    private int id;
    
    private Spell spell1;
    private Spell spell2;
    
    private Champion champion;
    
    private RankedStats rankedStats;
    
    private ArrayList<Champion> mostPlayedChampions;
    
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Spell getSpell1() {
        return spell1;
    }

    public Spell getSpell2() {
        return spell2;
    }
    
    public RankedStats getRankedStats() {
        return rankedStats;
    }
    
    public void setRankedStats(RankedStats rankedStats) {
        this.rankedStats = rankedStats;
    }
    
    public ArrayList<Champion> getMostPlayedChampions() {
        return mostPlayedChampions;
    }
    
    public void setMostPlayedChampions(ArrayList<Champion> list) {
        mostPlayedChampions = list;
    }
    
    public void setSpells(Spell spell1, Spell spell2) {
        this.spell1 = spell1;
        this.spell2 = spell2;
    }
    
    public void setChampion(Champion ch) {
        this.champion = ch;
    }
    
    public Champion getChampion() {
        return champion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}