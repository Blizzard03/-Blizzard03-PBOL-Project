/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.MotherBoard;

import Models.Master.Mother_Board_Models.Mother_Board_Models;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Muhamad Ariq Rasyid
 */
public class FXMLSelectionMotherBoardController implements Initializable {

    @FXML
    private TextField Mother_BoardText;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> Mother_Board_selection;
    @FXML
    private TableView<Mother_Board_Models> TableViewMotherBoards;

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
