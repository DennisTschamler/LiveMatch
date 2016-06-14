/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

/**
 *
 * @author Dennis
 */
public enum Region {
    EUNE("EUN1", "eune"),
    EUW("EUW1", "euw");
    
    private String id;
    private String name;
    
    private Region(String id, String name) {
        this.id = id;
        this.name = name;   
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
