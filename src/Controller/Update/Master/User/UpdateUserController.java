/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Update.Master.User;

import Models.Master.User.UsersModels;
import Controller.MainMenu.Main_Menu2Controller;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class UpdateUserController implements Initializable {

    public boolean ChangeData;
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
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(UsersModels us) {
        if (!us.getNama_User().isEmpty()) {
            ChangeData = true;
            NamaText.setText(us.getNama_User());
            EmailText.setText(us.getEmail_User());
            AlamatText.setText(us.getAlamat_User());
            NomorTeleponText.setText(us.getNomor_Telepon_User());
            PasswordText.setText(us.getPassword());
            NamaText.setEditable(false);
            NamaText.requestFocus();
        }
    }

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        UsersModels ss = new UsersModels();
        ss.setNama_User(NamaText.getText());
        ss.setEmail_User(EmailText.getText());
        ss.setAlamat_User(AlamatText.getText());
        ss.setNomor_Telepon_User(NomorTeleponText.getText());
        ss.setPassword(PasswordText.getText());
        Main_Menu2Controller.Database_User.setUserModels(ss);
        if (ChangeData) {
            if (Main_Menu2Controller.Database_User.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Update Data User Successed", ButtonType.OK);
                a.showAndWait();
                NamaText.setEditable(true);
                ResetButtonClick(event);
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/User/TableDataUser.fxml"));
                    Parent root = (Parent) loader.load();
                    Scene scene = new Scene(root);
                    Stage stg = new Stage();
                    stg.setTitle("User Table Data View");
                    stg.initModality(Modality.APPLICATION_MODAL);
                    stg.setResizable(false);
                    stg.setIconified(false);
                    stg.setScene(scene);
                    stg.show();
                    SaveButton.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Update Data User Failed", ButtonType.OK);
                a.showAndWait();
                NamaText.requestFocus();
            }
        }
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/User/TableDataUser.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("User Table Data View");
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

    @FXML
    private void ResetButtonClick(ActionEvent event) {
        NamaText.setText("");
        EmailText.setText("");
        AlamatText.setText("");
        NomorTeleponText.setText("");
        PasswordText.setText("");
        NamaText.requestFocus();
    }

}
