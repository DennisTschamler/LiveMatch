/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.summoner;

import Utils.ImageUtils;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import model.Champion;

/**
 *
 * @author Dennis
 */
public class MostPlayedChampionsView extends JPanel {

    private ArrayList<Champion> champions;

    public MostPlayedChampionsView(ArrayList<Champion> champions) {
        this.champions = champions;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));

        init();
    }

    private void init() {

        if (champions.size() != 0) {

            setLayout(new GridLayout(1, champions.size(), 5, 5));
            
            /*for (int i = 0; i < champions.size(); i++) {
                JLabel label = new JLabel((i+1)+".");
                label.setHorizontalAlignment(JLabel.CENTER);
                add(label);
            }*/

            for (Champion c : champions) {
                Image image = ImageUtils.resizeImage(c.getImageIcon().getImage(), 36, 36);
                JLabel championIcon = new JLabel(new ImageIcon(image));
                championIcon.setHorizontalAlignment(JLabel.CENTER);
                championIcon.setVerticalAlignment(JLabel.CENTER);
                championIcon.setForeground(Color.white);
                championIcon.setToolTipText(c.getName());
                add(championIcon);
            }
        }

    }
}
