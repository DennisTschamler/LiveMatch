/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.static_data;

/**
 *
 * @author Dennis
 */
public class Passive {
    private String description;
    private Image image;
    private String name;
    private String sanitizedDescription;

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }
    
    
}
