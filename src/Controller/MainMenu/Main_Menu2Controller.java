/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.MainMenu;

//import Data Base Master Class
import DataBase.Master.User.DataBase_User;
import DataBase.Master.CPU.DataBase_CPU;
import DataBase.Master.Cooler.DataBase_Cooler;
import DataBase.Master.GPU.DataBase_GPU;
import DataBase.Master.Mother_Board.DataBase_MotherBoard;
import DataBase.Master.PSU.DataBase_PowerSupply;
import DataBase.Master.RAM.DataBase_RAM;
import DataBase.Master.SSD.DataBase_SSD;
import DataBase.Master.Transaksi.Database_Transaksi;

//import Data Base Slave Class
import DataBase.Slave.Detail_CPU.DataBase_Detail_CPU;
import DataBase.Slave.Detail_Cooler.DataBase_Detail_Cooler;
import DataBase.Slave.Detail_GPU.DataBase_Detail_GPU;
import DataBase.Slave.Detail_Mother_Board.Database_Detail_Mother_Board;
import DataBase.Slave.Detail_PSU.DataBase_Detail_PSU;
import DataBase.Slave.Detail_RAM.Database_Detail_RAM;
import DataBase.Slave.Detail_SSD.Database_Detail_SSD;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import DataBaseConnector.DataBaseUtilities;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Main_Menu2Controller implements Initializable {

    //Master DataBase
    public static DataBase_User Database_User = new DataBase_User();
    public static DataBase_CPU Database_CPU = new DataBase_CPU();
    public static DataBase_GPU Database_GPU = new DataBase_GPU();
    public static DataBase_Cooler Database_Cooler = new DataBase_Cooler();
    public static DataBase_MotherBoard Database_Mobo = new DataBase_MotherBoard();
    public static DataBase_PowerSupply Database_PSU = new DataBase_PowerSupply();
    public static DataBase_SSD Database_SSD = new DataBase_SSD();
    public static DataBase_RAM Database_RAM = new DataBase_RAM();
    public static Database_Transaksi Database_Transaksi = new Database_Transaksi();
    
    
    //Slave Database    
    public static DataBase_Detail_CPU Database_Detail_CPU = new DataBase_Detail_CPU();
    public static DataBase_Detail_Cooler Database_Detail_Cooler = new DataBase_Detail_Cooler();
    public static DataBase_Detail_GPU Database_Detail_GPU = new DataBase_Detail_GPU();
    public static Database_Detail_Mother_Board Database_Detail_Mother_Board = new Database_Detail_Mother_Board();
    public static DataBase_Detail_PSU Database_Detail_PSU = new DataBase_Detail_PSU();
    public static Database_Detail_RAM Database_Detail_RAM = new Database_Detail_RAM();
    public static Database_Detail_SSD Database_Detail_SSD = new Database_Detail_SSD();

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
    private Button LogoutButon;
    @FXML
    private ImageView images;
    @FXML
    private MenuItem RAMDataView;
    @FXML
    private MenuItem SSDDataView;
    @FXML
    private Label WelcomeName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

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
        //Soon
        //Bug 01 Failed to Connected & Read To DataBase
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Making_BluePrint/Making_BluePrint.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Rebuild PC Simulation");
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
    private void GPU_DATAClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/GPU/TableDataGPU.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("GPU Table Data View");
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
    private void MOBO_DATAClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/Mother_Board/TableView_Mother_Board.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Mother Board Table Data View");
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
    private void PowerSupplyDataView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/PSU/TableDataPSU.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Power Supply Table Data View");
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
    private void CoolerDataView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/Cooler/Tableview_Cooler.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Cooler Table Data View");
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
    private void LogoutButonclick(ActionEvent event) {
        DataBaseUtilities.ChangedScences(event, "/FXML/FirstDisplay/MainMenu.fxml", "Main Menu", null);
    }

    @FXML
    private void BlueprintMaked(ActionEvent event) {
        //Soon
        //Bug 2
        //Failed Connect to Database
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/Transaksi/Table_View_Transaksi.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("BluePrint Maked");
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
    private void RAMDataView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/RAM/TableView_RAM.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("RAM Table Data View");
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
    private void SSDDataViewClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/SSD/Table_View_SSD.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("SSD Table Data View");
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

    public void SetUserInformation(String Nama_User) {
        WelcomeName.setText(("Welcome" + " " + Nama_User + " " + "!"));
    }

    public void GetUserInformation() {
        WelcomeName.getText();
    }
}
