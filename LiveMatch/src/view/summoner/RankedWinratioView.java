/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.summoner;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import model.PlayerStats;

/**
 *
 * @author Dennis
 */
public class RankedWinratioView extends JPanel{
    private PlayerStats rankedStats;
    
    public RankedWinratioView(PlayerStats rankedStats) {
        this.rankedStats = rankedStats;
        
        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        setLayout(new GridLayout(0, 1));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));
        
        init();
                
    }
    
    private void init() {
        if(rankedStats != null) {            
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            
            JLabel winrate = new JLabel(df.format(rankedStats.getWinRatio()*100) + "%" + " ("+(rankedStats.getLosses()+rankedStats.getWins())+")");
            
            if(rankedStats.getWinRatio() >= 0.50f) {
                winrate.setForeground(new Color(46, 204, 113));
            } else {
                winrate.setForeground(new Color(231, 76, 60));
            }
            
            winrate.setHorizontalAlignment(JLabel.CENTER);
            add(winrate);
            
        } else {
            JLabel label = new JLabel("No games in ranked");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }
    }
}
