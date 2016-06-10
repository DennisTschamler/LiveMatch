/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import model.Team;

/**
 *
 * @author Dennis
 */
public class TeamView extends JPanel {
    Team team;

    public TeamView(Team team) {
        this.team = team;

        setLayout(new GridLayout(0, 1));
        setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
        
        add(new HeaderView());
        
        for(int i = 0; i < team.getSize(); i++) {
            add(new SummonerView(team.getMember(i)));
        }
    }
}
