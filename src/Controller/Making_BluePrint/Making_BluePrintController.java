/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Making_BluePrint;

import java.util.logging.Level;
import java.util.logging.Logger;
import DataBaseConnector.SqlConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Making_BluePrintController implements Initializable {

    /*
     * Buttons
     */
    //Button Cancel
    @FXML
    private Button Cancel_Button;

    //Button Reset
    @FXML
    private Button Reset_Button;

    //Button Order
    @FXML
    private Button Order_Button;

    //Button Select User
    @FXML
    private Button Select_User;
    
    @FXML
    private Button Select_CPU;
    
     @FXML
    private Button Select_Mother_BoardButton;
    @FXML
    private Button Select_Cooler_Button;
    
    /*
     * Labels
     */
    //Label Total Price
    @FXML
    private Label Total_Price;

    //Label CPU Price
    @FXML
    private Label CPU_Price;

    //Label Mother Board Price
    @FXML
    private Label Mobo_Price;

    //Label Cooler Price
    @FXML
    private Label Cooler_Price;

    //Label GPU Price
    @FXML
    private Label GPU_Price;

    //Label SSD Price  
    @FXML
    private Label SSD_Price;

    //Label RAM Price  
    @FXML
    private Label RAM_Price;

    //Label Power Supply
    @FXML
    private Label Power_Supply_Price;

    /*
     * TextFields
     */
    @FXML
    private TextField CPUQTY;

    @FXML
    private TextField MoboQTY;

    @FXML
    private TextField CoolerQTY;
    @FXML
    private TextField GPUQTY;

    @FXML
    private TextField SSD_QTY;

    @FXML
    private TextField RAM_QTY;

    @FXML
    private TextField Power_Supply_QTY;

    @FXML
    private TextField User_Text;
   
    @FXML
    private TextField CPU_Text;
    @FXML
    private TextField Mother_Board_Text;
   
    @FXML
    private TextField Cooler_Text;
    @FXML
    private TextField GPU_Text;
    @FXML
    private Button Select_GPU_Button;
    @FXML
    private Button Selection_SSD_Button;
    @FXML
    private TextField SSD_Text;
    @FXML
    private Button Selection_RAM_Button;
    @FXML
    private TextField RAM_Text;
    @FXML
    private Button Selection_Power_Supply_Button;
    @FXML
    private TextField Power_Supply_Text;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Order_Buton(ActionEvent event) {
    }

    @FXML
    private void Select_User_Click(ActionEvent event) {
    }

    @FXML
    private void Select_CPU_Click(ActionEvent event) {
    }

    @FXML
    private void Select_Mother_Board_Click(ActionEvent event) {
    }

    @FXML
    private void Select_Cooler_Click(ActionEvent event) {
    }

    @FXML
    private void Select_GPU_Click(ActionEvent event) {
    }

    @FXML
    private void Selection_SSD_Click(ActionEvent event) {
    }

    @FXML
    private void Selection_RAM_Click(ActionEvent event) {
    }

    @FXML
    private void Selection_Power_Supply_Click(ActionEvent event) {
    }

    //Cancel Button -> Back To Main Menu
    @FXML
    private void Cancel_Buton_Click(ActionEvent event) {
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
            Cancel_Button.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Reset_Buton_Click(ActionEvent event) {
    }

}
