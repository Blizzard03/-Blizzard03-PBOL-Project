/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.User;

import Controller.MainMenu.Main_Menu2Controller;
import Models.UsersModels;
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
 * FXML Controller class
 *
 * @author mariq
 */
public class Sign_UpController implements Initializable {
    private boolean Data_Edit=false;
    
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
    @FXML
    private AnchorPane SignUpWindows;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void execute(UsersModels d) {
        NamaText.setText(d.getNama_User());
        EmailText.setText(d.getEmail_User());
        AlamatText.setText(d.getAlamat_User());
        NomorTeleponText.setText(d.getNomor_Telepon_User());
        PasswordText.setText(d.getPassword());
        NamaText.requestFocus();
    }
    
    @FXML
    private void SignupButtonClick(ActionEvent event) {
        UsersModels n=new UsersModels();        
        n.setNama_User(NamaText.getText());     
        n.setEmail_User(EmailText.getText());  
        n.setAlamat_User(AlamatText.getText());
        n.setNomor_Telepon_User(NomorTeleponText.getText());
        n.setPassword(PasswordText.getText());
        Main_Menu2Controller.Database_User.setUserModels(n);
        if(Data_Edit){
            if(Main_Menu2Controller.Database_User.update()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Changed Data Success",ButtonType.OK);
               a.showAndWait();            
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"Changed Data Failed",ButtonType.OK);
                a.showAndWait(); 
            }
            }else if(Main_Menu2Controller.Database_User.validate(n.getID_User())<=0){
            if(Main_Menu2Controller.Database_User.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data Has Saved",ButtonType.OK);
               a.showAndWait();   
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML_AND_CONTROLLERS/FirstDisplay/Main_Menu.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Main Menu");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            SignUpWindows.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
               
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data Failed To Save",ButtonType.OK);
               a.showAndWait(); 
               
            }
        }else{Alert a=new Alert(Alert.AlertType.ERROR,"Data Has Exist",ButtonType.OK);
            a.showAndWait();
            NamaText.requestFocus();
        }
       
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML_AND_CONTROLLERS/FirstDisplay/MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 230);
            Stage stage = new Stage();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
            stage.setScene(scene);
            stage.show();
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
