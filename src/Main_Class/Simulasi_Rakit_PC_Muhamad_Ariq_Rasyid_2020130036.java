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
import javafx.scene.Parent;
import javafx.stage.Modality;

/**
 *
 * @author mariq
 */
public class Simulasi_Rakit_PC_Muhamad_Ariq_Rasyid_2020130036 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //Real
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FirstDisplay/MainMenu.fxml"));
        //Testing 
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/FXML/MainMenu/Main_Menu2.fxml"));
        Parent root = (Parent) loader2.load();
        Scene scene = new Scene(root);
        Stage stg = new Stage();
        stg.setTitle("Main Menu");
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
