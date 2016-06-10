/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dennis
 */
public class HeaderView extends JPanel {
    public HeaderView() {
        setLayout(new GridLayout(1, 0));
        
        JLabel summonerLabel = new JLabel("Summoner");
        summonerLabel.setHorizontalAlignment(JLabel.CENTER);
        add(summonerLabel);
        
        JLabel championWinratioLabel = new JLabel("Champion winratio");
        championWinratioLabel.setHorizontalAlignment(JLabel.CENTER);
        add(championWinratioLabel);
        
        JLabel mostPlayedChampionsLabel = new JLabel("Most played champions");
        mostPlayedChampionsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(mostPlayedChampionsLabel);
        
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setHorizontalAlignment(JLabel.CENTER);
        add(rankLabel);
        
        JLabel winRatioLabel = new JLabel("Ranked winratio");
        winRatioLabel.setHorizontalAlignment(JLabel.CENTER);
        add(winRatioLabel);
    }
}
