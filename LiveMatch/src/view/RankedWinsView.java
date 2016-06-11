/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import model.RankedStats;

/**
 *
 * @author Dennis
 */
public class RankedWinsView extends JPanel {

    private RankedStats rankedStats;

    public RankedWinsView(RankedStats rankedStats) {
        this.rankedStats = rankedStats;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        setLayout(new GridLayout(0, 2, 5, 0));

        init();
    }

    private void init() {
        if (rankedStats != null) {
            JLabel winsLabel = new JLabel(rankedStats.getWins() + "");
            winsLabel.setHorizontalAlignment(JLabel.CENTER);
            winsLabel.setForeground(new Color(46, 204, 113));
            add(winsLabel);

            JLabel lossesLabel = new JLabel(rankedStats.getLosses() + "");
            lossesLabel.setHorizontalAlignment(JLabel.CENTER);
            lossesLabel.setForeground(new Color(231, 76, 60));
            add(lossesLabel);
        } else {
            setLayout(new GridLayout(0, 1));
            
            JLabel label = new JLabel("No games in ranked");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }
    }
}
