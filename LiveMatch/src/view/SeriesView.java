/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utils.ImageUtils;
import api.dto.MiniSeriesAPI;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Dennis
 */
public class SeriesView extends JPanel {

    private MiniSeriesAPI miniSeries;

    public SeriesView(MiniSeriesAPI miniSeries) {
        this.miniSeries = miniSeries;

        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));

        init();
    }

    private void init() {
        if (miniSeries != null && miniSeries.getTarget() == 3 || miniSeries.getTarget() == 5) {

            setLayout(new GridLayout(0, miniSeries.getTarget(), 5, 5));


            for (int i = 0; i < miniSeries.getTarget(); i++) {
                char c = miniSeries.getProgress().charAt(i);

                JLabel label;
                Image image;

                if (c == 'W') {
                    image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/placement_won.png")).getImage(), 48, 48);
                    label = new JLabel(new ImageIcon(image));
                } else if (c == 'L') {
                    image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/placement_lost.png")).getImage(), 48, 48);
                    label = new JLabel(new ImageIcon(image));
                } else {
                    image = ImageUtils.resizeImage(new ImageIcon(getClass().getResource("/assets/gui_icons/placement_none.png")).getImage(), 48, 48);
                    label = new JLabel(new ImageIcon(image));
                }

                add(label);
            }
        }
    }
}
