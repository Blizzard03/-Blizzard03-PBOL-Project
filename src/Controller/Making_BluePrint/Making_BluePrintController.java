/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Making_BluePrint;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

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

    //Button Selecct CPU
    @FXML
    private Button Select_CPU;

    //Button Select Mother Board
    @FXML
    private Button Select_Mother_BoardButton;

    //Button Select Cooler
    @FXML
    private Button Select_Cooler_Button;

    //Button Select GPU
    @FXML
    private Button Select_GPU_Button;

    //Button Select SSD
    @FXML
    private Button Selection_SSD_Button;

    //Button Select Power Supply
    @FXML
    private Button Selection_Power_Supply_Button;

    //Button Select RAM
    @FXML
    private Button Selection_RAM_Button;

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
    //TextField Quantity CPU
    @FXML
    private TextField CPUQTY;

    //TextField Quantity Mother Board
    @FXML
    private TextField MoboQTY;

    //TextField Quantity Cooler
    @FXML
    private TextField CoolerQTY;

    //TextField Quantity GPU
    @FXML
    private TextField GPUQTY;

    //TextField Quantity SSD
    @FXML
    private TextField SSD_QTY;

    //TextField Quantity RAM
    @FXML
    private TextField RAM_QTY;

    //TextField Quanity Power Supply
    @FXML
    private TextField Power_Supply_QTY;

    //TextField User
    @FXML
    private TextField User_Text;

    //TextField CPU
    @FXML
    private TextField CPU_Text;

    //TextField Mother Board
    @FXML
    private TextField Mother_Board_Text;

    //TextField Cooler
    @FXML
    private TextField Cooler_Text;

    //TextField GPU
    @FXML
    private TextField GPU_Text;

    //TextField SSD
    @FXML
    private TextField SSD_Text;

    //TextFlied RAM
    @FXML
    private TextField RAM_Text;

    //TextField Power Supply
    @FXML
    private TextField Power_Supply_Text;
    
    //TextField Transaksi
    @FXML
    private TextField Transaksi_Text;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Order_Buton(ActionEvent event) {
    }

    @FXML
    private void Select_User_Click(ActionEvent event) {
        User_Text.setEditable(false);
        
    }

    @FXML
    private void Select_CPU_Click(ActionEvent event) {
        CPU_Text.setEditable(false);
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
        CPUQTY.setText("");
        MoboQTY.setText("");
        CoolerQTY.setText("");
        GPUQTY.setText("");
        SSD_QTY.setText("");
        RAM_QTY.setText("");
        Power_Supply_QTY.setText("");
        User_Text.setText("");
        CPU_Text.setText("");
        Mother_Board_Text.setText("");
        Cooler_Text.setText("");
        GPU_Text.setText("");
        SSD_Text.setText("");
        RAM_Text.setText("");
        Power_Supply_Text.setText("");
        Transaksi_Text.setText("");
    }

}
