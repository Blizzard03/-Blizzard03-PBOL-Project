/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.GPU;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.GPU.GPUModels;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Input_GPUController implements Initializable {
   public boolean ChangedData;
   

    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField ID_GPUText;
    @FXML
    private TextField VendorText;
    @FXML
    private TextField Nama_GPUText;
    @FXML
    private TextField VRAMText;
    @FXML
    private TextField MemoryTypeText;
    @FXML
    private TextField FrequencyText;
    @FXML
    private TextField GDPText;
    @FXML
    private TextField PriceText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(GPUModels gs) {
        if (!gs.getID_GPU().isEmpty()) {
            ChangedData = true;
            ID_GPUText.setText(gs.getID_GPU());
            VendorText.setText(gs.getVendor());
            Nama_GPUText.setText(gs.getNama_GPU());
            VRAMText.setText(gs.getVRAM());
            MemoryTypeText.setText(gs.getMemory_Type());
            FrequencyText.setText(gs.getFrequency());
            GDPText.setText(gs.getGDP());
            PriceText.setText(String.valueOf(gs.getHarga()));
            ID_GPUText.setEditable(false);
            ID_GPUText.requestFocus();
        }
    }

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        GPUModels gs = new GPUModels();
        gs.setID_GPU(ID_GPUText.getText());
        gs.setVendor(VendorText.getText());
        gs.setNama_GPU(Nama_GPUText.getText());
        gs.setVRAM(VRAMText.getText());
        gs.setMemory_Type(MemoryTypeText.getText());
        gs.setFrequency(FrequencyText.getText());
        gs.setGDP(GDPText.getText());
        gs.setHarga(Integer.parseInt(PriceText.getText()));

        Main_Menu2Controller.Database_GPU.setGPUModels(gs);
        if (ChangedData) {
            if (Main_Menu2Controller.Database_GPU.Insert_Data()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Insert Data GPU  Successed", ButtonType.OK);
                a.showAndWait();
                ID_GPUText.setEditable(true);
                ResetButtonClick(event);
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
            ResetButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Insert Data GPU Failed", ButtonType.OK);
                a.showAndWait();
                Nama_GPUText.requestFocus();
            }
        }
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ResetButtonClick(ActionEvent event) {
        ID_GPUText.setText("");
        VendorText.setText("");
        Nama_GPUText.setText("");
        VRAMText.setText("");
        MemoryTypeText.setText("");
        FrequencyText.setText("");
        GDPText.setText("");
        PriceText.setText("");
        ID_GPUText.requestFocus();
    }
}
