/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Tableviews.Master.SSD;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.SSD.SSDModels;
import Controller.Update.Master.SSD.UpdateSSDController;
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
 *
 * @author mariq
 */
public class Table_View_SSD implements Initializable {
    @FXML
    private TextField DataSSDSearch;
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
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button AddButton;
    @FXML
    private TableView<SSDModels> TableViewSSD;
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DataShows();
    }

    public void DataShows() {
        ObservableList<SSDModels> data = Main_Menu2Controller.Database_SSD.Load();
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

    @FXML
    private void DataSSDSearchFinder(KeyEvent event) {
        SSDModels rs = new SSDModels();
        String key = DataSSDSearch.getText();
        if (key != "") {
           ObservableList<SSDModels> data = Main_Menu2Controller.Database_SSD.Load();
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
            }
        } else {
            DataShows();
        }
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewSSD.getSelectionModel().selectFirst();
        TableViewSSD.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewSSD.getSelectionModel().selectAboveCell();
        TableViewSSD.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewSSD.getSelectionModel().selectLast();
        TableViewSSD.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewSSD.getSelectionModel().selectBelowCell();
        TableViewSSD.requestFocus();
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
         SSDModels ssd = new SSDModels();
        ssd = TableViewSSD.getSelectionModel().getSelectedItem();
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Update/Master/SSD/UpdateSSD.fxml"));
            Parent root = (Parent) loader.load();
            UpdateSSDController isidt = (UpdateSSDController)loader.getController();
            isidt.execute(ssd);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Update SSD");
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
        SSDModels ssd = new SSDModels();
        ssd = TableViewSSD.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_SSD.Delete_Data(ssd.getID_SSD())) {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Input/Master/SSD/Input_SSD.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Add SSD");
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
