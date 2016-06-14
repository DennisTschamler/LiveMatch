/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.featured_games;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class FeaturedGames {
    private long clientRefreshInterval;
    private ArrayList<FeaturedGameInfo> gameList;

    public long getClientRefreshInterval() {
        return clientRefreshInterval;
    }

    public ArrayList<FeaturedGameInfo> getGameList() {
        return gameList;
    }
    
    
}
