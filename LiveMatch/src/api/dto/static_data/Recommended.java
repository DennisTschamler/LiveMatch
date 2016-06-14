/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.static_data;

import java.util.List;

/**
 *
 * @author Dennis
 */
public class Recommended {
    private List<Block> blocks;
    private String champion;
    private String map;
    private String mode;
    private boolean priority;
    private String title;
    private String type;

    public List<Block> getBlocks() {
        return blocks;
    }

    public String getChampion() {
        return champion;
    }

    public String getMap() {
        return map;
    }

    public String getMode() {
        return mode;
    }

    public boolean isPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
    
}
