/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import model.Champion;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author Dennis
 */
public class ChampionStatsView extends JPanel {

    private Champion champion;

    public ChampionStatsView(Champion champion) {
        this.champion = champion;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.lightGray));
        setLayout(new GridLayout(0, 1));

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
            averageKills = (float) totalGames / totalKills;
        }

        if (totalDeaths != 0) {
            averageDeaths = (float) totalGames / totalDeaths;
        }

        if (totalAssists != 0) {
            averageAssists = (float) totalGames / totalAssists;
        }

        df.setMaximumFractionDigits(1);
        JLabel kda = new JLabel(df.format(averageKills) + "/" + df.format(averageDeaths) + "/" + df.format(averageAssists));

        df.setMaximumFractionDigits(2);
        JLabel label = new JLabel(df.format(champion.getWinrate() * 100) + "% (" + champion.getTotalGamesPlayed() + ")");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}
