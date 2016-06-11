/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dennis
 */
public class SummonerTableModel extends AbstractTableModel {

    private ArrayList<Player> players;
    
    private String[] columnNames = {"Summoner Name", "Last 5 games", "Champion Winratio", "Most played champions", "Ranked stats", "Ranked winratio"};
    
    public SummonerTableModel(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }   
    
    @Override
    public int getRowCount() {
        return players.size();
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (players == null) ? null : players.get(rowIndex);
    }
    
}
