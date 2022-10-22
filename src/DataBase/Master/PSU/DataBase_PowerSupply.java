/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.PSU;

import DataBaseConnector.Database_Connection;
import Models.Master.PSU.PSU_Models;
//import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_PowerSupply {

    private PSU_Models psu = new PSU_Models();

    public PSU_Models getPSU_Models() {
        return (psu);
    }

    public void setPSU_Models(PSU_Models psum) {
        psu = psum;
    }

    public ObservableList<PSU_Models> Load() {
        try {
            ObservableList<PSU_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from power_supply");
            int i = 1;
            while (rs.next()) {
                PSU_Models psu = new PSU_Models();
                psu.setID_PSU(rs.getString("ID_PSU"));
                psu.setVendor(rs.getString("Vendor"));
                psu.setNama_PSU(rs.getString("Nama_PSU"));
                psu.setWatt(rs.getInt("Watt"));
                psu.setTier(rs.getString("Tier"));
                psu.setHarga(rs.getInt("Harga"));
                tableData.add(psu);
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from power_supply where ID_PSU = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.Discconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean Succes = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into power_supply (ID_PSU,Vendor,Nama_PSU,Watt,Tier,Harga ) values (?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getPSU_Models().getID_PSU());
            con.preparedStatement.setString(2, getPSU_Models().getVendor());
            con.preparedStatement.setString(3, getPSU_Models().getNama_PSU());
            con.preparedStatement.setInt(5, getPSU_Models().getWatt());
            con.preparedStatement.setString(4, getPSU_Models().getTier());
            con.preparedStatement.setInt(6, getPSU_Models().getHarga());
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

    public boolean Update_Data() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update power_supply set ID_PSU=?,Vendor=?,=?,Watt=?,Tier=?,Harga=? ");
            con.preparedStatement.setString(1, getPSU_Models().getID_PSU());
            con.preparedStatement.setString(2, getPSU_Models().getVendor());
            con.preparedStatement.setString(3, getPSU_Models().getNama_PSU());
            con.preparedStatement.setInt(5, getPSU_Models().getWatt());
            con.preparedStatement.setString(4, getPSU_Models().getTier());
            con.preparedStatement.setInt(6, getPSU_Models().getHarga());
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
    
    public boolean Delete_Data(String ID) {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();;
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from power_supply where ID_PSU  = ? ");
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

    public ObservableList<PSU_Models> Cari_Power_Supply(String kode, String nama) {
        try {
            ObservableList<PSU_Models> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from power_supply WHERE ID_PSU LIKE '" + kode + "%' OR Nama_PSU LIKE '" + nama + "%'");
              int i = 1;
            while (rs.next()) {
                PSU_Models psu = new PSU_Models();
                psu.setID_PSU(rs.getString("ID_PSU"));
                psu.setVendor(rs.getString("Vendor"));
                psu.setNama_PSU(rs.getString("Nama_PSU"));
                psu.setWatt(rs.getInt("Watt"));
                psu.setTier(rs.getString("Tier"));
                psu.setHarga(rs.getInt("Harga"));
                tableData.add(psu);
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
