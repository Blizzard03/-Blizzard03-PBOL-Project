/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.SignUp;

import DataBaseConnector.DataBaseUtilities;
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

    @FXML
    private void SignupButtonClick(ActionEvent event) {
        if (!NamaText.getText().trim().isEmpty() && !EmailText.getText().trim().isEmpty() && !AlamatText.getText().trim().isEmpty() && !NomorTeleponText.getText().trim().isEmpty() && !PasswordText.getText().trim().isEmpty()) {
            DataBaseUtilities.signupuser(event, NamaText.getText(), EmailText.getText(), AlamatText.getText(), NomorTeleponText.getText(), PasswordText.getText());
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please Fill Data For Sign Up!!!");
            a.show();
        }
        
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FirstDisplay/MainMenu.fxml"));
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
