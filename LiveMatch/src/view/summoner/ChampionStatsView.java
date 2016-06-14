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
import model.PlayerChampionStats;

/**
 *
 * @author Dennis
 */
public class ChampionStatsView extends JPanel {

    private PlayerChampionStats champion;

    public ChampionStatsView(PlayerChampionStats champion) {
        this.champion = champion;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.lightGray));
        setLayout(new GridLayout(2, 0));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));

        init();
    }

    private void init() {

        DecimalFormat df = new DecimalFormat();

        int totalKills = champion.getTotalKills();
        int totalDeaths = champion.getTotalDeaths();
        int totalAssists = champion.getTotalAssits();

        int totalGames = champion.getTotalGamesPlayed();

        float averageKills = 0.0f;
        float averageDeaths = 0.0f;
        float averageAssists = 0.0f;

        if (totalKills != 0) {
            averageKills = (float) totalKills / totalGames;
        }

        if (totalDeaths != 0) {
            averageDeaths = (float) totalDeaths / totalGames;
        }

        if (totalAssists != 0) {
            averageAssists = (float) totalAssists / totalGames;
        }

        df.setMaximumFractionDigits(1);
        JLabel kda = new JLabel(df.format(averageKills) + " / " + df.format(averageDeaths) + " / " + df.format(averageAssists));
        kda.setHorizontalAlignment(JLabel.CENTER);
        add(kda);

        df.setMaximumFractionDigits(2);
        JLabel label = new JLabel(df.format(champion.getWinrate() * 100) + "% (" + champion.getTotalGamesPlayed() + ")");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}
