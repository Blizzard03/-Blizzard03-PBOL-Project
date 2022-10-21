/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Slave.Detail_CPU;

//Import  Database Connector and Detail_CPU_Models Class
import DataBaseConnector.Database_Connection;
import Models.Slave.Detail_CPU.Detail_CPU_Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_Detail_CPU {

    public int Total;
    private Detail_CPU_Models dcpum = new Detail_CPU_Models();

    public Detail_CPU_Models getDetail_CPU_Models() {
        return (dcpum);
    }

    public void setDetail_CPU_Models(Detail_CPU_Models lus) {
        dcpum = lus;
    }

    public ObservableList<Detail_CPU_Models> Load_Data(String kode) {
        try {
            ObservableList<Detail_CPU_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select du.Nomor_Transaksi,cpu.ID_CPU,cpu.Nama_CPU,du.Quantity,cpu.Harga "
                    + "from detail_cpu du join cpu cpu on(du.ID_CPU=cpu.ID_CPU) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_CPU_Models d = new Detail_CPU_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_CPU(rs.getString("ID_CPU"));
                d.setNama_CPU(rs.getString("Nama_CPU"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from detail_cpu where Nomor_Transaksi = '" + nomor + "'");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into  detail_cpu (Nomor_Transaksi,ID_CPU,Quantity) values (?,?,?)");
            con.preparedStatement.setString(1, getDetail_CPU_Models().getNomor_Transaksi());
            con.preparedStatement.setString(2, getDetail_CPU_Models().getID_CPU());
            con.preparedStatement.setInt(3, getDetail_CPU_Models().getQuantity());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_cpu where Nomor_Transaksi  = ? and ID_CPU = ?");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_cpu where Nomor_Transaksi = ?");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update detail_cpu set ID_CPU = ?, Quantity = ?  where  Nomor_Transaksi= ? ");
            con.preparedStatement.setString(1, getDetail_CPU_Models().getID_CPU());
            con.preparedStatement.setInt(2, getDetail_CPU_Models().getQuantity());
            con.preparedStatement.setString(3, getDetail_CPU_Models().getNomor_Transaksi());
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

    public ObservableList<Detail_CPU_Models> Search_Detil_CPU(String kode) {
        try {
            Total = 0;
            ObservableList<Detail_CPU_Models> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select du.Nomor_Transaksi,cpu.ID_CPU,cpu.Nama_CPU,du.Quantity,cpu.Harga "
                    + "from detail_cpu du join cpu cpu on(du.ID_CPU=cpu.ID_CPU) WHERE Nomor_Transaksi LIKE '" + kode + "'");
            int i = 1;
            while (rs.next()) {
                Detail_CPU_Models d = new Detail_CPU_Models();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_CPU(rs.getString("ID_CPU"));
                d.setNama_CPU(rs.getString("Nama_CPU"));
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
