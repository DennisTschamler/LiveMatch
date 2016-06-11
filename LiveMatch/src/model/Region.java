/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dennis
 */
public enum Region {
    EUNE("eune", "EUN1"),
    EUW("euw", "EUW1");
    
    private String name, code;
    
    private Region(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
