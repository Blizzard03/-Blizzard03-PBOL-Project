/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.SignUp;

import Controller.MainMenu.Main_Menu2Controller;
import Models.User.UsersModels;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author mariq
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane SignUpWindows;
    @FXML
    private TextField NamaText;
    @FXML
    private TextField EmailText;
    @FXML
    private TextField AlamatText;
    @FXML
    private TextField NomorTeleponText;
    @FXML
    private TextField PasswordText;
    @FXML
    private Button SignupButton;
    @FXML
    private Button CancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

    public void execute(UsersModels d) {
        NamaText.setText(d.getNama_User());
        EmailText.setText(d.getEmail_User());
        AlamatText.setText(d.getAlamat_User());
        NomorTeleponText.setText(d.getNomor_Telepon_User());
        PasswordText.setText(d.getPassword());
    }

    @FXML
    private void SignupButtonClick(ActionEvent event) {
        UsersModels usr = new UsersModels();
        usr.setNama_User(NamaText.getText());
        usr.setEmail_User(EmailText.getText());
        usr.setAlamat_User(AlamatText.getText());
        usr.setNomor_Telepon_User(NomorTeleponText.getText());
        usr.setPassword(PasswordText.getText());
        if (Main_Menu2Controller.Database_User.validate(usr.getID_User()) <= 0) {
            if (Main_Menu2Controller.Database_User.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Has Been Saved", ButtonType.OK);
                a.showAndWait();
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Failed to Save ", ButtonType.OK);
                a.showAndWait();
            }
     
        }
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
