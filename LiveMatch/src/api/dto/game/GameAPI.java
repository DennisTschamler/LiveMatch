/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.game;

import api.dto.PlayerAPI;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class GameAPI {
    private int championId;
    private long createDate;
    private ArrayList<PlayerAPI> fellowPlayers;
    private long gameId;
    private String gameMode;
    private String gameType;
    private boolean invalid;
    private int ipEarned;
    private int level;
    private int mapId;
    private int spell1;
    private int spell2;
    private RawStatsAPI stats;
    private String subType;
    private int teamId;

    public int getChampionId() {
        return championId;
    }

    public long getCreateDate() {
        return createDate;
    }

    public ArrayList<PlayerAPI> getFellowPlayers() {
        return fellowPlayers;
    }

    public long getGameId() {
        return gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public int getIpEarned() {
        return ipEarned;
    }

    public int getLevel() {
        return level;
    }

    public int getMapId() {
        return mapId;
    }

    public int getSpell1() {
        return spell1;
    }

    public int getSpell2() {
        return spell2;
    }

    public RawStatsAPI getStats() {
        return stats;
    }

    public String getSubType() {
        return subType;
    }

    public int getTeamId() {
        return teamId;
    }
    
    
}
