/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dennis
 */
public enum SeasonTier {
    UNRANKED("UNRANKED"),
    BRONZE("BRONZE"),
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM"),
    DIAMOND("DIAMOND"),
    MASTER("MASTER"),
    CHALLENGER("CHALLENGER");

    private String tier;
    
    private static Map<String, SeasonTier> map = new HashMap<String, SeasonTier>();

    static {
        for(SeasonTier pos : SeasonTier.values()) {
            map.put(pos.tier, pos);
        }
    }
    private SeasonTier(String tier) {
        this.tier = tier;
    }

    public String getTier() {
        return tier;
    }
    public static SeasonTier valueOfTier(String value) {
        if(value != null)
            return map.get(value);
        
        return UNRANKED;
    }
}
