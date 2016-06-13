/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.summoner;

import Utils.ImageUtils;
import api.constants.SeasonTier;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Dennis
 */
public class LastSeasonView extends JPanel {

    private SeasonTier tier;

    public LastSeasonView(SeasonTier tier) {
        this.tier = tier;
        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        setLayout(new GridLayout(2, 0));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));
        
        init();
    }

    private void init() {
        Image image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/base_icons/"+tier.getTier().toLowerCase()+".png")).getImage(), 36, 36);
        JLabel tierLabel = new JLabel(new ImageIcon(image));
        add(tierLabel);
        
        JLabel label = new JLabel(tier.getTier());
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}
