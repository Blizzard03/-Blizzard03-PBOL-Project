/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.SelectData.GPU;

import Controller.MainMenu.Main_Menu2Controller;
import Models.Master.GPU.GPUModels;
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
public class FXMLSelectionGPUController implements Initializable {

    private int Val = 0;
    private String IDGPU = "";
    private int Price;

    @FXML
    private TableView<GPUModels> TableViewGPU;
    @FXML
    private TextField GPUText;
    @FXML
    private Button SearchButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SelectButton;
    @FXML
    private ComboBox<String> GPU_selection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GPU_selection.setItems(FXCollections.observableArrayList("ID_COOLER", "Nama_Cooler"));
        GPU_selection.getSelectionModel().select(0);
        DataShows("ID_COOLER", "");
    }

    @FXML
    private void SearchClick(ActionEvent event) {
        DataShows(GPU_selection.getSelectionModel().getSelectedItem(), GPUText.getText());
    }

    @FXML
    private void CancelClick(ActionEvent event) {
        Val = 0;
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void SelectClick(ActionEvent event) {
        Val = 1;
        int slc = TableViewGPU.getSelectionModel().getSelectedCells().get(0).getRow();
        IDGPU = TableViewGPU.getSelectionModel().getSelectedItem().getID_GPU().toString();
        Price = TableViewGPU.getSelectionModel().getSelectedItem().getHarga();
        SelectButton.getScene().getWindow().hide();
    }

    //Get Item
  public int getResult(){
      return (Val);
  }  
    //Get ID GPU
    public String ID_GPU(){
        return (IDGPU);
    }
    //Get Price
    public int GetPrice(){
        return (Price);
    }
  
    
    
    
    
    public void DataShows(String aa, String bb) {
        ObservableList<GPUModels> data = Main_Menu2Controller.Database_GPU.CariGPU(aa, bb);
        if (data.isEmpty()) {
            data = Main_Menu2Controller.Database_GPU.Load();
            GPUText.setText("");
        }
        if (data != null) {
            TableViewGPU.getColumns().clear();
            TableViewGPU.getItems().clear();
            TableColumn col = new TableColumn("ID_GPU");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("ID_GPU"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Vendor");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Vendor"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("VRAM");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("VRAM"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Memory_Type");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Memory_Type"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Frequency");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Frequency"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("GDP");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("GDP"));
            TableViewGPU.getColumns().addAll(col);
            col = new TableColumn("Harga");
            col.setCellValueFactory(new PropertyValueFactory<GPUModels, String>("Harga"));
            TableViewGPU.getColumns().addAll(col);
            TableViewGPU.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewGPU.getScene().getWindow().hide();;
        }

    }
}
