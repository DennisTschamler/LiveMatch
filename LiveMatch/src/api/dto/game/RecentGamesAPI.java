/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.game;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class RecentGamesAPI {
    private long summonerId;
    private ArrayList<GameAPI> games;

    public long getSummonerId() {
        return summonerId;
    }

    public ArrayList<GameAPI> getGames() {
        return games;
    }
}
