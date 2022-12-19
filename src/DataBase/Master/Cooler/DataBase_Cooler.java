/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.Cooler;

import DataBaseConnector.Database_Connection;
import Models.Master.Cooler.CoolerModels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_Cooler {

    private CoolerModels cooler = new CoolerModels();

    public CoolerModels getCoolerModels() {
        return (cooler);
    }

    public void setCoolerModels(CoolerModels coolerm) {
        cooler = coolerm;
    }

    public ObservableList<CoolerModels> Load() {
        try {
            ObservableList<CoolerModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from cooler");
            int i = 1;
            while (rs.next()) {
                CoolerModels fan = new CoolerModels();
                fan.setID_COOLER(rs.getString("ID_COOLER"));
                fan.setNama_Cooler(rs.getString("Nama_Cooler"));
                fan.setType(rs.getString("Type"));
                fan.setSocket(rs.getString("Socket"));
                fan.setHarga(rs.getInt("Harga"));
                tableData.add(fan);
                i++;
            }
            con.Discconnect();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validate(String nomor) {
        int val = 0;
        try {
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from cooler where ID_COOLER = '" + nomor + "'");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into cooler (ID_COOLER,Nama_Cooler,Type,Socket,Harga ) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getCoolerModels().getID_COOLER());
            con.preparedStatement.setString(2, getCoolerModels().getNama_Cooler());
            con.preparedStatement.setString(3, getCoolerModels().getType());
            con.preparedStatement.setString(4, getCoolerModels().getType());
            con.preparedStatement.setInt(5, getCoolerModels().getHarga());
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

    public boolean update() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update cooler set Nama_Cooler=?,Type=?,Socket=?,Harga=? WHERE ID_COOLER=?");
            con.preparedStatement.setString(1, getCoolerModels().getNama_Cooler());
            con.preparedStatement.setString(2, getCoolerModels().getType());
            con.preparedStatement.setString(3, getCoolerModels().getType());
            con.preparedStatement.setInt(4, getCoolerModels().getHarga());
            con.preparedStatement.setString(5, getCoolerModels().getID_COOLER());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from cooler where ID_COOLER  = ? ");
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
    
    public ObservableList<CoolerModels> SearchCooler(String kode, String nama) {
        try {
            ObservableList<CoolerModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from cooler WHERE ID_COOLER LIKE '" + kode + "%' OR Nama_Cooler LIKE '" + nama + "%'");
           int i = 1;
            while (rs.next()) {
                CoolerModels fan = new CoolerModels();
                fan.setID_COOLER(rs.getString("ID_COOLER"));
                fan.setNama_Cooler(rs.getString("Nama_Cooler"));
                fan.setType(rs.getString("Type"));
                fan.setSocket(rs.getString("Socket"));
                fan.setHarga(rs.getInt("Harga"));
                tableData.add(fan);
                i++;}
            con.Discconnect();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
