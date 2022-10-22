/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.RAM;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.RAM.RAMModels;
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
public class Input_RAMController implements Initializable {

    public boolean Changed_Data;

    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField ID_RAMText;
    @FXML
    private TextField DDRText;
    @FXML
    private TextField FrequencyText;
    @FXML
    private TextField CapacityText;
    @FXML
    private TextField CLText;
    @FXML
    private TextField PriceText;
    @FXML
    private TextField Nama_RamText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(RAMModels rs) {
        ID_RAMText.setText(rs.getID_RAM());
        Nama_RamText.setText(rs.getNama_RAM());
        DDRText.setText(String.valueOf(rs.getDDR()));
        FrequencyText.setText(rs.getFrequency());
        CapacityText.setText(rs.getCapacity());
        CLText.setText(rs.getCL());
        PriceText.setText(String.valueOf(rs.getHarga()));
        Nama_RamText.requestFocus();
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ResetButtonClick(ActionEvent event) {
        ID_RAMText.setText("");
        Nama_RamText.setText("");
        DDRText.setText("");
        FrequencyText.setText("0 Mhz");
        CapacityText.setText("0 GB");
        CLText.setText("");
        PriceText.setText("");
        Nama_RamText.requestFocus();

    }

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        RAMModels rs = new RAMModels();
        rs.setID_RAM(ID_RAMText.getText());
        rs.setNama_RAM(Nama_RamText.getText());
        rs.setDDR(Integer.parseInt(DDRText.getText()));
        rs.setFrequency(FrequencyText.getText());
        rs.setCapacity(CapacityText.getText());
        rs.setCL(CLText.getText());
        rs.setHarga(Integer.parseInt(PriceText.getText()));
        Main_Menu2Controller.Database_RAM.setRAMModels(rs);
        if (Changed_Data) {
            if (Main_Menu2Controller.Database_GPU.Update_Data()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Insert Data RAM Successed", ButtonType.OK);
                a.showAndWait();
                ID_RAMText.setEditable(true);
                ResetButtonClick(event);
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
                    SaveButton.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Insert Data RAM Failed", ButtonType.OK);
                a.showAndWait();
                Nama_RamText.requestFocus();
            }
        }
    }

}
