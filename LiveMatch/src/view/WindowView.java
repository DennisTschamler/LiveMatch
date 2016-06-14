/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import api.dto.Region;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Dennis
 */
public class WindowView extends JFrame {
    
    private JLabel summonerNameLabel;
    private JTextField summonerName = new JTextField(10);

    JLabel serversLabel;
    private JComboBox<Region> servers;
    
    private JButton search;
    
    public WindowView() {
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setTitle("League of Legends - live match");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
        
        initComponents();
        pack();
    }
    
    private void initComponents() {
        summonerNameLabel = new JLabel("Username: ");
        serversLabel = new JLabel("Server: ");
        
        ArrayList<Region> s = new ArrayList<>();
        
        s.add(Region.EUNE);
        s.add(Region.EUW);
        
        
        servers = new JComboBox<Region>();
        
        for(int i = 0; i < s.size(); i++) {
            servers.addItem(s.get(i));
        }
        
        search = new JButton("Search");
        
        getContentPane().add(summonerNameLabel);
        getContentPane().add(summonerName);
        getContentPane().add(serversLabel);
        getContentPane().add(servers);
        getContentPane().add(search);
    }
    
    public String getSummonerName() {
        return summonerName.getText();
    }
    
    public Region getServer() {
        return (Region) servers.getSelectedItem();
    }
    
    public JButton getSearchButton() {
        return search;
    }
}
