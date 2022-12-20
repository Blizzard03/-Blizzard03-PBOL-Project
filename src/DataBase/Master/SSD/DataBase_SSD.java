/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.SSD;

import DataBaseConnector.Database_Connection;
import Models.Master.SSD.SSDModels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_SSD {

    private SSDModels ssd = new SSDModels();

    public SSDModels getSSDModels() {
        return (ssd);
    }

    public void setSSDModels(SSDModels ssdm) {
        ssd = ssdm;
    }

    public ObservableList<SSDModels> Load() {
        try {
            ObservableList<SSDModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from ssd");
            int i = 1;
            while (rs.next()) {
                SSDModels ssd = new SSDModels();
                ssd.setID_SSD(rs.getString("ID_SSD"));
                ssd.setVendor(rs.getString("Vendor"));
                ssd.setNama_SSD(rs.getString("Nama_SSD"));
                ssd.setType(rs.getString("Type"));
                ssd.setCapacity(rs.getString("Capacity"));
                ssd.setTBW(rs.getInt("TBW"));
                ssd.setRead(rs.getString("Read"));
                ssd.setWrite(rs.getString("Write"));
                ssd.setHarga(rs.getInt("Harga"));
                tableData.add(ssd);
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from ssd where ID_SSD = '" + nomor + "'");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into cooler (ID_SSD,Vendor,Nama_SSD,Type,Capacity,TBW,Read,Write,Harga) values (?,?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getSSDModels().getID_SSD());
            con.preparedStatement.setString(2, getSSDModels().getVendor());
            con.preparedStatement.setString(3, getSSDModels().getNama_SSD());
            con.preparedStatement.setString(4, getSSDModels().getType());
            con.preparedStatement.setString(5, getSSDModels().getCapacity());
            con.preparedStatement.setInt(6, getSSDModels().getTBW());
            con.preparedStatement.setString(7, getSSDModels().getRead());
            con.preparedStatement.setString(8, getSSDModels().getWrite());
            con.preparedStatement.setInt(9, getSSDModels().getHarga());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update ssd set Vendor = ?, Nama_SSD = ?, Type = ?, Capacity = ?,  Read = ?, Write = ?, TBW = ?,Harga = ? where ID_SSD = ?");
            con.preparedStatement.setString(1, getSSDModels().getVendor());
            con.preparedStatement.setString(2, getSSDModels().getNama_SSD());
            con.preparedStatement.setString(3, getSSDModels().getType());
            con.preparedStatement.setString(4, getSSDModels().getCapacity());
            con.preparedStatement.setString(5, getSSDModels().getRead());
            con.preparedStatement.setString(6, getSSDModels().getWrite());
            con.preparedStatement.setInt(7, getSSDModels().getTBW());
            con.preparedStatement.setInt(8, getSSDModels().getHarga());
            con.preparedStatement.setString(9, getSSDModels().getID_SSD());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from ssd where ID_SSD  = ? ");
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
    
    
    public ObservableList<SSDModels> CariSSD(String kode, String nama) {
        try {
            ObservableList<SSDModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from ssd WHERE ID_SSD LIKE '" + kode + "%' OR Nama_SSD LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                SSDModels ssd = new SSDModels();
                ssd.setID_SSD(rs.getString("ID_SSD"));
                ssd.setVendor(rs.getString("Vendor"));
                ssd.setNama_SSD(rs.getString("Nama_SSD"));
                ssd.setType(rs.getString("Type"));
                ssd.setCapacity(rs.getString("Capacity"));
                ssd.setTBW(rs.getInt("TBW"));
                ssd.setRead(rs.getString("Read"));
                ssd.setWrite(rs.getString("Write"));
                ssd.setHarga(rs.getInt("Harga"));
                tableData.add(ssd);
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
