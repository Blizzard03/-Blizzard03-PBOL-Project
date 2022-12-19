/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.PowerSupply;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Models.Master.PSU.PSU_Models;


/**
 * FXML Controller class
 *
 * @author Muhamad Ariq Rasyid
 */
public class FXMLSelectionPoweSupplyController implements Initializable {

    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private TableView<PSU_Models> Table_View_Power_Supply;
    @FXML
    private TextField Power_Supply_Text;
    @FXML
    private ComboBox<String> Power_Supply_selection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SearchClick(ActionEvent event) {
    }

    @FXML
    private void CancelClick(ActionEvent event) {
    }

    @FXML
    private void SelectClick(ActionEvent event) {
    }
    
}
