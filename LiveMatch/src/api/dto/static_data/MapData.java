/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.static_data;

import java.util.Map;

/**
 *
 * @author Dennis
 */
public class MapData {

    private Map<String, MapDetails> data;
    private String type;
    private String version;

    public Map<String, MapDetails> getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }
}
