/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Main_Class;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author mariq
 */
public class Simulasi_Rakit_PC_Muhamad_Ariq_Rasyid_2020130036 extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML_AND_CONTROLLERS/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 230);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show(); 
        stage.setScene(scene);
        stage.show();
    }
    
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
}
