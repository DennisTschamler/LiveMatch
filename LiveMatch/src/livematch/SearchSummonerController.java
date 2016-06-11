/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livematch;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import match.Match;
import model.Region;

/**
 * FXML Controller class
 *
 * @author Dennis
 */
public class SearchSummonerController implements Initializable {

    ObservableList<Region> regionList = FXCollections.observableArrayList(Region.values());
    
    @FXML
    private TextField summonerTextField;
    
    @FXML
    private ComboBox<Region> regionComboBox;
    
    @FXML
    private Button searchButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        regionComboBox.setItems(regionList);
        regionComboBox.getSelectionModel().select(0);
        
        searchButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                searchSummoner(event);
            }
            
        });
    }    
    
    @FXML
    private void searchSummoner(ActionEvent event) {
        String name = summonerTextField.getText();
        Region region = regionComboBox.getSelectionModel().getSelectedItem();
        
        System.out.println(name+" : "+region);
        
        try {
            new Match();
        } catch (Exception ex) {
            Logger.getLogger(SearchSummonerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
