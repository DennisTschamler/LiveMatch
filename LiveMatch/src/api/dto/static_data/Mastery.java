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
public class Mastery {

    private List<String> description;
    private int id;
    private Image image;
    private String masteryTree;
    private String name;
    private String prereq;
    private int ranks;
    private List<String> sanitizedDescription;

    public List<String> getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    /**
     * Legal values: Defense, Offense, Utility
     */
    public String getMasteryTree() {
        return masteryTree;
    }

    public String getName() {
        return name;
    }

    public String getPrereq() {
        return prereq;
    }

    public int getRanks() {
        return ranks;
    }

    public List<String> getSanitizedDescription() {
        return sanitizedDescription;
    }
}
