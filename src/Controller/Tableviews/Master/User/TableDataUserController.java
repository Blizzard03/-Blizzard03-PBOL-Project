/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXML_AND_CONTROLLERS.Tableviews.Master;

import Controller.MainMenu.Main_Menu2Controller;
import Models.User.UsersModels;
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
public class TableDataUserController implements Initializable {

    @FXML
    private TableView<UsersModels> TableViewUser;
    @FXML
    private TextField DataUserSearch;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showdata();
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewUser.getSelectionModel().selectFirst();
        TableViewUser.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewUser.getSelectionModel().selectAboveCell();
        TableViewUser.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewUser.getSelectionModel().selectLast();
        TableViewUser.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {

    }

    public void showdata() {
        ObservableList<UsersModels> data = Main_Menu2Controller.Database_User.Load();
        if (data != null) {
            TableViewUser.getColumns().clear();
            TableViewUser.getItems().clear();
            TableColumn col = new TableColumn("ID_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("ID_User"));
            TableViewUser.getColumns().addAll(col);
            col = new TableColumn("Nama_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Nama_User"));
            TableViewUser.getColumns().addAll(col);
            col = new TableColumn("Email_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Email_User"));
            TableViewUser.getColumns().addAll(col);
            col = new TableColumn("Alamat_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Alamat_User"));
            TableViewUser.getColumns().addAll(col);
            col = new TableColumn("Nomor_Telepon_User");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Nomor_Telepon_User"));
            TableViewUser.getColumns().addAll(col);
            col = new TableColumn("Password");
            col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Password"));
            TableViewUser.getColumns().addAll(col);
            TableViewUser.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            TableViewUser.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void DataUserSearchFinder(KeyEvent event) {
        UsersModels s = new UsersModels();
        String key = DataUserSearch.getText();
        if (key != "") {
            ObservableList<UsersModels> data = Main_Menu2Controller.Database_User.CariUser(key, key);
            if (data != null) {
                TableViewUser.getColumns().clear();
                TableViewUser.getItems().clear();
                TableColumn col = new TableColumn("ID_User");
                col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("ID_User"));
                TableViewUser.getColumns().addAll(col);
                col = new TableColumn("Nama_User");
                col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Nama_User"));
                TableViewUser.getColumns().addAll(col);
                col = new TableColumn("Email_User");
                col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Email_User"));
                TableViewUser.getColumns().addAll(col);
                col = new TableColumn("Alamat_User");
                col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Alamat_User"));
                TableViewUser.getColumns().addAll(col);
                col = new TableColumn("Nomor_Telepon_User");
                col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Nomor_Telepon_User"));
                TableViewUser.getColumns().addAll(col);
                col = new TableColumn("Password");
                col.setCellValueFactory(new PropertyValueFactory<UsersModels, String>("Password"));
                TableViewUser.getColumns().addAll(col);
                TableViewUser.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
                a.showAndWait();
                TableViewUser.getScene().getWindow().hide();;
            }
        } else {
            showdata();
        }
    }

    @FXML
    private void MainMenuButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML_AND_CONTROLLERS/MainMenu/Main_Menu2.fxml"));
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

    
}
