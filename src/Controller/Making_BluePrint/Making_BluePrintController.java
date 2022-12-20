/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Making_BluePrint;

/*
 * FXML CONTROLLER
 */
import Controller.MainMenu.Main_Menu2Controller;


/*
 * Controller Select Data Class
 */
import Controller.SelectData.Customer.FXMLCustomersController;
import Controller.SelectData.CPU.FXMLSelectCPUController;
import Controller.SelectData.Cooler.FXMLSelectCoolerController;
import Controller.SelectData.GPU.FXMLSelectionGPUController;
import Controller.SelectData.MotherBoard.FXMLSelectionMotherBoardController;
import Controller.SelectData.PowerSupply.FXMLSelectionPoweSupplyController;
import Controller.SelectData.RAM.FXMLRAMSellectionController;
import Controller.SelectData.SSD.FXMLSelectionSSDController;

import java.io.IOException;
import Models.Master.Transaksi.TransaksiModels;
import Models.Slave.Detail_CPU.Detail_CPU_Models;
import Models.Slave.Detail_Cooler.Detail_Cooler_Models;
import Models.Slave.Detail_GPU.Detail_GPU_Models;
import Models.Slave.Detail_Mother_Board.Detail_Mother_Board_Models;
import Models.Slave.Detail_RAM.Detail_RAM_Models;
import Models.Slave.Detail_SSD.Detail_SSD_Models;
import Models.Slave.Detail_PSU.Detail_PSU_Models;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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

    boolean Make_Order = false;
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

    //Button Add CPU
    @FXML
    private Button AddCPU;

    //Button Add Mother Board
    @FXML
    private Button AddMoboButton;

    //Button Add Cooler 
    @FXML
    private Button AddCoolerButton;

    //Add GPU
    @FXML
    private Button AddGPUButton;

    //Add SSD
    @FXML
    private Button AddSSDButton;

    //Add RAM
    @FXML
    private Button AddRAMButton;

    //Add PSU
    @FXML
    private Button AddPSUButton;

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
    @FXML
    private Label Name_User;

//Date Picker
    @FXML
    private DatePicker Tanggal_Transaksi;
    @FXML
    private Button DeleteCPU;
    @FXML
    private Button DeleteMotherBoard;
    @FXML
    private Button DeleteCoolerButton;
    @FXML
    private Button DeleteGPU;
    @FXML
    private Button DeleteSSDButton;
    @FXML
    private Button RAM;
    @FXML
    private Button DeletePSUClick;
    @FXML
    private Label TotalPower_Supply_Price;
    @FXML
    private Label TotalRAM_Price;
    @FXML
    private Label TotalSSD_Price;
    @FXML
    private Label TotalGPU_Price;
    @FXML
    private Label TotalCooler_Price;
    @FXML
    private Label TotalMobo_Price;
    @FXML
    private Label TotalCPU_Price;

   

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }



//Save Transcitions
    @FXML
    private void Order_Buton(ActionEvent event) {
        TransaksiModels tm = new TransaksiModels();
        tm.setNomor_Transaksi(Transaksi_Text.getText());
        tm.setTanggal_Transaksi(Date.valueOf(Tanggal_Transaksi.getValue()));
        tm.setID_User(Integer.parseInt(User_Text.getText()));
        Main_Menu2Controller.Database_Transaksi.setJualModel(tm);
        if (Main_Menu2Controller.Database_Transaksi.insert()) {
            Make_Order = true;
            Alert a = new Alert(Alert.AlertType.INFORMATION,
                    "Transaction is successfully created", ButtonType.OK);
            a.showAndWait();
            //batalklik();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Transaction failed to be created", ButtonType.OK);
            a.showAndWait();
        }

    }

    @FXML
    private void Select_User_Click(ActionEvent event) {
        User_Text.setEditable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/Costumer/FXMLCustomers.fxml"));
            Parent root = (Parent) loader.load();
            FXMLCustomersController isidt = (FXMLCustomersController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getResult() == 1) {
                User_Text.setText(String.valueOf(isidt.getID_Userhasil()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void Select_CPU_Click(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {
            CPU_Text.setEditable(false);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/CPU/FXMLSelectCPU.fxml"));
                Parent root = (Parent) loader.load();
                FXMLSelectCPUController isidt = (FXMLSelectCPUController) loader.getController();
                Scene scene = new Scene(root);
                Stage stg = new Stage();
                stg.initModality(Modality.APPLICATION_MODAL);
                stg.setResizable(false);
                stg.setIconified(false);
                stg.setScene(scene);
                stg.showAndWait();
                if (isidt.getResult() == 1) {
                    CPU_Text.setText(isidt.GetIDCPUResult());
                    CPU_Price.setText(String.valueOf(isidt.GetPrice()));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void Select_Mother_Board_Click(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {
            CPU_Text.setEditable(false);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/Mother_Board/FXMLSelectionMotherBoard.fxml"));
                Parent root = (Parent) loader.load();
                FXMLSelectionMotherBoardController isidt = (FXMLSelectionMotherBoardController) loader.getController();
                Scene scene = new Scene(root);
                Stage stg = new Stage();
                stg.initModality(Modality.APPLICATION_MODAL);
                stg.setResizable(false);
                stg.setIconified(false);
                stg.setScene(scene);
                stg.showAndWait();
                if (isidt.GetResult() == 1) {
                    Mother_Board_Text.setText(isidt.getIDMotherBaord());
                    Mobo_Price.setText(String.valueOf(isidt.Price()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void Select_Cooler_Click(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {
            Cooler_Text.setEditable(false);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/Cooler/FXMLSelectCooler.fxml"));
                Parent root = (Parent) loader.load();
                FXMLSelectCoolerController isidt = (FXMLSelectCoolerController) loader.getController();
                Scene scene = new Scene(root);
                Stage stg = new Stage();
                stg.initModality(Modality.APPLICATION_MODAL);
                stg.setResizable(false);
                stg.setIconified(false);
                stg.setScene(scene);
                stg.showAndWait();
                if (isidt.getResult() == 1) {
                    Cooler_Text.setText(isidt.getIDCoolerResult());
                    Cooler_Price.setText(String.valueOf(isidt.getPrice()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void Select_GPU_Click(ActionEvent event) {
        CPU_Text.setEditable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/GPU/FXMLSelectionGPU.fxml"));
            Parent root = (Parent) loader.load();
            FXMLSelectionGPUController isidt = (FXMLSelectionGPUController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getResult() == 1) {
                GPU_Text.setText(isidt.ID_GPU());
                GPU_Price.setText(String.valueOf(isidt.GetPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Selection_SSD_Click(ActionEvent event) {
        CPU_Text.setEditable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/SSD/FXMLSelectionSSD.fxml"));
            Parent root = (Parent) loader.load();
            FXMLSelectionSSDController isidt = (FXMLSelectionSSDController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getResult() == 1) {
                SSD_Text.setText(String.valueOf(isidt.getIDSSDResult()));
                SSD_Price.setText(String.valueOf(isidt.getPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Selection_RAM_Click(ActionEvent event) {
        CPU_Text.setEditable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/RAM/FXMLRAMSellection.fxml"));
            Parent root = (Parent) loader.load();
            FXMLRAMSellectionController isidt = (FXMLRAMSellectionController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getResult() == 1) {
                RAM_Text.setText(String.valueOf(isidt.getRAMResult()));
                RAM_Price.setText(String.valueOf(isidt.getPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Selection_Power_Supply_Click(ActionEvent event) {
        CPU_Text.setEditable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Select/Power_Supply/FXMLSelectionPoweSupply.fxml"));
            Parent root = (Parent) loader.load();
            FXMLSelectionPoweSupplyController isidt = (FXMLSelectionPoweSupplyController) loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
            if (isidt.getResult() == 1) {
                Power_Supply_Text.setText(isidt.getPSUResult());
                Power_Supply_Price.setText(String.valueOf(isidt.getPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Transaksi_Text.setText("TRS_00");
    }

    @FXML
    private void AddCPUCLick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_CPU_Models d = new Detail_CPU_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_CPU(CPU_Text.getText());
            d.setQuantity(Integer.parseInt(CPUQTY.getText()));

            Main_Menu2Controller.Database_Detail_CPU.setDetail_CPU_Models(d);
            if (Main_Menu2Controller.Database_Detail_CPU.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "CPU Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "CPU Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void AddMoboCllick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_Mother_Board_Models d = new Detail_Mother_Board_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_MOTHER_BOARD(Mother_Board_Text.getText());
            d.setQuantity(Integer.parseInt(MoboQTY.getText()));

            Main_Menu2Controller.Database_Detail_Mother_Board.setDetail_Mother_Board_Models(d);
            if (Main_Menu2Controller.Database_Detail_Mother_Board.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "Mother Board Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Mother Board Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void AddCoolerClick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_Cooler_Models d = new Detail_Cooler_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_COOLER(Cooler_Text.getText());
            d.setQuantity(Integer.parseInt(CoolerQTY.getText()));

            Main_Menu2Controller.Database_Detail_Cooler.setDetail_Cooler_Model(d);
            if (Main_Menu2Controller.Database_Detail_Cooler.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "Cooler Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Cooler Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void AddGPUClick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_GPU_Models d = new Detail_GPU_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_GPU(GPU_Text.getText());
            d.setQuantity(Integer.parseInt(GPUQTY.getText()));

            Main_Menu2Controller.Database_Detail_GPU.setDetail_GPU_Models(d);
            if (Main_Menu2Controller.Database_Detail_CPU.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "GPU Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "GPU Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void AddSSDButtonClick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_SSD_Models d = new Detail_SSD_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_SSD(SSD_Text.getText());
            d.setQuantity(Integer.parseInt(SSD_QTY.getText()));

            Main_Menu2Controller.Database_Detail_SSD.SetDetail_SSD_Models(d);
            if (Main_Menu2Controller.Database_Detail_SSD.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "SSD Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "SSD Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void AddRAMButtonCllick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_RAM_Models d = new Detail_RAM_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_RAM(RAM_Text.getText());
            d.setQuantity(Integer.parseInt(RAM_QTY.getText()));

            Main_Menu2Controller.Database_Detail_RAM.SetDetail_RAM_Models(d);
            if (Main_Menu2Controller.Database_Detail_RAM.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "RAM Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "RAM Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void AddPSUClick(ActionEvent event) {
        if (!Make_Order) {
            Alert a = new Alert(Alert.AlertType.ERROR,
                    "Please Click Order For Transaction!", ButtonType.OK);
            a.showAndWait();
        } else {

            Detail_PSU_Models d = new Detail_PSU_Models();
            d.setNomor_Transaksi(Transaksi_Text.getText());
            d.setID_PSU(Power_Supply_Text.getText());
            d.setQuantity(Integer.parseInt(Power_Supply_QTY.getText()));

            Main_Menu2Controller.Database_Detail_PSU.setDetail_PSU_Models(d);
            if (Main_Menu2Controller.Database_Detail_PSU.Insert_Data()) {
                Alert a = new Alert(
                        Alert.AlertType.INFORMATION, "Power Supply Succes to Added", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Power Supply Fail to Added", ButtonType.OK);
                a.showAndWait();
            }

        }
    }

    @FXML
    private void DelteCPUCLick(ActionEvent event) {
    }

    @FXML
    private void DeleteMotherBoardCLick(ActionEvent event) {
    }

    @FXML
    private void DeleteCoolerButtonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteGPUClick(ActionEvent event) {
    }

    @FXML
    private void DeleteSSDButtonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteRAMClick(ActionEvent event) {
    }

    @FXML
    private void DeletePSUCLICK(ActionEvent event) {
    }

}
