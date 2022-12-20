/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.Customer;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.User.UsersModels;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Muhamad Ariq Rasyid
 */
public class FXMLCustomersController implements Initializable {

    private int Val = 0;
    private int IDUser;
    @FXML
    private TableView<UsersModels> TableViewCostumer;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private TextField CustomerText;
    @FXML
    private ComboBox<String> Customer_selection;

    //For Get Item
    public int getResult() {
        return (Val);
    }

    //Forget Get ID
    public int getID_Userhasil() {
        return (IDUser);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Customer_selection.setItems(FXCollections.observableArrayList("ID_User", "Nama"));
        Customer_selection.getSelectionModel().select(0);
        DataShows("ID_User", "");
        

    }
    
    //Search Buttons
    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(Customer_selection.getSelectionModel().getSelectedItem(),CustomerText.getText());
    }

    //Cancel Button
    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    //Select Button
    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int Slc = TableViewCostumer.getSelectionModel().getSelectedCells().get(0).getRow();
        IDUser = TableViewCostumer.getSelectionModel().getSelectedItem().getID_User();
        SelectButton.getScene().getWindow().hide();
        
    }

    //Data Show
    public void DataShows(String aa, String bb) {
        ObservableList<UsersModels> data = Main_Menu2Controller.Database_User.CariUser(aa, bb);
        if (data.isEmpty()) {
            data = Main_Menu2Controller.Database_User.Load();
            CustomerText.setText("");
        }
        if (data != null) {
            
            TableViewCostumer.getColumns().clear();
            TableViewCostumer.getItems().clear();
            TableColumn col = new TableColumn("ID_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("ID_User"));
            TableViewCostumer.getColumns().addAll(col);
            col = new TableColumn("Nama_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Nama_User"));
             TableViewCostumer.getColumns().addAll(col);
            TableViewCostumer.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            TableViewCostumer.getScene().getWindow().hide();;
        }
    }

}
