/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Slave.Detail_RAM;

//Import DatabaseConnector & Detail RAM_Models
import DataBaseConnector.Database_Connection;
import Models.Slave.Detail_RAM.Detail_RAM_Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class Database_Detail_RAM {
        public int Total;
    private Detail_RAM_Models dramm = new Detail_RAM_Models();

    public Detail_RAM_Models getDetail_RAM_Models() {
        return (dramm);
    }

    public void Detail_RAM_Models(Detail_RAM_Models drm) {
        dramm = drm;
    }

    public ObservableList<Detail_RAM_Models> Load_Data(String kode) {
        try {
            ObservableList<Detail_RAM_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select drm.Nomor_Transaksi,ram.ID_RAM,ram.Nama_RAM,drm.Quantity, ram.Harga "
                    + "from detai_ram drm join ram ram  on(drm.ID_RAM=ram.ID_RAM) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_RAM_Models d = new Detail_RAM_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_RAM(rs.getString("ID_RAM"));
                d.setNama_RAM(rs.getString("Nama_RAM"));
                d.setQuantity(rs.getInt("Quantity"));
                d.setHarga(rs.getInt("Harga"));

                int Total = 0;
                int Quantity = rs.getInt("Quantity");
                int Harga = rs.getInt("Harga");
                Total = Quantity * Harga;
                d.setTotal(Total);
                tableData.add(d);
                i++;
            }
            con.Discconnect();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int Validate(String nomor) {
        int num = 0;
        try {
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from detail_power_supply where Nomor_Transaksi = '" + nomor + "'");
            while (rs.next()) {
                num = rs.getInt("jml");
            }
            con.Discconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public boolean Insert_Data() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into  detail_ram (Nomor_Transaksi, ID_RAM,Quantity) values (?,?,?)");
            con.preparedStatement.setString(1, getDetail_RAM_Models().getNomor_Transaksi());
            con.preparedStatement.setString(2, getDetail_RAM_Models().getID_RAM());
            con.preparedStatement.setInt(3, getDetail_RAM_Models().getQuantity());
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

    public boolean Delete_Data(String nomor, String id) {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();;
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_power_supply where Nomor_Transaksi  = ? and ID_PSU = ?");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.setString(2, id);
            con.preparedStatement.executeUpdate();
            Success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.Discconnect();
            return Success;
        }
    }

    public boolean Delete_All_Data(String nomor) {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();;
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_ram where Nomor_Transaksi = ?");
            con.preparedStatement.setString(1, nomor);
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update detail_ram set ID_RAM = ?, Quantity = ?  where  Nomor_Transaksi= ? ");
            con.preparedStatement.setString(1, getDetail_RAM_Models().getID_RAM());
            con.preparedStatement.setInt(2, getDetail_RAM_Models().getQuantity());
            con.preparedStatement.setString(3, getDetail_RAM_Models().getNomor_Transaksi());
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

    public ObservableList<Detail_RAM_Models> Search_Detil_Cooler(String kode) {
        try {
            Total = 0;
            ObservableList<Detail_RAM_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select drm.Nomor_Transaksi,ram.ID_RAM,ram.Nama_RAM,drm.Quantity, ram.Harga "
                    + "from detai_ram drm join ram ram  on(drm.ID_RAM=ram.ID_RAM) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_RAM_Models d = new Detail_RAM_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_RAM(rs.getString("ID_RAM"));
                d.setNama_RAM(rs.getString("Nama_RAM"));
                d.setQuantity(rs.getInt("Quantity"));
                d.setHarga(rs.getInt("Harga"));

                int Total = 0;
                int Quantity = rs.getInt("Quantity");
                int Harga = rs.getInt("Harga");
                Total = Quantity * Harga;
                d.setTotal(Total);
                tableData.add(d);
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
