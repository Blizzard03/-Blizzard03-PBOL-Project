/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.PowerSupply;

import Controller.MainMenu.Main_Menu2Controller;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


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

     private int Val = 0;
    private String ID = "";
    private int Price;

    //Get Item
    public int getResult() {
        return (Val);
    }

    //Get Id
    public String getPSUResult() {
        return (ID);
    }

    //Get Price
    public int getPrice() {
        return (Price);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Power_Supply_selection.setItems(FXCollections.observableArrayList("ID_PSU", "Nama_PSU"));
       Power_Supply_selection.getSelectionModel().select(0);
        DataShows("ID_RAM", "");
    }

    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(Power_Supply_selection.getSelectionModel().getSelectedItem(), Power_Supply_Text.getText());
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int slc = Table_View_Power_Supply.getSelectionModel().getSelectedCells().get(0).getRow();
        ID = Table_View_Power_Supply.getSelectionModel().getSelectedItem().getID_PSU().toString();
        Price = Table_View_Power_Supply.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }

     public void DataShows(String aa, String bb) {
        ObservableList<PSU_Models> data = Main_Menu2Controller.Database_PSU.Load();
        if (data != null) {
           Table_View_Power_Supply.getColumns().clear();
           Table_View_Power_Supply.getItems().clear();
            TableColumn col = new TableColumn("ID_PSU");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("ID_PSU"));
           Table_View_Power_Supply.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Vendor"));
           Table_View_Power_Supply.getColumns().addAll(col);
            col = new TableColumn("Nama_PSU");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Nama_PSU"));
           Table_View_Power_Supply.getColumns().addAll(col);
            col = new TableColumn("Watt");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Watt"));
           Table_View_Power_Supply.getColumns().addAll(col);
            col = new TableColumn("Tier");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Tier"));
           Table_View_Power_Supply.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Harga"));
           Table_View_Power_Supply.getColumns().addAll(col);
           Table_View_Power_Supply.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
           Table_View_Power_Supply.getScene().getWindow().hide();;
        }
    }
}
