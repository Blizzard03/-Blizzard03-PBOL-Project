/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller.FirstDisplay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *
 * @author mariq
 */
public class MainMenuController implements Initializable {
    
    
    @FXML
    private Button Login_Button;
    @FXML
    private Button Sign_Up_Button;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Sign_Up_Click(ActionEvent event) {
            try{  
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/SignUp/Sign_Up.fxml"));    
        Scene scene = new Scene(fxmlLoader.load(), 402,451);
        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();    
         Sign_Up_Button.getScene().getWindow().hide();
        } catch (IOException e){   e.printStackTrace();   }
    }
    
    
    @FXML
    private void Login_Click(ActionEvent event) {
        try{  
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Login/Login.fxml"));    
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();   
        Login_Button.getScene().getWindow().hide();
        } catch (IOException e){   e.printStackTrace();   }
    }
    }

