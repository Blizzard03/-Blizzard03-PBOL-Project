/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Tableviews.Master.Cooler;

import Controller.MainMenu.Main_Menu2Controller;
import Controller.Update.Master.Cooler.UpdateCoolerController;
import Models.Master.Cooler.CoolerModels;
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
public class Tableview_CoolerController implements Initializable {
    @FXML
    private TableView<CoolerModels> TableViewCooler;
    @FXML
    private TextField DataCoolerSearch;
    @FXML
    private Button MainMenuButtoon;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button FirstButton;
    @FXML
    private Button BeforeButon;
    @FXML
    private Button LastButon;
    @FXML
    private Button AfterButon;
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

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewCooler.getSelectionModel().selectFirst();
        TableViewCooler.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewCooler.getSelectionModel().selectAboveCell();
        TableViewCooler.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewCooler.getSelectionModel().selectLast();
        TableViewCooler.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewCooler.getSelectionModel().selectBelowCell();
        TableViewCooler.requestFocus();

    }

    public void DataShows() {
        ObservableList<CoolerModels> data = Main_Menu2Controller.Database_Cooler.Load();
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

    private void DataUserSearchFinder(KeyEvent event) {
      
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
        CoolerModels cs = new CoolerModels();
        cs = TableViewCooler.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML.Update.Master.Cooler/UpdateCooler.fxml"));
            Parent root = (Parent) loader.load();
            UpdateCoolerController isidt = (UpdateCoolerController) loader.getController();
            isidt.execute(cs);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.setTitle("Update Cooler Service");
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
        CoolerModels cs = new CoolerModels();
        cs = TableViewCooler.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_Cooler.Delete_Data(cs.getID_COOLER())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data Cooler have been Deleted", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data Cooler Fail to Delete", ButtonType.OK);
                b.showAndWait();
            }
            DataShows();
            FirstButtonClick(event);
        }

    }

    @FXML
    private void DataCoolerSearch(KeyEvent event) {
          CoolerModels cs = new CoolerModels();
        String key = DataCoolerSearch.getText();
        if (key != "") {
            ObservableList<CoolerModels> data = Main_Menu2Controller.Database_Cooler.Load();
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
            }
        } else {
            DataShows();
        }
    }

    @FXML
    private void AddButtonClick(ActionEvent event) {
    }
}
