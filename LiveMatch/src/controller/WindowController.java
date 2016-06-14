/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.RiotApiException;
import api.dto.Region;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import view.WindowView;

/**
 *
 * @author Dennis
 */
public class WindowController implements ActionListener {
    WindowView view;
    
    ArrayList<LiveMatchController> controllers = new ArrayList<>();
    
    public WindowController() {
        view = new WindowView();
    }
    
    public void control() {
        view.getSearchButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String summonerName = view.getSummonerName();
            Region server = view.getServer();
            
            System.out.println("Chosen: "+summonerName+" "+server.getName());
            
            long timeBefore = System.currentTimeMillis();
            controllers.add(new LiveMatchController(summonerName, server));
            
            System.out.println((System.currentTimeMillis()-timeBefore)/1000+"s to trvalo");
        } catch (RiotApiException ex) {
            System.out.println("Error: "+ex.getMessage());
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getMessage());
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
