/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.SSD;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.SSD.SSDModels;
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
public class Input_SSDController implements Initializable {
  public boolean Changed_Data;
    @FXML
    private TextField ID_SSDText;
    @FXML
    private TextField VendorText;
    @FXML
    private TextField Nama_SSDText;
    @FXML
    private TextField TypeText;
    @FXML
    private TextField TBWText;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField ReadText;
    @FXML
    private TextField WriteText;
    @FXML
    private TextField PriceText;
    @FXML
    private TextField CapacityText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(SSDModels ssd) {
        if (!ssd.getID_SSD().isEmpty()) {
            Changed_Data = true;
            ID_SSDText.setText(ssd.getID_SSD());
            VendorText.setText(ssd.getVendor());
            Nama_SSDText.setText(ssd.getNama_SSD());
            TypeText.setText(ssd.getType());
            CapacityText.setText(ssd.getCapacity());
            TBWText.setText(String.valueOf(ssd.getTBW()));
            ReadText.setText(ssd.getRead());
            WriteText.setText(ssd.getWrite());
            PriceText.setText(String.valueOf(ssd.getHarga()));
            ID_SSDText.setEditable(false);
            ID_SSDText.requestFocus();
        }
    }

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        SSDModels ssd = new SSDModels();
        ssd.setID_SSD(ID_SSDText.getText());
        ssd.setVendor(VendorText.getText());
        ssd.setNama_SSD(Nama_SSDText.getText());;
        ssd.setType(TypeText.getText());
        ssd.setCapacity(CapacityText.getText());
        ssd.setTBW(Integer.parseInt(TBWText.getText()));
        ssd.setRead(ReadText.getText());
        ssd.setWrite(WriteText.getText());
        ssd.setHarga(Integer.parseInt(PriceText.getText()));

        Main_Menu2Controller.Database_SSD.setSSDModels(ssd);
        if (Changed_Data) {
            if (Main_Menu2Controller.Database_GPU.Update_Data()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Insert Data SSD Successed", ButtonType.OK);
                a.showAndWait();
                ID_SSDText.setEditable(true);
                ResetButtonClick(event);
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
                    SaveButton.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Insert Data SSD Failed", ButtonType.OK);
                a.showAndWait();
                Nama_SSDText.requestFocus();
            }
        }
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ResetButtonClick(ActionEvent event) {
        ID_SSDText.setText("");
        VendorText.setText("");
        Nama_SSDText.setText("");
        TypeText.setText("");
        CapacityText.setText("");
        TBWText.setText("");
        ReadText.setText("");
        WriteText.setText("");
        PriceText.setText("");

    }    
}
