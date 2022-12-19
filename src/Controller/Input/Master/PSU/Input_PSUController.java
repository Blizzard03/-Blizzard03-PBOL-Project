/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.PSU;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.PSU.PSU_Models;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Input_PSUController implements Initializable {

    public boolean Data_Edit;

    private final Desktop pc = Desktop.getDesktop();
    @FXML
    private TextField ID_PSUText;
    @FXML
    private TextField ImageText;
    @FXML
    private TextField Vendor_Text;
    @FXML
    private TextField Nama_PSU_Text;
    @FXML
    private TextField WattText;
    @FXML
    private Button Save_Button;
    @FXML
    private Button CancelButton;
    @FXML
    private Button BrowseButton;
    @FXML
    private Button Save_Image_Button;
    @FXML
    private TextField HargaText;
    @FXML
    private ImageView Imagesview;
    @FXML
    private TextField TierText;

    private FileInputStream fis;
    @FXML
    private Button ResetButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(PSU_Models psu) {
        if (!psu.getID_PSU().isEmpty()) {
            Data_Edit = true;
            ID_PSUText.setText(psu.getID_PSU());
            Vendor_Text.setText(psu.getVendor());
            Nama_PSU_Text.setText(psu.getNama_PSU());
            WattText.setText(String.valueOf(psu.getWatt()));
            TierText.setText(psu.getTier());
            HargaText.setText(String.valueOf(psu.getHarga()));
            ID_PSUText.setEditable(false);
            ID_PSUText.requestFocus();
        }
    }

    

    @FXML
    private void CancelButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/PSU/TableDataPSU.fxml"));
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
        ID_PSUText.setText("");
        Vendor_Text.setText("");
        Nama_PSU_Text.setText("");
        WattText.setText("");
        TierText.setText("");
        HargaText.setText("");
        ID_PSUText.requestFocus();

    }

    @FXML
    private void Save_Data_Button_Click(ActionEvent event) {
            PSU_Models psu = new PSU_Models();
        psu.setID_PSU(ID_PSUText.getText());
        psu.setVendor(Vendor_Text.getText());
        psu.setNama_PSU(Nama_PSU_Text.getText());
        psu.setWatt(Integer.parseInt(WattText.getText()));
        psu.setTier(TierText.getText());
        psu.setHarga(Integer.parseInt(HargaText.getText()));
        Main_Menu2Controller.Database_PSU.setPSU_Models(psu);
        if (Data_Edit) {
            if (Main_Menu2Controller.Database_PSU.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Insert Data PSU Successed", ButtonType.OK);
                a.showAndWait();
                ID_PSUText.setEditable(true);
                ResetButtonClick(event);
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Tableviews/Master/PSU/TableDataPSU.fxml"));
                    Parent root = (Parent) loader.load();
                    Scene scene = new Scene(root);
                    Stage stg = new Stage();
                    stg.setTitle("PSU Table Data View");
                    stg.initModality(Modality.APPLICATION_MODAL);
                    stg.setResizable(false);
                    stg.setIconified(false);
                    stg.setScene(scene);
                    stg.show();
                    Save_Button.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Insert Data PSU Failed", ButtonType.OK);
                a.showAndWait();
                Nama_PSU_Text.requestFocus();
            }
        }
    }

    @FXML
    private void BrowseButtonClick(ActionEvent event) {
    }

    @FXML
    private void Save_Image_Button_Click(ActionEvent event) {
    }
}
