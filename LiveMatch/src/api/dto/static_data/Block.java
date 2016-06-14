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
public class Block {
    private List<BlockItem> items;
    private boolean recMath;
    private String type;

    public List<BlockItem> getItems() {
        return items;
    }

    public boolean isRecMath() {
        return recMath;
    }

    public String getType() {
        return type;
    }
    
    
}
