/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.summoner.SummonerNameView;
import view.summoner.RecentRankedGamesView;
import view.summoner.SeriesView;
import view.summoner.RankedWinratioView;
import view.summoner.MostPlayedChampionsView;
import view.summoner.CurrentSeasonView;
import view.summoner.ChampionStatsView;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import model.Player;
import view.summoner.LastSeasonView;

/**
 *
 * @author Dennis
 */
public class LiveMatchView extends JFrame {

    JPanel panel;
    private ArrayList<Player> team1;
    private ArrayList<Player> team2;
    
    JScrollPane pane;

    public LiveMatchView(ArrayList<Player> team1, ArrayList<Player> team2) {
        setTitle("test");

        this.team1 = team1;
        this.team2 = team2;

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(0, 8));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        init();
        
        getContentPane().add(panel);

        panel.setVisible(true);
        setVisible(true);
    }

    private void init() {

        initHeader(new Color(52, 152, 219));

        initTeam(team1);

        initHeader(new Color(231, 76, 60));
        
        initTeam(team2);
        
        pack();

    }

    private void initTeam(ArrayList<Player> team) {
        for (Player player : team) {

            // SUMMONER NAME
            panel.add(new SummonerNameView(player.getName(), player.getChampion().getImageIcon()));

            // CHAMPION
            panel.add(new ChampionStatsView(player.getChampion()));

            // MOST PLAYED CHAMPIONS
            panel.add(new MostPlayedChampionsView(player.getMostPlayedChampions()));

            // RECENT RANKED GAMES
            panel.add(new RecentRankedGamesView(player.getRecentRankedGames()));

            // CURRENT SEASON STATS
            panel.add(new CurrentSeasonView(player.getRankedStats()));

            if (player.getRankedStats() != null) {
                panel.add(new SeriesView(player.getRankedStats().getMiniSeries()));
            } else {
                panel.add(new SeriesView(null));
            }

            // LAST SEASON TIER
            panel.add(new LastSeasonView(player.getPreviousSeasonTier()));

            // RANKED WINRATIO
            panel.add(new RankedWinratioView(player.getRankedStats()));

        }
    }

    private void initHeader(Color color) {
        JLabel name = new JLabel("Name");
        name.setOpaque(true);
        name.setForeground(Color.white);
        name.setBackground(color);
        name.setHorizontalAlignment(JLabel.CENTER);
        panel.add(name);

        JLabel champion = new JLabel("Champion");
        champion.setOpaque(true);
        champion.setForeground(Color.white);
        champion.setBackground(color);
        champion.setHorizontalAlignment(JLabel.CENTER);
        panel.add(champion);

        JLabel mostPlayedChampions = new JLabel("Most played champions");
        mostPlayedChampions.setOpaque(true);
        mostPlayedChampions.setForeground(Color.white);
        mostPlayedChampions.setBackground(color);
        mostPlayedChampions.setHorizontalAlignment(JLabel.CENTER);
        panel.add(mostPlayedChampions);

        JLabel recentRankedGames = new JLabel("Recent ranked games");
        recentRankedGames.setOpaque(true);
        recentRankedGames.setForeground(Color.white);
        recentRankedGames.setBackground(color);
        recentRankedGames.setHorizontalAlignment(JLabel.CENTER);
        panel.add(recentRankedGames);

        JLabel rankedStats = new JLabel("Current Season");
        rankedStats.setOpaque(true);
        rankedStats.setForeground(Color.white);
        rankedStats.setBackground(color);
        rankedStats.setHorizontalAlignment(JLabel.CENTER);
        panel.add(rankedStats);

        JLabel series = new JLabel("Series");
        series.setOpaque(true);
        series.setForeground(Color.white);
        series.setBackground(color);
        series.setHorizontalAlignment(JLabel.CENTER);
        panel.add(series);

        JLabel lastSeason = new JLabel("Last Season");
        lastSeason.setOpaque(true);
        lastSeason.setForeground(Color.white);
        lastSeason.setBackground(color);
        lastSeason.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lastSeason);

        JLabel rankedWinrate = new JLabel("Ranked winrate");
        rankedWinrate.setOpaque(true);
        rankedWinrate.setForeground(Color.white);
        rankedWinrate.setBackground(color);
        rankedWinrate.setHorizontalAlignment(JLabel.CENTER);
        panel.add(rankedWinrate);
    }

}
