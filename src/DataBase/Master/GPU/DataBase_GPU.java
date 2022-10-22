/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.GPU;

import DataBaseConnector.Database_Connection;
import Models.Master.GPU.GPUModels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_GPU {

    private GPUModels gpu = new GPUModels();

    public GPUModels getGPUModels() {
        return (gpu);
    }

    public void setGPUModels(GPUModels gpum) {
        gpu = gpum;
    }

    public ObservableList<GPUModels> Load() {
        try {
            ObservableList<GPUModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from gpu");
            int i = 1;
            while (rs.next()) {
                GPUModels gpum = new GPUModels();
                gpum.setID_GPU(rs.getString("ID_GPU"));
                gpum.setVendor(rs.getString("Vendor"));
                gpum.setNama_GPU(rs.getString("Nama_GPU"));
                gpum.setVRAM(rs.getString("VRAM"));
                gpum.setMemory_Type(rs.getNString("Memory_Type"));
                gpum.setFrequency(rs.getString("Frequency"));
                gpum.setGDP(rs.getNString("GDP"));
                gpum.setHarga(rs.getInt("Harga"));
                tableData.add(gpum);
                i++;
            }
            con.Discconnect();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validate(int nomor) {
        int val = 0;
        try {
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from gpu where ID_GPU = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.Discconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Insert_Data() {
        boolean Succes = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into gpu (ID_GPU, Vendor, Nama_GPU, VRAM, Memory_Type,Frequency, GDP,Harga ) values (?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getGPUModels().getID_GPU());
            con.preparedStatement.setString(2, getGPUModels().getVendor());
            con.preparedStatement.setString(3, getGPUModels().getNama_GPU());
            con.preparedStatement.setString(4, getGPUModels().getVRAM());
            con.preparedStatement.setString(5, getGPUModels().getMemory_Type());
            con.preparedStatement.setString(6, getGPUModels().getFrequency());
            con.preparedStatement.setString(7, getGPUModels().getGDP());
            con.preparedStatement.setInt(8, getGPUModels().getHarga());
            con.preparedStatement.executeUpdate();

            Succes = true;
        } catch (Exception e) {
            e.printStackTrace();
            Succes = false;
        } finally {
            con.Discconnect();
            return Succes;
        }
    }
public boolean Delete_Data(String ID) {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();;
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from gpu where ID_GPU  = ? ");
            con.preparedStatement.setString(1, ID);
            con.preparedStatement.executeUpdate();
            Success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.Discconnect();
            return Success;
        }
    }
    public boolean Update_Data() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update gpu set ID_GPU =?, Vendor =?, Nama_GPU=?, VRAM=?, Memory_Type=?,Frequency=?, GDP=?,Harga=? ");
            con.preparedStatement.setString(1, getGPUModels().getID_GPU());
            con.preparedStatement.setString(2, getGPUModels().getVendor());
            con.preparedStatement.setString(3, getGPUModels().getNama_GPU());
            con.preparedStatement.setString(4, getGPUModels().getVRAM());
            con.preparedStatement.setString(5, getGPUModels().getMemory_Type());
            con.preparedStatement.setString(6, getGPUModels().getFrequency());
            con.preparedStatement.setString(7, getGPUModels().getGDP());
            con.preparedStatement.setInt(8, getGPUModels().getHarga());
            con.preparedStatement.executeUpdate();
            Success = true;
        } catch (Exception e) {
            e.printStackTrace();
            Success = false;
        } finally {
            con.Discconnect();
            return Success;
        }
    }

    public ObservableList<GPUModels> CariUser(String kode, String nama) {
        try {
            ObservableList<GPUModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from gpu WHERE ID_GPU LIKE '" + kode + "%' OR Nama_GPU LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                GPUModels gpum = new GPUModels();
                gpum.setID_GPU(rs.getString("ID_GPU"));
                gpum.setVendor(rs.getString("Vendor"));
                gpum.setNama_GPU(rs.getString("Nama_GPU"));
                gpum.setVRAM(rs.getString("VRAM"));
                gpum.setMemory_Type(rs.getNString("Memory_Type"));
                gpum.setFrequency(rs.getString("Frequency"));
                gpum.setGDP(rs.getNString("GDP"));
                gpum.setHarga(rs.getInt("Harga"));
                tableData.add(gpum);
                i++;
            }
            con.Discconnect();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
