/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.summoner;

import Utils.ImageUtils;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import model.RankedStats;

/**
 *
 * @author Dennis
 */
public class CurrentSeasonView extends JPanel {

    private RankedStats rankedStats;

    public CurrentSeasonView(RankedStats rankedStats) {
        this.rankedStats = rankedStats;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        setLayout(new GridLayout(0, 1, 5, 5));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));

        init();
    }

    private void init() {
        if (rankedStats != null) {
            Image image = ImageUtils.resizeImage(rankedStats.getTierIcon().getImage(), 24, 24);
            JLabel tierLabel = new JLabel(new ImageIcon(image));
            add(tierLabel);

            JLabel tierDivision = new JLabel(rankedStats.getTier() + " " + rankedStats.getDivision());
            tierDivision.setHorizontalAlignment(JLabel.CENTER);
            add(tierDivision);

            JLabel lp = new JLabel(rankedStats.getLeaguePoints() + " LP");
            lp.setHorizontalAlignment(JLabel.CENTER);
            add(lp);

        } else {
            Image image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/tier_icons/provisional.png")).getImage(), 48, 48);
            JLabel tierLabel = new JLabel(new ImageIcon(image));
            add(tierLabel);
        }

    }
}
