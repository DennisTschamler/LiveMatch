/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utils.ImageUtils;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import model.Player;

/**
 *
 * @author Dennis
 */
public class SummonerCellRenderer implements ListCellRenderer {

    public SummonerCellRenderer() {
        
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Player player = (Player) value;
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,3));
        
        Image image = ImageUtils.resizeImage(player.getChampion().getImageIcon().getImage(), 48, 48);
        JLabel championIcon = new JLabel(new ImageIcon(image));
        championIcon.setToolTipText(player.getChampion().getName());
        panel.add(championIcon);
        
        panel.add(new JLabel(player.getName()));
        
        return panel;
    }
    
}
