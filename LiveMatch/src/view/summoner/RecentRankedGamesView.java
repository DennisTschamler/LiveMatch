/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.summoner;

import Utils.ImageUtils;
import api.constants.PlayerPosition;
import api.dto.game.GameAPI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
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
public class RecentRankedGamesView extends JPanel {
    
    private ArrayList<GameAPI> games;
    
    public RecentRankedGamesView(ArrayList<GameAPI> games) {
        this.games = games;
        
        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));

        if(games.size() != 0)
            setLayout(new GridLayout(0, games.size(), 5, 5));
        else
            setLayout(new GridLayout(0, 1));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));
        
        init();
    }
    
    private void init() {
        
        Collections.reverse(games);
        
        for(GameAPI g : games) {
            JPanel p = new JPanel();
            p.setBackground(Color.white);
            p.setLayout(new GridLayout(3, 0));
            
            System.out.println("Position: "+g.getStats().getPlayerPosition());
            
            JLabel position = new JLabel(PlayerPosition.valueOf(g.getStats().getPlayerPosition()).getName());
            position.setHorizontalAlignment(JLabel.CENTER);
            p.add(position);
            
            Image image = null;
            
            if(g.getStats().isWin()) {
                image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/check.png")).getImage(), 20, 20);
            } else {
                image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/wrong.png")).getImage(), 20, 20);
            }
            
            JLabel outcome = new JLabel(new ImageIcon(image));
            outcome.setToolTipText(PlayerPosition.valueOf(g.getStats().getPlayerPosition()).getName()+" - "+g.getStats().getChampionsKilled()+"/"+g.getStats().getNumDeaths()+"/"+g.getStats().getAssists());
            //outcome.setHorizontalAlignment(JLabel.CENTER);
            p.add(outcome);
            
            JLabel kda = new JLabel(g.getStats().getChampionsKilled()+"/"+g.getStats().getNumDeaths()+"/"+g.getStats().getAssists());
            kda.setFont(new Font("Arial", Font.PLAIN, 10));
            kda.setHorizontalAlignment(JLabel.CENTER);
            p.add(kda);
            
            add(p);
        }
    }
}
