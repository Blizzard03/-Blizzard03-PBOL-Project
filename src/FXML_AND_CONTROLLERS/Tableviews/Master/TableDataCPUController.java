/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXML_AND_CONTROLLERS.Tableviews.Master;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import Models.CPU.CPUModels;
/**
 * FXML Controller class
 *
 * @author mariq
 */
public class TableDataCPUController implements Initializable {

    @FXML
    private TextField DataCPUSearch;
    @FXML
    private Button FirstButton;
    @FXML
    private Button BeforeButon;
    @FXML
    private Button LastButon;
    @FXML
    private Button AfterButon;
    @FXML
    private Button MainMenuButtoon;
    @FXML
    private TableView<CPUModels> TableViewCPU;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowData();
    }    
    
    public void ShowData(){
        
    }
    

    @FXML
    private void DataCPUSearchFinder(KeyEvent event) {
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
    }

    @FXML
    private void MainMenuButtonClick(ActionEvent event) {
    }
    
}
