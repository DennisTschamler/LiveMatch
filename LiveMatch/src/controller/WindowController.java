/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Region;
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
        String summonerName = view.getSummonerName();
        Region server = view.getServer();
        
        System.out.println("Chosen: "+summonerName+" "+server.getName());
        controllers.add(new LiveMatchController(summonerName, server));
    }
}
