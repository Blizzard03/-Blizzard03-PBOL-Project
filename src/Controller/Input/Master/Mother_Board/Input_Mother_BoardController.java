/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Input.Master.Mother_Board;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.Mother_Board_Models.Mother_Board_Models;
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
public class Input_Mother_BoardController implements Initializable {

    public boolean Changed_Data;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField ID_MoboText;
    @FXML
    private TextField VendorText;
    @FXML
    private TextField Nama_MoboText;
    @FXML
    private TextField Typetext;
    @FXML
    private TextField PriceText;
    @FXML
    private TextField SocketText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(Mother_Board_Models mobo) {
        if (!mobo.getID_MOTHER_BOARD().isEmpty()) {
            Changed_Data = true;
            ID_MoboText.setText(mobo.getID_MOTHER_BOARD());
            VendorText.setText(mobo.getVendor());
            Nama_MoboText.setText(mobo.getNama_Mother_Board());
            Typetext.setText(mobo.getType());
            SocketText.setText(mobo.getSocket());
            PriceText.setText(String.valueOf(mobo.getHarga()));
            ID_MoboText.setEditable(false);
            ID_MoboText.requestFocus();
        }
    }

    @FXML
    private void SaveButtonClick(ActionEvent event) {
        Mother_Board_Models mobo = new Mother_Board_Models();
        mobo.setID_MOTHER_BOARD(ID_MoboText.getText());
        mobo.setVendor(VendorText.getText());
        mobo.setNama_Mother_Board(Nama_MoboText.getText());
        mobo.setType(Typetext.getText());
        mobo.setSocket(SocketText.getText());
        mobo.setHarga(Integer.parseInt(PriceText.getText()));

        Main_Menu2Controller.Database_Mobo.setMother_Board_Models(mobo);
        if (Changed_Data) {
            if (Main_Menu2Controller.Database_SSD.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Update Data Mother Board Successed", ButtonType.OK);
                a.showAndWait();
                ID_MoboText.setEditable(true);
                ResetButtonClick(event);
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
                    SaveButton.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Update Data SSD Failed", ButtonType.OK);
                a.showAndWait();
                Nama_MoboText.requestFocus();
            }
        }
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
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
            CancelButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ResetButtonClick(ActionEvent event) {
        ID_MoboText.setText("");
        VendorText.setText("");
        Nama_MoboText.setText("");
        Typetext.setText("");
        SocketText.setText("");
        PriceText.setText("");

    }
}

