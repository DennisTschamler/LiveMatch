/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

/**
 *
 * @author Dennis
 */
public class Player {

    private String matchHistoryUri;
    private int profileIcon;
    private long summonerId;
    private String summonerName;

    public String getMatchHistoryUri() {
        return matchHistoryUri;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }
}
