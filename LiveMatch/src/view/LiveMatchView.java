/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import model.Team;

/**
 *
 * @author Dennis
 */
public class LiveMatchView extends JFrame {
    
    TeamView teamView1;
    TeamView teamView2;
    
    public LiveMatchView(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setLayout(new GridLayout(0, 2));
                
        setVisible(true);
    }
    
    public void initTeam1(Team team) {
        teamView1 = new TeamView(team);
        add(teamView1);
        pack();
    }
    
    public void initTeam2(Team team) {
        teamView2 = new TeamView(team);
        add(teamView2);
        pack();
    }
}
