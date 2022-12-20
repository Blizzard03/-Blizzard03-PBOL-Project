/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.MotherBoard;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.Mother_Board_Models.Mother_Board_Models;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Muhamad Ariq Rasyid
 */
public class FXMLSelectionMotherBoardController implements Initializable {

    @FXML
    private TextField Mother_BoardText;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> Mother_Board_selection;
    @FXML
    private TableView<Mother_Board_Models> TableViewMotherBoards;

    private int Val=0;
    private String ID_Mobo ="";
    private int Price;
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Mother_Board_selection.setItems(FXCollections.observableArrayList("ID_MOTHER_BOARD","Nama_Cooler"));
        Mother_Board_selection.getSelectionModel().select(0);
        DataShows("ID_MOTHER_BOARD", "");
    }    
    
    //Table Data MotherBoard
    public void DataShows(String aa, String bb) {
           ObservableList<Mother_Board_Models> data = Main_Menu2Controller.Database_Mobo.Mother_Board_Search(aa, bb);
           if(data.isEmpty()){
               data = Main_Menu2Controller.Database_Mobo.Load();
               Mother_BoardText.setText("");
           }
            if (data != null) {
                TableViewMotherBoards.getColumns().clear();
                TableViewMotherBoards.getItems().clear();
                TableColumn col = new TableColumn("ID_MOTHER_BOARD");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("ID_MOTHER_BOARD"));
                TableViewMotherBoards.getColumns().addAll(col);
                col = new TableColumn("Vendor");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Vendor"));
                TableViewMotherBoards.getColumns().addAll(col);
                col = new TableColumn("Nama_Mother_Board");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Nama_Mother_Board"));
                TableViewMotherBoards.getColumns().addAll(col);
                col = new TableColumn("Type");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Type"));
                TableViewMotherBoards.getColumns().addAll(col);
                col = new TableColumn("Socket");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Socket"));
                TableViewMotherBoards.getColumns().addAll(col);
                col = new TableColumn("Harga");
                col.setCellValueFactory(new PropertyValueFactory<Mother_Board_Models, String>("Harga"));
                TableViewMotherBoards.getColumns().addAll(col);
                TableViewMotherBoards.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewMotherBoards.getScene().getWindow().hide();;
        }
    }
    
    
    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(Mother_Board_selection.getSelectionModel().getSelectedItem(), Mother_BoardText.getText());
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val=0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val =1;
        int slc = TableViewMotherBoards.getSelectionModel().getSelectedCells().get(0).getRow();
        ID_Mobo = TableViewMotherBoards.getSelectionModel().getSelectedItem().getID_MOTHER_BOARD().toString();
       Price = TableViewMotherBoards.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }
    
    //Get Items
    public int GetResult(){
        return(Val);
    }
    
    //Get ID MotherBoard
    public String getIDMotherBaord(){
        return(ID_Mobo);
    }
    //Get Price
    public int Price(){
        return (Price);
    }
    

    
}
