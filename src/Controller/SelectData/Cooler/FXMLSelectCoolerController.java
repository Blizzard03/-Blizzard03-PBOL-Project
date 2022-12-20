/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.Cooler;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.Cooler.CoolerModels;
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
public class FXMLSelectCoolerController implements Initializable {

    @FXML
    private TableView<CoolerModels> TableViewCooler;
    @FXML
    private TextField CoolerText;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> Cooler_selection;
    private int Val = 0;
    private String ID = "";
    private int Price;

    //Get Item
    public int getResult() {
        return (Val);
    }

    //Get Id
    public String getIDCoolerResult() {
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
        Cooler_selection.setItems(FXCollections.observableArrayList("ID_COOLER", "Nama_Cooler"));
        Cooler_selection.getSelectionModel().select(0);
        DataShows("ID_COOLER", "");
    }

    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(Cooler_selection.getSelectionModel().getSelectedItem(), CoolerText.getText());
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int slc = TableViewCooler.getSelectionModel().getSelectedCells().get(0).getRow();
        ID = TableViewCooler.getSelectionModel().getSelectedItem().getID_COOLER().toString();
        Price = TableViewCooler.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }

    public void DataShows(String aa, String bb) {
        ObservableList<CoolerModels> data = Main_Menu2Controller.Database_Cooler.SearchCooler(aa, bb);
        if (data.isEmpty()) {
            data = Main_Menu2Controller.Database_Cooler.Load();
            CoolerText.setText("");
        }
        if (data != null) {
            TableViewCooler.getColumns().clear();
            TableViewCooler.getItems().clear();
            TableColumn col = new TableColumn("ID_COOLER");
            col.setCellValueFactory(new PropertyValueFactory<CoolerModels, String>("ID_COOLER"));
            TableViewCooler.getColumns().addAll(col);
            col = new TableColumn("Nama_Cooler");
            col.setCellValueFactory(new PropertyValueFactory<CoolerModels, String>("Nama_Cooler"));
            TableViewCooler.getColumns().addAll(col);
            col = new TableColumn("Type");
            col.setCellValueFactory(new PropertyValueFactory<CoolerModels, String>("Type"));
            TableViewCooler.getColumns().addAll(col);
            col = new TableColumn("Socket");
            col.setCellValueFactory(new PropertyValueFactory<CoolerModels, String>("Socket"));
            TableViewCooler.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<CoolerModels, String>("Harga"));
            TableViewCooler.getColumns().addAll(col);
            TableViewCooler.setItems(data);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            TableViewCooler.getScene().getWindow().hide();;
        }
    }

}
