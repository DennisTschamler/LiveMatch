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
public enum PlayerPosition {

    UNKNOWN(0, "NONE"),
    TOP(1, "TOP"),
    MIDDLE(2, "MIDDLE"),
    JUNGLE(3, "JUNGLE"),
    BOT(4, "BOT");

    private int id;
    private String name;
    
    private static Map<Integer, PlayerPosition> map = new HashMap<Integer, PlayerPosition>();

    static {
        for(PlayerPosition pos : PlayerPosition.values()) {
            map.put(pos.id, pos);
        }
    }
    private PlayerPosition(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    public static PlayerPosition valueOf(int value) {
        return map.get(value);
    }
}
