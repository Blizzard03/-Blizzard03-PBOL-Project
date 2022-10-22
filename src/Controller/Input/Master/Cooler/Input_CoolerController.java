/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.Cooler;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.Cooler.CoolerModels;
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
public class Input_CoolerController implements Initializable {

    public boolean Changed_Data;

    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField ID_CoolerText;
    @FXML
    private TextField Nama_CoolerText;
    @FXML
    private TextField TypeText;
    @FXML
    private TextField Socketext;

    @FXML
    private TextField PriceText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(CoolerModels cs) {
        ID_CoolerText.setText(cs.getID_COOLER());
        Nama_CoolerText.setText(cs.getNama_Cooler());
        TypeText.setText(cs.getType());
        Socketext.setText(cs.getSocket());
        PriceText.setText(String.valueOf(cs.getHarga()));
        Nama_CoolerText.requestFocus();
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
        ID_CoolerText.setText("");
        Nama_CoolerText.setText("");
        TypeText.setText("");
        Socketext.setText("");
        PriceText.setText("");
        Nama_CoolerText.requestFocus();

    }

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        CoolerModels cs = new CoolerModels();
        cs.setID_COOLER(ID_CoolerText.getText());
        cs.setNama_Cooler(Nama_CoolerText.getText());
        cs.setType(TypeText.getText());
        cs.setSocket(Socketext.getText());
        cs.setHarga(Integer.parseInt(PriceText.getText()));
        Nama_CoolerText.requestFocus();
        Main_Menu2Controller.Database_Cooler.setCoolerModels(cs);;
        if (Changed_Data) {
            if (Main_Menu2Controller.Database_Cooler.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Create Data Cooler Successed", ButtonType.OK);
                a.showAndWait();
                ID_CoolerText.setEditable(true);
                ResetButtonClick(event);
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
                    SaveButton.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Create Data Cooler Failed", ButtonType.OK);
                a.showAndWait();
                Nama_CoolerText.requestFocus();
            }
        }
    }

}
