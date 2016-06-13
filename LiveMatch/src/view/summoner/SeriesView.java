/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.summoner;

import Utils.ImageUtils;
import api.dto.MiniSeriesAPI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
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
public class SeriesView extends JPanel {

    private MiniSeriesAPI miniSeries;
    
    private boolean SHOW_SUMMONER_NAME = true;
    private boolean SHOW_CHAMPION_WINRATE = true;

    public SeriesView(MiniSeriesAPI miniSeries) {
        this.miniSeries = miniSeries;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        Border border = getBorder();
        Border margin = new EmptyBorder(3, 3, 3, 3);
        setBorder(new CompoundBorder(border, margin));

        init();
    }

    private void init() {
        if (miniSeries != null) {

            setLayout(new GridLayout(0, miniSeries.getProgress().length(), 5, 5));

            for (int i = 0; i < miniSeries.getProgress().length(); i++) {
                char c = miniSeries.getProgress().charAt(i);

                JLabel label;
                Image image;

                if (c == 'W') {
                    image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/placement_won.png")).getImage(), 28, 28);
                    label = new JLabel(new ImageIcon(image));
                } else if (c == 'L') {
                    image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/placement_lost.png")).getImage(), 28, 28);
                    label = new JLabel(new ImageIcon(image));
                } else {
                    image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/placement_none.png")).getImage(), 28, 28);
                    label = new JLabel(new ImageIcon(image));
                }

                add(label);
            }
        } else {
            System.out.println("NULL");
        }
    }
}
