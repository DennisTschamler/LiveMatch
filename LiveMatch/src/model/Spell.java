/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dennis
 */
public class Spell {
    String name;
    String imageName;
    
    public Spell(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/assets/summoner_spells/"+imageName));
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    
}
