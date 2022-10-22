/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Tableviews.Master.PSU;

import Controller.MainMenu.Main_Menu2Controller;
import Controller.Update.Master.PSU.UpdatePSUController;
import Models.Master.PSU.PSU_Models;
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
public class TableDataPSUController implements Initializable {

    @FXML
    private TextField PowerSupplySearch;
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
    private TableView<PSU_Models> TableViewPowerSupply;
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
    //TODO
    DataShows();
    }

    public void DataShows() {
        ObservableList<PSU_Models> data = Main_Menu2Controller.Database_PSU.Load();
        if (data != null) {
            TableViewPowerSupply.getColumns().clear();
            TableViewPowerSupply.getItems().clear();
            TableColumn col = new TableColumn("ID_PSU");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("ID_PSU"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Vendor"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Nama_PSU");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Nama_PSU"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Watt");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Watt"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Tier");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Tier"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Harga"));
            TableViewPowerSupply.getColumns().addAll(col);
            TableViewPowerSupply.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewPowerSupply.getScene().getWindow().hide();;
        }
    }

    

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewPowerSupply.getSelectionModel().selectFirst();
        TableViewPowerSupply.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewPowerSupply.getSelectionModel().selectAboveCell();
        TableViewPowerSupply.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewPowerSupply.getSelectionModel().selectLast();
        TableViewPowerSupply.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewPowerSupply.getSelectionModel().selectBelowCell();
        TableViewPowerSupply.requestFocus();
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
        PSU_Models mobo = new PSU_Models();
        mobo = TableViewPowerSupply.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Update/Master/PSU/UpdatePSU.fxml"));
            Parent root = (Parent) loader.load();
            UpdatePSUController isidt = (UpdatePSUController) loader.getController();
            isidt.execute(mobo);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.setTitle("Update Power Supply Service");
            stg.showAndWait();
            UpdateButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataShows();
        FirstButtonClick(event);

    }

    @FXML
    private void DeleteButtonClick(ActionEvent event) {
        PSU_Models psu = new PSU_Models();
        psu = TableViewPowerSupply.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_PSU.Delete_Data(psu.getID_PSU())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data Power Supply have been Deleted", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data Power Supply Fail to Delete", ButtonType.OK);
                b.showAndWait();
            }
            DataShows();
            FirstButtonClick(event);
        }

    }

    @FXML
    private void PowerSupplySearchFinder(KeyEvent event) {
        PSU_Models psu = new PSU_Models();
        String key = PowerSupplySearch.getText();
        if (key != "") {
            ObservableList<PSU_Models> data = Main_Menu2Controller.Database_PSU.Cari_Power_Supply(key, key);
            if (data != null) {
               TableViewPowerSupply.getColumns().clear();
            TableViewPowerSupply.getItems().clear();
            TableColumn col = new TableColumn("ID_PSU");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("ID_PSU"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Vendor"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Nama_PSU");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Nama_PSU"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Watt");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Watt"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Tier");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Tier"));
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Cores");
            TableViewPowerSupply.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<PSU_Models, String>("Harga"));
            TableViewPowerSupply.getColumns().addAll(col);
            TableViewPowerSupply.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
                a.showAndWait();
                TableViewPowerSupply.getScene().getWindow().hide();;
            }
        } else {
            DataShows();
        }
    }

    @FXML
    private void AddButtonClick(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Input/Master/PSU/Input_PSU.fxml"));
            Parent root = (Parent) loader.load();
            UpdatePSUController isidt = (UpdatePSUController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.setTitle("Update Power Supply Service");
            stg.showAndWait();
            UpdateButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataShows();
        FirstButtonClick(event);

    }
    }

