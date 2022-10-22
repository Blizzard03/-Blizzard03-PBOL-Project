/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Tableviews.Master.Mother_Board;

import Controller.MainMenu.Main_Menu2Controller;
import Controller.Update.Master.Mother_Board.UpdateMotherBoardController;
import Models.Master.Mother_Board_Models.Mother_Board_Models;
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
public class TableView_Mother_BoardController implements Initializable {

    @FXML
    private TextField DataMother_BoardSearch;
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
    private TableView<Mother_Board_Models> TableViewMother_Board;
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
        DataShows();
    }

    public void DataShows() {
           ObservableList<Mother_Board_Models> data = Main_Menu2Controller.Database_Mobo.Load();
            if (data != null) {
                TableViewMother_Board.getColumns().clear();
                TableViewMother_Board.getItems().clear();
                TableColumn col = new TableColumn("ID_MOTHER_BOARD");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("ID_MOTHER_BOARD"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Vendor");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Vendor"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Nama_Mother_Board");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Nama_Mother_Board"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Type");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Type"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Socket");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Socket"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Harga");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Harga"));
                TableViewMother_Board.getColumns().addAll(col);
                TableViewMother_Board.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewMother_Board.getScene().getWindow().hide();;
        }
    }

    
    private void DataCPUSearchFinder(KeyEvent event) {
        Mother_Board_Models s = new Mother_Board_Models();
        String key = DataMother_BoardSearch.getText();
        if (key != "") {
            ObservableList<Mother_Board_Models> data = Main_Menu2Controller.Database_Mobo.Mother_Board_Search(key, key);
            if (data != null) {
                TableViewMother_Board.getColumns().clear();
                TableViewMother_Board.getItems().clear();
                TableColumn col = new TableColumn("ID_MOTHER_BOARDU");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("ID_MOTHER_BOARD"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Vendor");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Vendor"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Nama_Mother_Board");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Nama_Mother_Board"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Type");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Type"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Socket");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Socket"));
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Cores");
                TableViewMother_Board.getColumns().addAll(col);
                col = new TableColumn("Harga");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Harga"));
                TableViewMother_Board.getColumns().addAll(col);
                TableViewMother_Board.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
                a.showAndWait();
                TableViewMother_Board.getScene().getWindow().hide();;
            }
        } else {
            DataShows();
        }
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewMother_Board.getSelectionModel().selectFirst();
        TableViewMother_Board.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewMother_Board.getSelectionModel().selectAboveCell();
        TableViewMother_Board.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewMother_Board.getSelectionModel().selectLast();
        TableViewMother_Board.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewMother_Board.getSelectionModel().selectBelowCell();
        TableViewMother_Board.requestFocus();
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
       Mother_Board_Models mobo = new Mother_Board_Models();
        mobo = TableViewMother_Board.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Update/Master/Mother_Board/UpdateMotherBoard.fxml"));
            Parent root = (Parent) loader.load();
            UpdateMotherBoardController isidt = (UpdateMotherBoardController) loader.getController();
            isidt.execute(mobo);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.setTitle("Update Mother Board Service");
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
        Mother_Board_Models mobo = new Mother_Board_Models();
        mobo = TableViewMother_Board.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (Main_Menu2Controller.Database_Mobo.Delete_Data(mobo.getID_MOTHER_BOARD())) {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Input/Master/Mother_Board/Input_Mother_Board.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Add CPU");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.setTitle("Input Mother Board Service");
            stg.show();
            AddButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void DataMoboSearchFinder(KeyEvent event) {
    }
}
    

