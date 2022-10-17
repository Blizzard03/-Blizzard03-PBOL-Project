/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXML_AND_CONTROLLERS.Input.Master;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Input_PSUController implements Initializable {

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
    private Image img;
    
    @FXML
    private FileChooser fc;

    @FXML
    private Button Browse;

    @FXML
    private File fe;

    private FileInputStream fis;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Save_Data_Button_Click(ActionEvent event) {
    }

    @FXML
    private void CancelButtonClick(ActionEvent event) {
    }

    @FXML
    private void BrowseButtonClick(ActionEvent event) {
        //fe = fc.showOpenDialog(primaryStage);
      //if (fe != null) {
        //    ImageText.setText(fe.getAbsolutePath());
            //img = new Image(fe.toURI().toString());
           // Imagesview = new ImageView(img);
        //}
    }

    @FXML
    private void Save_Image_Button_Click(ActionEvent event) {
    }

}
