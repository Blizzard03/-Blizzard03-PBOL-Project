/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.MainMenu;

import DataBase.Master.CPU.DataBase_CPU;
import DataBase.Master.User.DataBase_User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import DataBaseConnector.DataBaseUtilities;
import javafx.util.Duration;
import java.util.ArrayList;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Main_Menu2Controller implements Initializable {
    
    public static DataBase_User Database_User = new DataBase_User();
    public static DataBase_CPU Database_CPU = new DataBase_CPU();
    
    @FXML
    private MenuItem BlueprintMake;
    @FXML
    private MenuItem User_DATA;
    @FXML
    private MenuItem CPU_DATA;
    @FXML
    private MenuItem GPU_DATA;
    @FXML
    private MenuItem MOBO_DATA;
    @FXML
    private MenuItem AboutMenu;
    @FXML
    private AnchorPane MainMenu;
    @FXML
    private MenuItem MakeBuild;
    @FXML
    private MenuItem PowerSupplyDataView;
    @FXML
    private MenuItem CoolerDataView;
    @FXML
    private MenuItem Detail_CPUDataView;
    @FXML
    private MenuItem Detail_GPUDataView;
    @FXML
    private MenuItem Detail_RAMDataView;
    @FXML
    private MenuItem Detail_Mother_Board_Data_View;
    @FXML
    private MenuItem Detail_Power_Supply_Data_View;
    @FXML
    private MenuItem Detail_Cooler_DataView;
    
    @FXML
    private Button LogoutButon;
    @FXML
    private ImageView images;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
        
    
    @FXML
    private void BlueprintMake(ActionEvent event) {
    }
    
    @FXML
    private void ViewUserData(ActionEvent event) {
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
            MainMenu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    private void ViewCPUData(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/CPU/TableDataCPU.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("CPU Table Data View");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            MainMenu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void AboutMenuClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/About/About.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("About Me");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            MainMenu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void BlueprintMaker(ActionEvent event) {
    }
    
    @FXML
    private void GPU_DATAClick(ActionEvent event) {
    }
    
    @FXML
    private void MOBO_DATAClick(ActionEvent event) {
    }
    
    @FXML
    private void PowerSupplyDataView(ActionEvent event) {
    }
    
    @FXML
    private void CoolerDataView(ActionEvent event) {
    }
    
    @FXML
    private void Detail_CPUDataViewClick(ActionEvent event) {
    }
    
    @FXML
    private void Detail_GPUDataViewClick(ActionEvent event) {
    }
    
    @FXML
    private void Detail_RAMDataViewClick(ActionEvent event) {
    }
    
    @FXML
    private void Detail_Mother_Board_Data_View_Click(ActionEvent event) {
    }
    
    @FXML
    private void Detail_Power_Supply_Data_View_Click(ActionEvent event) {
    }
    
    @FXML
    private void Detail_Cooler_DataViewClick(ActionEvent event) {
    }
    
    @FXML
    private void LogoutButonclick(ActionEvent event) {
        DataBaseUtilities.ChangedScences(event, "FXML_AND_CONTROLLERS/FirstDisplay/MainMenu.fxml", "Main Menu", null);
    }
    
//public void SetUserInformaration(String Nama_User) {
       // WelcomeName.setText(("Welcome" + Nama_User + "!"));
   // }
}
