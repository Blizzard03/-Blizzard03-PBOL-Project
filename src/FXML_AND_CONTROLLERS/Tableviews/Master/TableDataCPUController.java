/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXML_AND_CONTROLLERS.Tableviews.Master;

//Import java Class
import Models.Master.CPU.CPUModels;
import Controller.MainMenu.Main_Menu2Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button AddButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DataShows();
    }

    public void DataShows() {
        ObservableList<CPUModels> data = Main_Menu2Controller.Database_CPU.Load();
        if (data != null) {
            TableViewCPU.getColumns().clear();
            TableViewCPU.getItems().clear();
            TableColumn col = new TableColumn("ID_CPU");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("ID_CPU"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Nama_CPU");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Nama_CPU"));
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
            col = new TableColumn("Thread");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Thread"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("TDP");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("TDP"));
            TableViewCPU.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<CPUModels, String>("Harga"));
            TableViewCPU.getColumns().addAll(col);
            TableViewCPU.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            TableViewCPU.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void DataCPUSearchFinder(KeyEvent event) {
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewCPU.getSelectionModel().selectFirst();
        TableViewCPU.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event
    ) {
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewCPU.getSelectionModel().selectLast();
        TableViewCPU.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event
    ) {
    }

    @FXML
    private void MainMenuButtonClick(ActionEvent event) {

    }

    @FXML
    private void UpdateButtonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteButtonClick(ActionEvent event) {
        CPUModels cpu = new CPUModels();
        cpu = TableViewCPU.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_CPU.Delete_Data(cpu.getID_CPU())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data have been Deleted", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data Fail to Delete", ButtonType.OK);
                b.showAndWait();
            }
            DataShows();
            FirstButtonClick(event);
        }
    }

    @FXML
    private void AddButtonClick(ActionEvent event) {

    }

}
