/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.constants.SeasonTier;
import api.dto.game.Game;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class Player {
    private String name;
    private int id;
    
    private int teamId;
    
    private Spell spell1;
    private Spell spell2;
    
    private PlayerChampionStats champion;
    
    private PlayerStats rankedStats = null;
    
    private ArrayList<PlayerChampionStats> mostPlayedChampions;
    private ArrayList<Game> recentRankedGames;
    
    private SeasonTier previousSeasonTier = SeasonTier.UNRANKED;
    
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setTeamId(int id) {
        this.teamId = id;
    }
    
    public int getTeamId() {
        return teamId;
    }
    
    public Spell getSpell1() {
        return spell1;
    }

    public Spell getSpell2() {
        return spell2;
    }
    
    public PlayerStats getRankedStats() {
        return rankedStats;
    }
    
    public void setRankedStats(PlayerStats rankedStats) {
        this.rankedStats = rankedStats;
    }

    public void setRecentRankedGames(ArrayList<Game> recentRankedGames) {
        this.recentRankedGames = recentRankedGames;
    }
    
    public ArrayList<Game> getRecentRankedGames() {
        return recentRankedGames;
    }    
    
    public ArrayList<PlayerChampionStats> getMostPlayedChampions() {
        return mostPlayedChampions;
    }
    
    
    public void setMostPlayedChampions(ArrayList<PlayerChampionStats> list) {
        mostPlayedChampions = list;
    }
    
    public void setSpells(Spell spell1, Spell spell2) {
        this.spell1 = spell1;
        this.spell2 = spell2;
    }
    
    public void setChampionStats(PlayerChampionStats ch) {
        this.champion = ch;
    }
    
    public PlayerChampionStats getChampionStats() {
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

    public SeasonTier getPreviousSeasonTier() {
        return previousSeasonTier;
    }

    public void setPreviousSeasonTier(SeasonTier previousSeasonTier) {
        this.previousSeasonTier = previousSeasonTier;
    }
}
