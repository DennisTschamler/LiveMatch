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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

        setLayout(new GridLayout(0, 5, 0, 5));

        init();
    }

    private void init() {

        for (Champion c : champions) {
            Image image = ImageUtils.resizeImage(c.getImageIcon().getImage(), 36, 36);
            JLabel championIcon = new JLabel(new ImageIcon(image));
            championIcon.setToolTipText(c.getName());
            add(championIcon);
        }

    }
}
