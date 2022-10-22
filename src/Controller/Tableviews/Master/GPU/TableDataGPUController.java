/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Tableviews.Master.GPU;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.GPU.GPUModels;
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
public class TableDataGPUController implements Initializable {

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
    private TableView<GPUModels> TableViewGPU;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button AddButton;
    @FXML
    private TextField DataGPUSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DataShows();
    }

    public void DataShows() {
        ObservableList<GPUModels> data = Main_Menu2Controller.Database_GPU.Load();
        if (data != null) {
            TableViewGPU.getColumns().clear();
            TableViewGPU.getItems().clear();
            TableColumn col = new TableColumn("ID_GPU");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("ID_GPU"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Vendor"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("VRAM");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("VRAM"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Memory_Type");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Memory_Type"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Frequency");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Frequency"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("GDP");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("GDP"));
           TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Harga"));
            TableViewGPU.getColumns().addAll(col);
            TableViewGPU.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewGPU.getScene().getWindow().hide();;
        }
    }

    private void DataCPUSearchFinder(KeyEvent event) {
        GPUModels gs = new GPUModels();
        String key = DataGPUSearch.getText();
        if (key != "") {
              ObservableList<GPUModels> data = Main_Menu2Controller.Database_GPU.Load();
        if (data != null) {
            TableViewGPU.getColumns().clear();
            TableViewGPU.getItems().clear();
            TableColumn col = new TableColumn("ID_GPU");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("ID_GPU"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Vendor"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("VRAM");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("VRAM"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Memory_Type");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Memory_Type"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Frequency");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Frequency"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("GDP");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("GDP"));
           TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Harga"));
            TableViewGPU.getColumns().addAll(col);
            TableViewGPU.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
                a.showAndWait();
                TableViewGPU.getScene().getWindow().hide();;
            }
        } else {
            DataShows();
        }
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewGPU.getSelectionModel().selectFirst();
        TableViewGPU.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewGPU.getSelectionModel().selectAboveCell();
        TableViewGPU.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewGPU.getSelectionModel().selectLast();
        TableViewGPU.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewGPU.getSelectionModel().selectBelowCell();
        TableViewGPU.requestFocus();
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Update/Master/GPU/UpdateGPU.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Update GPU");
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
    private void DeleteButtonClick(ActionEvent event) {
        GPUModels  gpu = new GPUModels();
        gpu = TableViewGPU.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_GPU.Delete_Data(gpu.getID_GPU())) {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Input/Master/GPU/Input_GPU.fxml"));
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

    @FXML
    private void DataGPUSearchFinder(KeyEvent event) {
    }

}
