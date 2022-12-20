/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.RAM;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.RAM.RAMModels;
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
public class FXMLRAMSellectionController implements Initializable {

    @FXML
    private TableView<RAMModels> Table_View_RAM;
    @FXML
    private TextField RAM_Text;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> RAM_selection;

    private int Val = 0;
    private String ID = "";
    private int Price;

    //Get Item
    public int getResult() {
        return (Val);
    }

    //Get Id
    public String getRAMResult() {
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
        RAM_selection.setItems(FXCollections.observableArrayList("ID_RAM", "Nama_RAM"));
        RAM_selection.getSelectionModel().select(0);
        DataShows("ID_RAM", "");
    }

    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(RAM_selection.getSelectionModel().getSelectedItem(), RAM_Text.getText());
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int slc = Table_View_RAM.getSelectionModel().getSelectedCells().get(0).getRow();
        ID = Table_View_RAM.getSelectionModel().getSelectedItem().getID_RAM().toString();
        Price = Table_View_RAM.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }

    public void DataShows(String aa, String bb) {
        ObservableList<RAMModels> data = Main_Menu2Controller.Database_RAM.CariRAM(aa, bb);
        if (data.isEmpty()) {
            data = Main_Menu2Controller.Database_RAM.Load();
            RAM_Text.setText("");
        }

        if (data != null) {
            Table_View_RAM.getColumns().clear();
            Table_View_RAM.getItems().clear();
            TableColumn col = new TableColumn("ID_RAM");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("ID_RAM"));
            Table_View_RAM.getColumns().addAll(col);
            col = new TableColumn("Nama_RAM");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Nama_RAM"));
            Table_View_RAM.getColumns().addAll(col);
            col = new TableColumn("DDR");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("DDR"));
            Table_View_RAM.getColumns().addAll(col);
            col = new TableColumn("Frequency");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Frequency"));
            Table_View_RAM.getColumns().addAll(col);
            col = new TableColumn("Capacity");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Capacity"));
            Table_View_RAM.getColumns().addAll(col);
            col = new TableColumn("CL");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("CL"));
            Table_View_RAM.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Harga"));
            Table_View_RAM.getColumns().addAll(col);
            Table_View_RAM.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            Table_View_RAM.getScene().getWindow().hide();;

        }
    }
}
