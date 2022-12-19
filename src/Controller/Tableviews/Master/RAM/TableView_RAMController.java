/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Tableviews.Master.RAM;

import Controller.MainMenu.Main_Menu2Controller;
import Controller.Update.Master.RAM.UpdateRAMController;
import Models.Master.RAM.RAMModels;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class TableView_RAMController implements Initializable {
    private TextField DataRAMSearch;
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
    private TableView<RAMModels> TableViewRAM;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button AddButton;
    @FXML
    private TextField DataCPUSearch;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DataShows();
    }

    public void DataShows() {
        ObservableList<RAMModels> data = Main_Menu2Controller.Database_RAM.Load();
        if (data != null) {
            TableViewRAM.getColumns().clear();
            TableViewRAM.getItems().clear();
            TableColumn col = new TableColumn("ID_RAM");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("ID_RAM"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Nama_RAM");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Nama_RAM"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("DDR");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("DDR"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Frequency");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Frequency"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Capacity");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Capacity"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("CL");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("CL"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Harga"));
            TableViewRAM.getColumns().addAll(col);
            TableViewRAM.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewRAM.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void DataRAMSearchFinder(KeyEvent event) {
        RAMModels rs = new RAMModels();
        String key = DataRAMSearch.getText();
        if (key != "") {
            ObservableList<RAMModels> data = Main_Menu2Controller.Database_RAM.Load();
       if (data != null) {
            TableViewRAM.getColumns().clear();
            TableViewRAM.getItems().clear();
            TableColumn col = new TableColumn("ID_RAM");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("ID_RAM"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Nama_RAM");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Nama_RAM"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("DDR");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("DDR"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Frequency");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Frequency"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Capacity");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Capacity"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("CL");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("CL"));
            TableViewRAM.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<RAMModels, String>("Harga"));
            TableViewRAM.getColumns().addAll(col);
            TableViewRAM.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
                a.showAndWait();
                TableViewRAM.getScene().getWindow().hide();;
            }
        } else {
            DataShows();
        }
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewRAM.getSelectionModel().selectFirst();
        TableViewRAM.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewRAM.getSelectionModel().selectAboveCell();
        TableViewRAM.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewRAM.getSelectionModel().selectLast();
        TableViewRAM.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewRAM.getSelectionModel().selectBelowCell();
        TableViewRAM.requestFocus();
    }

    @FXML
    private void MainMenuButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainMenu/Main_Menu2.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Main Menu");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            MainMenuButtoon.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void UpdateButtonClick(ActionEvent event) {
    RAMModels rm = new RAMModels();
    rm  = TableViewRAM.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Update/Master/RAM/UpdateRAM.fxml"));
            Parent root = (Parent) loader.load();
            UpdateRAMController isidt = (UpdateRAMController)loader.getController();
            isidt.execute(rm);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Update RAM");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            UpdateButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataShows();
        FirstButtonClick(event);

    }

    @FXML
    private void DeleteButtonClick(ActionEvent event) {
        RAMModels ram = new RAMModels();
        ram = TableViewRAM.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_RAM.Delete_Data(ram.getID_RAM())) {
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Input/Master/RAM/Input_RAM.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Add RAM");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            AddButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

   
   
    
}
