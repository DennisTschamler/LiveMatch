/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utils.ImageUtils;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Dennis
 */
public class SummonerNameView extends JPanel {

    private String name;
    private ImageIcon imageIcon;

    public SummonerNameView(String name, ImageIcon imageIcon) {
        this.name = name;
        this.imageIcon = imageIcon;
        
        setBackground(Color.white);
        setBorder(new MatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY));
        setLayout(new GridLayout(0, 2));

        init();
    }

    private void init() {
        
        Image image = ImageUtils.resizeImage(imageIcon.getImage(), 48, 48);
        add(new JLabel(new ImageIcon(image)));
        
        add(new JLabel(name));    
    }
}
