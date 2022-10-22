/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.CPU;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.CPU.CPUModels;
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
public class Input_CPUController implements Initializable {
public boolean TextEdit;
    @FXML
    private TextField ID_CPUText;
    @FXML
    private TextField Nama_CPUText;
    @FXML
    private TextField SocketText;
    @FXML
    private TextField Base_ClockText;
    @FXML
    private TextField CoresText;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField TreadText;
    @FXML
    private TextField TDPText;
    @FXML
    private TextField PriceText;
    @FXML
    private TextField Max_Turbo_Clock_Text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  public void execute(CPUModels cpu) {
        ID_CPUText.setText(cpu.getID_CPU());
        Nama_CPUText.setText(cpu.getNama_CPU());
        SocketText.setText(cpu.getSocket());
        Base_ClockText.setText(cpu.getBase_Clock());
        Max_Turbo_Clock_Text.setText(cpu.getMax_Turbo_Clock());
        CoresText.setText(String.valueOf(cpu.getCores()));
        TreadText.setText(String.valueOf(cpu.getThread()));
        TDPText.setText(cpu.getTDP());
        PriceText.setText(String.valueOf(cpu.getHarga()));
        Nama_CPUText.requestFocus();
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ResetButtonClick(ActionEvent event) {
        ID_CPUText.setText("");
        Nama_CPUText.setText("");
        SocketText.setText("");
        Base_ClockText.setText("0.0 Ghz");
        Max_Turbo_Clock_Text.setText("Up to 0.0 Ghz");
        CoresText.setText("");
        TreadText.setText("");
        TDPText.setText("0 W");
        PriceText.setText("");
        Nama_CPUText.requestFocus();
    }

    

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        CPUModels cpu = new CPUModels();
        cpu.setID_CPU(ID_CPUText.getText());
        cpu.setNama_CPU(Nama_CPUText.getText());
        cpu.setSocket(SocketText.getText());
        cpu.setBase_Clock(Base_ClockText.getText());
        cpu.setMax_Turbo_Clock(Max_Turbo_Clock_Text.getText());
        cpu.setCores(Integer.parseInt(CoresText.getText()));
        cpu.setThread(Integer.parseInt(TreadText.getText()));
        cpu.setTDP(TDPText.getText());
        cpu.setHarga(Integer.parseInt(PriceText.getText()));
        Nama_CPUText.requestFocus();
        Main_Menu2Controller.Database_CPU.SetCPUModels(cpu);;
        if (TextEdit) {
            if (Main_Menu2Controller.Database_CPU.Update_Data()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Create Data CPU Successed", ButtonType.OK);
                a.showAndWait();
                ID_CPUText.setEditable(true);
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
                Nama_CPUText.requestFocus();
            }
        }
    }
}
