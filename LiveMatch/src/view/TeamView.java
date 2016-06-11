/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import model.Player;
import model.SummonerTableModel;

/**
 *
 * @author Dennis
 */
public class TeamView extends JPanel {

    private JTable table;
    
    public TeamView() {
        setLayout(new GridLayout(0, 1));
        setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
        
        add(new HeaderView());
    }
    
    public void initTable(ArrayList<Player> players) {
        table = new JTable(new SummonerTableModel(players));
    }
}
