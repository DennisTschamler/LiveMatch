/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utils.ImageUtils;
import api.constants.PlayerPosition;
import api.dto.game.GameAPI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
                image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/check.png")).getImage(), 24, 24);
            } else {
                image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/wrong.png")).getImage(), 24, 24);
            }
            
            JLabel outcome = new JLabel(new ImageIcon(image));
            outcome.setHorizontalAlignment(JLabel.CENTER);
            p.add(outcome);
            
            JLabel kda = new JLabel(g.getStats().getChampionsKilled()+"/"+g.getStats().getNumDeaths()+"/"+g.getStats().getAssists());
            kda.setHorizontalAlignment(JLabel.CENTER);
            p.add(kda);
            
            add(p);
        }
    }
}
