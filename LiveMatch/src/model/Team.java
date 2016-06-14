/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class Team {
    ArrayList<Player> members;
    
    public Team() {
        members = new ArrayList<>();
    }
    
    public void addMember(Player summ) {
        members.add(summ);
    }
    
    public void print() {
        System.out.println("===TEAM===");
        for(int i = 0; i < members.size(); i++) {
            Player s = members.get(i);
            System.out.println(s.getName()+" : "+s.getChampionStats().getName());
        }
    }
    
    public ArrayList<Player> getMembers() {
        return members;
    }
    
    public Player getMember(int index) {
        return members.get(index);
    }
    
    public int getSize() {
        return members.size();
    }
}
