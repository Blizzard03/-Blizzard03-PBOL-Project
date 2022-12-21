/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Tableviews.Master.Transaksi;

/*
 * Import Models Class
 */
import Models.Master.Transaksi.TransaksiModels;
import Models.Slave.Detail_CPU.Detail_CPU_Models;
import Models.Slave.Detail_GPU.Detail_GPU_Models;
import Models.Slave.Detail_Cooler.Detail_Cooler_Models;
import Models.Slave.Detail_Mother_Board.Detail_Mother_Board_Models;
import Models.Slave.Detail_PSU.Detail_PSU_Models;
import Models.Slave.Detail_RAM.Detail_RAM_Models;
import Models.Slave.Detail_SSD.Detail_SSD_Models;
import java.io.IOException;

import Controller.MainMenu.Main_Menu2Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class Table_View_TransaksiController implements Initializable {

    /*
    * Table Views 
     */
    @FXML
    private TableView<TransaksiModels> TableDatTrans;
    @FXML
    private TableView<Detail_GPU_Models> TableDataDetailgpu;
    @FXML
    private TableView<Detail_Mother_Board_Models> TableDataDetailMobo;
    @FXML
    private TableView<Detail_PSU_Models> TableDataDetailPSU;
    @FXML
    private TableView<Detail_SSD_Models> TableDataDetailSSD;
    @FXML
    private TableView<Detail_RAM_Models> TableDataDetailRAM;
    @FXML
    private TableView<Detail_Cooler_Models> TableDataDetailCooler;
    @FXML
    private TableView<Detail_CPU_Models> TableDataDetailCPU;
    @FXML
    private TextField TransaksiText;
    @FXML
    private Button MainMenu;
    @FXML
    private DatePicker DateTrans;
    @FXML
    private TextField Search_Data;
    @FXML
    private TextField Id_UserText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void MainMenuClick(ActionEvent event) {
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
            MainMenu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public void ShowCPUDetail(){
        ObservableList<Detail_CPU_Models> data=Main_Menu2Controller.Database_Detail_CPU.Load_Data(TransaksiText.getText());
        if(data!=null){    
                  
            TableDataDetailCPU.getColumns().clear();
            TableDataDetailCPU.getItems().clear();
            TableColumn col=new TableColumn("Nomor Transaksi");
            col.setCellValueFactory(new PropertyValueFactory<TransaksiModels, String>("Nomor Transaksi"));
            TableDataDetailCPU.getColumns().addAll(col);
            col=new TableColumn("ID_CPU");
            col.setCellValueFactory(new PropertyValueFactory<TransaksiModels, String>("ID_CPU"));
            TableDataDetailCPU.getColumns().addAll(col);
            col=new TableColumn("Quantity");
            col.setCellValueFactory(new PropertyValueFactory<TransaksiModels, String>("Quantitiy"));
            TableDataDetailCPU.getColumns().addAll(col);
            col=new TableColumn("tarif");
            //col.setCellValueFactory(new PropertyValueFactory<JualModel, String>("tarif"));
            col.setCellValueFactory(new FormattedDouble<JualModel>("tarif","#,###,##0"));
            TableDataDetailCPU.getColumns().addAll(col);
            col=new TableColumn("total");
            //col.setCellValueFactory(new PropertyValueFactory<JualModel, String>("total"));
            col.setCellValueFactory(new FormattedDouble<JualModel>("total","#,###,##0"));  
            TableDataDetailCPU.getColumns().addAll(col);
            TableDataDetailCPU.setItems(data);
            
            double totalall=0;
            for(int i=0;i<TableDataDetailCPU.getItems().size();i++){
		JualdetilModel n=TableDataDetailCPU.getItems().get(i);
		totalall+=n.getTotal();
            }
            txttotal.setText(String.valueOf(totalall));
    }else {  Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            TableDataDetailCPU.getScene().getWindow().hide();;
        }     */
}


