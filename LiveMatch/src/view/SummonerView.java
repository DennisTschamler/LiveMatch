/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utils.ImageUtils;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Champion;
import model.Player;

/**
 *
 * @author Dennis
 */
public class SummonerView extends JPanel {

    Player player;

    JLabel summonerName;
    JLabel championName;

    JLabel championIcon;

    public SummonerView(Player summoner) {
        this.player = summoner;

        setLayout(new GridLayout(1, 0, 0, 10));
        setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        setBackground(Color.red);

        initSummonerName();
        initChampionWinrate();
        initMostPlayedChampions();
        //initRank();
        //initWinRatio();
        //initRankedStats();

    }

    private void initSummonerName() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(10,0,0,0)));
        panel.setLayout(new GridLayout(0, 1, 10, 0));

        Image image = ImageUtils.resizeImage(player.getChampion().getImageIcon().getImage(), 48, 48);
        championIcon = new JLabel(new ImageIcon(image));
        championIcon.setToolTipText(player.getChampion().getName());
        panel.add(championIcon);
        
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        
        image = ImageUtils.resizeImage(player.getSpell1().getImageIcon().getImage(), 24, 24);
        JLabel spell1 = new JLabel(new ImageIcon(image));
        spell1.setToolTipText(player.getSpell1().getName());
        p.add(spell1);
        
        image = ImageUtils.resizeImage(player.getSpell2().getImageIcon().getImage(), 24, 24);
        JLabel spell2 = new JLabel(new ImageIcon(image));
        spell2.setToolTipText(player.getSpell1().getName());
        p.add(spell2);
        panel.add(p);
        
        

        summonerName = new JLabel(player.getName());
        summonerName.setHorizontalAlignment(JLabel.CENTER);
        panel.add(summonerName);
 
        
        add(panel);
    }
    
    private void initChampionWinrate() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JLabel winrate = new JLabel(player.getChampion().getWinrate()*100+"% ("+player.getChampion().getTotalGamesPlayed()+")");
        winrate.setHorizontalAlignment(JLabel.CENTER);
        panel.add(winrate);
        
        add(panel);
    }

    private void initMostPlayedChampions() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3, 0, 10));

        for (Champion c : player.getMostPlayedChampions()) {
            Image image = ImageUtils.resizeImage(c.getImageIcon().getImage(), 24, 24);
            JLabel championLabel = new JLabel(new ImageIcon(image));
            panel.add(championLabel);
        }
        
        add(panel);
    }

    private void initRank() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        Image image = ImageUtils.resizeImage(player.getRankedStats().getTierIcon().getImage(), 24, 24);
        JLabel tierLabel = new JLabel(new ImageIcon(image));
        panel.add(tierLabel);

        JLabel tierDivision = new JLabel(player.getRankedStats().getTier() + " " + player.getRankedStats().getDivision());
        tierDivision.setHorizontalAlignment(JLabel.CENTER);
        panel.add(tierDivision);

        JLabel lp = new JLabel(player.getRankedStats().getLeaguePoints() + " LP");
        lp.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lp);

        add(panel);
    }

    private void initWinRatio() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        JLabel winRatio = new JLabel(df.format(player.getRankedStats().getWinRatio() * 100) + "%");
        winRatio.setHorizontalAlignment(JLabel.CENTER);
        panel.add(winRatio);

        add(panel);
    }

    private void initRankedStats() {
        JPanel panel = new JPanel();

        add(panel);
    }
}
