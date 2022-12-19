/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.RAM;

import DataBaseConnector.Database_Connection;
import Models.Master.RAM.RAMModels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_RAM {

    private RAMModels ram = new RAMModels();

    public RAMModels getRAMModels() {
        return (ram);
    }

    public void setRAMModels(RAMModels ramm) {
        ram = ramm;
    }

    public ObservableList<RAMModels> Load() {
        try {
            ObservableList<RAMModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from ram");
            int i = 1;
            while (rs.next()) {
                RAMModels ram = new RAMModels();
                ram.setID_RAM(rs.getString("ID_RAM"));
                ram.setNama_RAM(rs.getString("Nama_RAM"));
                ram.setDDR(rs.getInt("DDR"));
                ram.setFrequency(rs.getString("Frequency"));
                ram.setCapacity(rs.getString("Capacity"));
                ram.setCL(rs.getString("CL"));
                ram.setHarga(rs.getInt("Harga"));
                tableData.add(ram);
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from ram where ID_RAM = '" + nomor + "'");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into ram (ID_RAM,Nama_RAM,DDR,Frequency,Capacity,CL,Harga ) values (?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getRAMModels().getID_RAM());
            con.preparedStatement.setString(2, getRAMModels().getNama_RAM());
            con.preparedStatement.setInt(3, getRAMModels().getDDR());
            con.preparedStatement.setString(4, getRAMModels().getFrequency());
            con.preparedStatement.setString(5, getRAMModels().getCapacity());
            con.preparedStatement.setString(6, getRAMModels().getCL());
            con.preparedStatement.setInt(7, getRAMModels().getHarga());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update ram set Nama_RAM=?,DDR=?,Frequency=?,Capacity=?,CL=?,Harga=? where ID_RAM=?");
            con.preparedStatement.setString(1, getRAMModels().getNama_RAM());
            con.preparedStatement.setInt(2, getRAMModels().getDDR());
            con.preparedStatement.setString(3, getRAMModels().getFrequency());
            con.preparedStatement.setString(4, getRAMModels().getCapacity());
            con.preparedStatement.setString(5, getRAMModels().getCL());
            con.preparedStatement.setInt(6, getRAMModels().getHarga());
            con.preparedStatement.setString(7, getRAMModels().getID_RAM());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from ram where ID_RAM  = ? ");
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

    public ObservableList<RAMModels> CariRAM(String kode, String nama) {
        try {
            ObservableList<RAMModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from ram WHERE ID_RAM LIKE '" + kode + "%' OR Nama_RAM LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                RAMModels ram = new RAMModels();
                ram.setID_RAM(rs.getString("ID_RAM"));
                ram.setNama_RAM(rs.getString("Nama_RAM"));
                ram.setDDR(rs.getInt("DDR"));
                ram.setFrequency(rs.getString("Frequency"));
                ram.setCapacity(rs.getString("Capacity"));
                ram.setCL(rs.getString("CL"));
                ram.setHarga(rs.getInt("Harga"));
                tableData.add(ram);
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
