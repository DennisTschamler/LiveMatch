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
public class MapDetails {

    private Image image;
    private int mapId;
    private String mapName;
    private List<Long> unpurchasableItemList;

    public Image getImage() {
        return image;
    }

    public int getMapId() {
        return mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public List<Long> getUnpurchasableItemList() {
        return unpurchasableItemList;
    }
}
