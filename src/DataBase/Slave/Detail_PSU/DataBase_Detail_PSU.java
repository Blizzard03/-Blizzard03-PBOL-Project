/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Slave.Detail_PSU;

//Import Database Conttector aND Detail_PSU_Models
import DataBaseConnector.Database_Connection;
import Models.Slave.Detail_PSU.Detail_PSU_Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_Detail_PSU {

    public int Total;
    private Detail_PSU_Models dpsum = new Detail_PSU_Models();

    public Detail_PSU_Models getDetail_PSU_Models() {
        return (dpsum);
    }

    public void setDetail_PSU_Models(Detail_PSU_Models dpm) {
        dpsum = dpm;
    }

    public ObservableList<Detail_PSU_Models> Load_Data(String kode) {
        try {
            ObservableList<Detail_PSU_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select dps.Nomor_Transaksi,psu.ID_PSU,psu.Nama_PSU,dps.Quantity, psu.Harga "
                    + "from detail_power_supply dps join power_supply psu  on(dps.ID_PSU=psu.ID_PSU) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_PSU_Models d = new Detail_PSU_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_PSU(rs.getString("ID_PSU"));
                d.setNama_PSU(rs.getString("Nama_PSU"));
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into  detail_power_supply (Nomor_Transaksi, ID_PSU,Quantity) values (?,?,?)");
            con.preparedStatement.setString(1, getDetail_PSU_Models().getNomor_Transaksi());
            con.preparedStatement.setString(2, getDetail_PSU_Models().getID_PSU());
            con.preparedStatement.setInt(3, getDetail_PSU_Models().getQuantity());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_power_supply where Nomor_Transaksi = ?");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update detail_power_supply set ID_PSU = ?, Quantity = ?  where  Nomor_Transaksi= ? ");
            con.preparedStatement.setString(1, getDetail_PSU_Models().getID_PSU());
            con.preparedStatement.setInt(2, getDetail_PSU_Models().getQuantity());
            con.preparedStatement.setString(3, getDetail_PSU_Models().getNomor_Transaksi());
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

    public ObservableList<Detail_PSU_Models> Search_Detil_Cooler(String kode) {
        try {
            Total = 0;
            ObservableList<Detail_PSU_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select dps.Nomor_Transaksi,psu.ID_PSU,psu.Nama_PSU,dps.Quantity, psu.Harga "
                    + "from detail_power_supply dps join power_supply psu  on(dps.ID_PSU=psu.ID_PSU) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_PSU_Models d = new Detail_PSU_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_PSU(rs.getString("ID_PSU"));
                d.setNama_PSU(rs.getString("Nama_PSU"));
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
