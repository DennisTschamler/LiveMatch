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
public class MasteryList {

    private Map<String, Mastery> data;
    private MasteryTree tree;
    private String type;
    private String version;

    public Map<String, Mastery> getData() {
        return data;
    }

    public MasteryTree getTree() {
        return tree;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }
}
