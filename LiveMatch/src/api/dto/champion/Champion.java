/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.champion;

/**
 *
 * @author Dennis
 */
public class Champion {
    private boolean active;
    private boolean botEnabld;
    private boolean botMmEnambled;
    private boolean freeToPlay;
    private long id;
    private boolean rankedPlayEnabled;

    public boolean isActive() {
        return active;
    }

    public boolean isBotEnabld() {
        return botEnabld;
    }

    public boolean isBotMmEnambled() {
        return botMmEnambled;
    }

    public boolean isFreeToPlay() {
        return freeToPlay;
    }

    public long getId() {
        return id;
    }

    public boolean isRankedPlayEnabled() {
        return rankedPlayEnabled;
    }
    
    
}
