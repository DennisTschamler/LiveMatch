/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Hashtable;

/**
 *
 * @author Dennis
 */
public class SummonerSpells {

    private Hashtable<Integer, Spell> spells;
    
    private static SummonerSpells instance = null;
    
    public static SummonerSpells getInstance() {
        if(instance == null) {
            instance = new SummonerSpells();
        }
        
        return instance;
    }

    public SummonerSpells() {
        spells = new Hashtable<>();

        spells.put(1, new Spell("Cleanse", "SummonerBoost.png"));
        spells.put(12, new Spell("Teleport", "SummonerTeleport.png"));
        spells.put(30, new Spell("To the King!", "SummonerPoroRecall.png"));
        spells.put(14, new Spell("Ignite", "SummonerDot.png"));
        spells.put(6, new Spell("Ghost", "SummonerHaste.png"));
        spells.put(32, new Spell("Mark", "SummonerSnowball.png"));
        spells.put(7, new Spell("Heal", "SummonerHeal.png"));
        spells.put(11, new Spell("Smite", "SummonerSmite.png"));
        spells.put(31, new Spell("Poro Toss", "SummonerPoroThrow.png"));
        spells.put(3, new Spell("Exhaust", "SummonerExhaust.png"));
        spells.put(13, new Spell("Clarity", "SummonerMana.png"));
        spells.put(2, new Spell("Clairvoyance", "SummonerClairvoyance.png"));
        spells.put(21, new Spell("Barrier", "SummonerBarrier.png"));
        spells.put(4, new Spell("Flash", "SummonerFlash.png"));
    }

    public Spell getSpellById(int id) {
        return spells.getOrDefault(id, new Spell("Exhaust", "Exhaust.png"));
    }
}
