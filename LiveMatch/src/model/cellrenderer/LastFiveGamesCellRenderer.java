/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cellrenderer;

import Utils.ImageUtils;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import model.Champion;
import model.Player;

/**
 *
 * @author Dennis
 */
public class LastFiveGamesCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Player player = (Player) value;

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));

        return panel;
    }

}
