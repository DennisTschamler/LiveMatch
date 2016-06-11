/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utils.ImageUtils;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import model.Champion;
import model.Match;
import model.Player;
import model.RankedStats;
import model.Spell;
import model.Team;

/**
 *
 * @author Dennis
 */
public class LiveMatchView extends JFrame {

    JPanel panel;
    private ArrayList<Player> team1;
    private ArrayList<Player> team2;

    public LiveMatchView(ArrayList<Player> team1, ArrayList<Player> team2) {
        setTitle("test");

        this.team1 = team1;
        this.team2 = team2;

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(0, 7));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        getContentPane().add(panel);

        
        init();
        pack();
        setVisible(true);
    }

    private void init() {

        /* Match match = new Match();

         Player summ1 = new Player("ahoj", 54);
         summ1.setChampion(new Champion("Caitlyn", "Caitlyn.png"));
         summ1.setRankedStats(new RankedStats("platinum", "IV", 10, 12, 20));
         summ1.setSpells(new Spell("Flash", "SummonerFlash.png"), new Spell("Teleport", "SummonerTeleport.png"));

         ArrayList<Champion> champs = new ArrayList<>();
         champs.add(new Champion("Cait", "Caitlyn.png"));
         champs.add(new Champion("Amumu", "Amumu.png"));
         champs.add(new Champion("Aatrox", "Aatrox.png"));

         summ1.setMostPlayedChampions(champs);

         Player summ2 = new Player("ahoj", 54);
         summ2.setChampion(new Champion("Thresh", "Thresh.png"));
         summ2.setRankedStats(new RankedStats("platinum", "IV", 10, 12, 20));
         summ2.setMostPlayedChampions(champs);
         summ2.setSpells(new Spell("Flash", "SummonerFlash.png"), new Spell("Teleport", "SummonerTeleport.png"));

         ArrayList<Player> players = new ArrayList<>();

         players.add(summ1);
         players.add(summ2);
         players.add(summ1);
         players.add(summ2);
         players.add(summ1);

         ArrayList<Boolean> lastFiveGames = new ArrayList<>();

         lastFiveGames.add(true);
         lastFiveGames.add(false);
         lastFiveGames.add(false);
         lastFiveGames.add(false);
         lastFiveGames.add(true);

         summ1.setLastFiveGames(lastFiveGames);
         summ2.setLastFiveGames(lastFiveGames);

         */
        initHeader(new Color(52, 152, 219));

        for (Player player : team1) {

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

            // SERIES
            panel.add(new SeriesView(player.getRankedStats().getMiniSeries()));
            
            
            // RANKED WINRATIO
            panel.add(new RankedWinratioView(player.getRankedStats()));

        }

        initHeader(new Color(231, 76, 60));

        for (Player player : team2) {

            //initSummonerName(player.getName());
            
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
            
            // SERIES
            panel.add(new SeriesView(player.getRankedStats().getMiniSeries()));
                        
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

        JLabel rankedWinrate = new JLabel("Ranked winrate");
        rankedWinrate.setOpaque(true);
        rankedWinrate.setForeground(Color.white);
        rankedWinrate.setBackground(color);
        rankedWinrate.setHorizontalAlignment(JLabel.CENTER);
        panel.add(rankedWinrate);
    }

}
