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

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //Button
    @FXML
    private Button Cancel_Button;
    //Button
    private Button Reset_Button;

    //String List
    //CPU
    private String Nama_CPU;
    //GPU
    private String Nama_GPU;
    //Cooler
    private String Nama_Cooler;

    //List CPU
    //AMD
    final ObservableList Options_AMD = FXCollections.observableArrayList();

    //Intel
    final ObservableList Options_Intel = FXCollections.observableArrayList();

    //List GPU
    //Radeon
    final ObservableList Options_Radeon = FXCollections.observableArrayList();

    //NVDIA
    final ObservableList Options_NVIDIA = FXCollections.observableArrayList();

    //List SSD
    final ObservableList Option_Cooler = FXCollections.observableArrayList();

    //Radio Button
    //CPU
    @FXML
    private RadioButton AMDRadio;
    @FXML
    private RadioButton IntelRadio;

    //GPU
    @FXML
    private RadioButton RadeonRadio;
    @FXML
    private RadioButton NVDIARadio;

    //Cooler
    @FXML
    private RadioButton AirRadio;
    @FXML
    private RadioButton LiquidRadio;

    @FXML
    private ComboBox<String> SelectionCPU;
    @FXML
    private ComboBox<String> Selection_Mobo;

    @FXML
    private ComboBox<?> Selection_Cooler;

    @FXML
    private TextField CPUQTY;
    @FXML
    private Label CPU_Price;
    @FXML
    private Label Mobo_Price;
    @FXML
    private TextField MoboQTY;
    @FXML
    private Label Cooler_Price;
    @FXML
    private TextField CoolerQTY;
    /* @FXML
    private ComboBox<?> Selection_GPU;
    @FXML
    private ComboBox<?> Selection_SSD;
    @FXML
    private ComboBox<?> Selection_RAM;
    @FXML
    private ComboBox<?> Selection_RAM1;
    @FXML*/
    @FXML
    private TextField GPUQTY;
    @FXML
    private Label GPU_Price;
    @FXML
    private TextField CPUQTY22;
    @FXML
    private Label CPU_Price22;
    @FXML
    private TextField CPUQTY23;
    @FXML
    private Label CPU_Price23;
    @FXML
    private TextField CPUQTY24;
    @FXML
    private Label CPU_Price24;
    @FXML
    private Button Order_Button;
    @FXML
    private Label Name_User;
    @FXML
    private ComboBox<?> Userlist;
    @FXML
    private ToggleGroup CPU;
    @FXML
    private ToggleGroup Cooler;
    @FXML
    private ToggleGroup GPU;
    @FXML
    private ComboBox<?> Selection_GPU;
    @FXML
    private ComboBox<?> Selection_SSD;
    @FXML
    private ComboBox<?> Selection_RAM;
    @FXML
    private ComboBox<?> Selection_RAM1;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CheckConnection();
        FillComboBoxAMD();
        ToggleGroup CPU = new ToggleGroup();
        AMDRadio = new RadioButton("AMD");
        
        ComboBox CPU_Selection = new ComboBox(Options_AMD);
        
      
       
        CPU_Selection.setOnAction(e -> {
            try {
                String query = "SELECT Vendor, Nama_CPU,Harga FROM CPU WHERE Vendor =?";
                pst = conn.prepareStatement(query);
                pst.setString(1, (String) CPU_Selection.getSelectionModel().getSelectedItem());
                rs = pst.executeQuery();
                while (rs.next()) {
                    if ("AMD".equals(rs.getString("AMD"))) {
                        AMDRadio.setSelected(true);
                        CPU_Price24.setText(rs.getNString("Harga"));
                    }else if ("Intel".equals(rs.getString("Intel"))){
                        IntelRadio.setSelected(true);
                        CPU_Price24.setText(rs.getNString("Harga"));
                    }else {
                        AMDRadio.setSelected(false);
                        IntelRadio.setSelected(false);
                    }

                }
                pst.close();;
                rs.close();
            } catch (SQLException error) {
                Logger.getLogger(Making_BluePrintController.class.getName()).log(Level.SEVERE, null, e);
            }
        });
        
        
    }

//Cancel Button -> Back To Main Menu
    @FXML
    private void Cancel_Buton(ActionEvent event) {
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

    public void FillComboBoxAMD(){
        Options_AMD.clear();
        try{
            String Query = "Select Vendor, Nama_CPU from cpu where Vendor=?";
            pst = conn.prepareStatement(Query);
            rs = pst.executeQuery();
            while(rs.next()){
                Options_AMD.add("AMD".equals(rs.getString("Vendor")));
            }
            pst.close();
            rs.close();
        }catch (SQLException error){
            Logger.getLogger(Making_BluePrintController.class.getName()).log(Level.SEVERE,null,error);
        }
    }
    
    public void CheckConnection(){
        conn = SqlConnection.DbConnector();
        if(conn == null){
            System.out.println("Connection Not Successful");
            System.exit(1);            
        }else{
            System.out.println("Connection Successful");
        }
    }

    @FXML
    private void AMDselection(ActionEvent event) {
         AMDRadio.requestFocus();
        AMDRadio.setToggleGroup(CPU);
        Nama_CPU = AMDRadio.getText();
        FillComboBoxAMD();
        
    }

    @FXML
    private void IntelSelection(ActionEvent event) {
         IntelRadio.requestFocus();
        IntelRadio.setToggleGroup(CPU);
        Nama_CPU = IntelRadio.getText();
    }

    @FXML
    private void LiquidSelection(ActionEvent event) {
    }

    @FXML
    private void AirSelection(ActionEvent event) {
    }

    @FXML
    private void RadeonSelection(ActionEvent event) {
    }

    @FXML
    private void NVDIASelectioin(ActionEvent event) {
    }

    @FXML
    private void Order_Buton(ActionEvent event) {
    }

    @FXML
    private void Reset_Buton(ActionEvent event) {
    }
}
