/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Slave.Detail_SSD;

//Import DatabaseConnector & Detail SSD_Models
import DataBaseConnector.Database_Connection;
import Models.Slave.Detail_SSD.Detail_SSD_Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class Database_Detail_SSD {

    public int Total;
    private Detail_SSD_Models dssd = new Detail_SSD_Models();

    public Detail_SSD_Models getDetail_SSD_Models() {
        return (dssd);
    }

    public void Detail_SSD_Models(Detail_SSD_Models dsm) {
        dssd = dsm;
    }

    public ObservableList<Detail_SSD_Models> Load_Data(String kode) {
        try {
            ObservableList<Detail_SSD_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select dsd.Nomor_Transaksi,ssd.ID_SSD,ssd.Nama_SSD,dsd.Quantity, ssd.Harga "
                    + "from detai_ssd dsm join ssd ssd  on(dsd.ID_SSD=ram.ID_SSD) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_SSD_Models d = new Detail_SSD_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_SSD(rs.getString("ID_SSD"));
                d.setNama_SSD(rs.getString("Nama_RAM"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from detail_ssd where Nomor_Transaksi = '" + nomor + "'");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into  detail_ssd (Nomor_Transaksi, ID_SSD,Quantity) values (?,?,?)");
            con.preparedStatement.setString(1, getDetail_SSD_Models().getNomor_Transaksi());
            con.preparedStatement.setString(2, getDetail_SSD_Models().getID_SSD());
            con.preparedStatement.setInt(3, getDetail_SSD_Models().getQuantity());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_ssd where Nomor_Transaksi  = ? and ID_SSD = ?");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_ssd where Nomor_Transaksi = ?");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update detail_ssd set ID_SSD = ?, Quantity = ?  where  Nomor_Transaksi= ? ");
            con.preparedStatement.setString(1, getDetail_SSD_Models().getID_SSD());
            con.preparedStatement.setInt(2, getDetail_SSD_Models().getQuantity());
            con.preparedStatement.setString(3, getDetail_SSD_Models().getNomor_Transaksi());
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

    public ObservableList<Detail_SSD_Models> Search_Detil_Cooler(String kode) {
        try {
            Total = 0;
            ObservableList<Detail_SSD_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select dsd.Nomor_Transaksi,ssd.ID_SSD,ssd.Nama_SSD,dsd.Quantity, ssd.Harga "
                    + "from detai_ssd dsm join ssd ssd  on(dsd.ID_SSD=ram.ID_SSD) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_SSD_Models d = new Detail_SSD_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_SSD(rs.getString("ID_SSD"));
                d.setNama_SSD(rs.getString("Nama_RAM"));
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
