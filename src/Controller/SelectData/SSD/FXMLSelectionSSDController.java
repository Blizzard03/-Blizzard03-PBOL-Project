/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.SSD;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.SSD.SSDModels;
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
public class FXMLSelectionSSDController implements Initializable {

    @FXML
    private TableView<SSDModels> TableViewSSD;
    @FXML
    private TextField SSDText;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> SSD_selection;

    private int Val = 0;
    private String ID = "";
    private int Price;

    //Get Item
    public int getResult() {
        return (Val);
    }

    //Get Id
    public String getIDSSDResult() {
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
        SSD_selection.setItems(FXCollections.observableArrayList("ID_SSD", "Nama_SSD"));
        SSD_selection.getSelectionModel().select(0);
        DataShows("ID_SSD", "");
    }

    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(SSD_selection.getSelectionModel().getSelectedItem(), SSDText.getText());
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int slc = TableViewSSD.getSelectionModel().getSelectedCells().get(0).getRow();
        ID = TableViewSSD.getSelectionModel().getSelectedItem().getID_SSD().toString();
        Price = TableViewSSD.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }

    public void DataShows(String aa, String bb) {
        ObservableList<SSDModels> data = Main_Menu2Controller.Database_SSD.CariSSD(aa, bb);
        if (data.isEmpty()) {
            data = Main_Menu2Controller.Database_SSD.Load();
            SSDText.setText("");
        }

        if (data != null) {
            TableViewSSD.getColumns().clear();
            TableViewSSD.getItems().clear();
            TableColumn col = new TableColumn("ID_SSD");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("ID_SSD"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Vendor"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Nama_SSD");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Nama_SSD"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Type");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Type"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Capacity");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Capacity"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("TBW");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("TBW"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Read");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Read"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Write");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Write"));
            TableViewSSD.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<SSDModels, String>("Harga"));
            TableViewSSD.getColumns().addAll(col);
            TableViewSSD.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewSSD.getScene().getWindow().hide();;
        }
    }
}
