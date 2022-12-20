/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.CPU;

import Controller.MainMenu.Main_Menu2Controller;
import Controller.SelectData.Cooler.FXMLSelectCoolerController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Models.Master.CPU.CPUModels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Muhamad Ariq Rasyid
 */
public class FXMLSelectCPUController implements Initializable {

    private int Val = 0;
    private String IDCPU = "";
    private int Price;

    @FXML
    private TableView<CPUModels> TableViewCPU;
    @FXML
    private TextField CPUText;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> CPU_selection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CPU_selection.setItems(FXCollections.observableArrayList("ID_CPU", "Nama_CPU"));
        CPU_selection.getSelectionModel().select(0);
        ShowData("ID_CPU", "");

    }

    //For Get Item
    public int getResult() {
        return (Val);
    }

    //Get ID
    public String GetIDCPUResult() {
        return (IDCPU);
    }

    //Get Price
    public int GetPrice() {
        return (Price);
    }

    @FXML

    private void SearchClick(ActionEvent event) {
        ShowData(CPU_selection.getSelectionModel().getSelectedItem(), CPUText.getText());

    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int slc = TableViewCPU.getSelectionModel().getSelectedCells().get(0).getRow();
        IDCPU = TableViewCPU.getSelectionModel().getSelectedItem().getID_CPU().toString();
        Price = TableViewCPU.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }

    public void ShowData(String aa, String bb) {
        ObservableList<CPUModels> data = Main_Menu2Controller.Database_CPU.Load();
        if (data.isEmpty()) {
            data = Main_Menu2Controller.Database_CPU.Load();
            CPUText.setText("");
        }
        if (data != null) {
            TableViewCPU.getColumns().clear();
            TableViewCPU.getItems().clear();
            TableColumn col = new TableColumn("ID_CPU");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("ID_CPU"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Vendor"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Nama_CPU");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Nama_CPU"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Socket");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Socket"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Base_Clock");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Base_Clock"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Max_Turbo_Clock");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Max_Turbo_Clock"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Cores");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Cores"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("TDP");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("TDP"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Thread");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Thread"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Harga"));
            TableViewCPU.getColumns().addAll(col);
            TableViewCPU.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewCPU.getScene().getWindow().hide();;
        }
    }
}
