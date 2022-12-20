/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.Transaksi;

/*
Models Imports
 */
import Models.Master.Transaksi.TransaksiModels;
import Models.Slave.Detail_CPU.Detail_CPU_Models;
import Models.Slave.Detail_Cooler.Detail_Cooler_Models;
import Models.Slave.Detail_Mother_Board.Detail_Mother_Board_Models;
import Models.Slave.Detail_GPU.Detail_GPU_Models;
import Models.Slave.Detail_PSU.Detail_PSU_Models;
import Models.Slave.Detail_RAM.Detail_RAM_Models;
import Models.Slave.Detail_SSD.Detail_SSD_Models;

//Import DataBase Connector 
import DataBaseConnector.Database_Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class Database_Transaksi {

    private TransaksiModels dt = new TransaksiModels();
    private HashMap<String, Detail_CPU_Models> dt2 = new HashMap<String, Detail_CPU_Models>();
    private HashMap<String, Detail_GPU_Models> dt3 = new HashMap<String, Detail_GPU_Models>();
    private HashMap<String, Detail_PSU_Models> dt4 = new HashMap<String, Detail_PSU_Models>();
    private HashMap<String, Detail_Cooler_Models> dt5 = new HashMap<String, Detail_Cooler_Models>();
    private HashMap<String, Detail_Mother_Board_Models> dt6 = new HashMap<String, Detail_Mother_Board_Models>();
    private HashMap<String, Detail_RAM_Models> dt7 = new HashMap<String, Detail_RAM_Models>();
    private HashMap<String, Detail_SSD_Models> dt8 = new HashMap<String, Detail_SSD_Models>();

    /*
    * Transaksi Model
     */
    public TransaksiModels getTransaksiModel() {
        return (dt);
    }

    public void setJualModel(TransaksiModels s) {
        dt = s;
    }

    /*
     * Detail_CPU Model
     */
    public HashMap<String, Detail_CPU_Models> getDetailCPUModel() {
        return (dt2);
    }

    public void setDetail_CPUModel(Detail_CPU_Models d) {
        dt2.put(d.getID_CPU(), d);
    }

    /*
    Detail GPU Model
     */
    public HashMap<String, Detail_GPU_Models> getDetailGPUModel() {
        return (dt3);
    }

    public void setDetail_GPUModel(Detail_GPU_Models d) {
        dt3.put(d.getID_GPU(), d);
    }

    /*
    /* Detail PSU Model
     */
    public HashMap<String, Detail_PSU_Models> getDetailPSUModel() {
        return (dt4);
    }

    public void setDetail_PSUModel(Detail_PSU_Models d) {
        dt4.put(d.getID_PSU(), d);
    }

    /*
    * Detail Cooler Model
     */
    public HashMap<String, Detail_Cooler_Models> getDetailCooler_Models() {
        return (dt5);
    }

    public void setDetail_PSUModel(Detail_Cooler_Models d) {
        dt5.put(d.getID_COOLER(), d);
    }

    /*
    * Detail Mother Board Model
     */
    public HashMap<String, Detail_Mother_Board_Models> getDetailMotherBoardModel() {
        return (dt6);
    }

    public void setDetail_Mother_Board_Model(Detail_Mother_Board_Models d) {
        dt6.put(d.getID_MOTHER_BOARD(), d);
    }

    /*
    * Detail RAM
     */
    public HashMap<String, Detail_RAM_Models> getDetailRAMModel() {
        return (dt7);
    }

    public void setDetail_RAMModel(Detail_RAM_Models d) {
        dt7.put(d.getID_RAM(), d);
    }

    /*
    * Detail SSD Model
     */
    public HashMap<String, Detail_SSD_Models> getDetailSDDModel() {
        return (dt8);
    }

    public void setDetail_SSDModel(Detail_SSD_Models d) {
        dt8.put(d.getID_SSD(), d);
    }

    public ObservableList<TransaksiModels> Load() {
        try {
            ObservableList<TransaksiModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("SELECT transaksi.Nomor_Transaksi,transaksi.ID_User,USER.Nama_User,transaksi.Tanggal_Transaksi \n"
                    + "FROM transaksi \n"
                    + "INNER JOIN USER ON transaksi.ID_User = USER.ID_User;");
            int i = 1;
            while (rs.next()) {
                TransaksiModels d = new TransaksiModels();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_User(rs.getInt("ID_User"));
                d.setTanggal_Transaksi(rs.getDate("Tanggal_Transaksi"));
                d.setNama_User(rs.getString("Nama_User"));
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

    public int Valide(String Num) {
        int val = 0;
        try {
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from transaksi where Nomor_Transaksi = '" + Num + "'");
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
        boolean berhasil = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into transaksi (Nomor_Transaksi, ID_User, Tanggal_Transaksi) values (?,?,?)");
            con.preparedStatement.setString(1, getTransaksiModel().getNomor_Transaksi());
            con.preparedStatement.setInt(2, getTransaksiModel().getID_User());
            con.preparedStatement.setDate(3, getTransaksiModel().getTanggal_Transaksi());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.Discconnect();
            return berhasil;
        }
    }

    public boolean delete(String nomor) {
        boolean berhasil = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();;
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from transaksi where Nomor_Transaksi  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.Discconnect();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update transaksi set ID_User = ?, Tanggal_Transaksi = ?  where  Nomor_Transaksi= ? ");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.setDate(2, getTransaksiModel().getTanggal_Transaksi());
            con.preparedStatement.setString(3, getTransaksiModel().getNomor_Transaksi());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.Discconnect();
            return berhasil;
        }
    }

    public ObservableList<TransaksiModels> CariJual(String kode) {
        try {
            ObservableList<TransaksiModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("SELECT transaksi.Nomor_Transaksi,transaksi.ID_User,transaksi.Tanggal_Transaksi WHERE Nomor_Transaksi LIKE '" + kode + "%'");
            int i = 1;
            while (rs.next()) {
                TransaksiModels d = new TransaksiModels();
                d.setNomor_Transaksi(rs.getString("Nomor_Transaksi"));
                d.setID_User(Integer.getInteger(rs.getString("ID_User")));
                d.setTanggal_Transaksi(rs.getDate("Tanggal_Transaksi"));
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

    /*
    void print() {
        Koneksi con = new Koneksi();
        String is = "./src/project/penjualan/reportJual1.jasper";
        Map map = new HashMap();
        map.put("p_periode", "Desember");
        con.bukaKoneksi();
        try {
            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(is, map, con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        con.tutupKoneksi();
    }

    public String autonum(String tahun) {
        String tmp = "";
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "select max(nojual) as n from jual where nojual like '" + tahun + "%'");
            while (rs.next()) {
                tmp = tahun
                        + String.format("%03d",
                                Integer.parseInt(rs.getString("n").substring(4)) + 1
                        );
            }
            con.tutupKoneksi();
            return tmp;
        } catch (Exception e) {
            e.printStackTrace();
            return tmp;
        }
    }
     */
    
    //Method 
    public boolean saveall() {
        boolean berhasil = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.Database_UTS_Conection.setAutoCommit(false); // membuat semua perintah menjadi 1 transaksi

            //DELETE TABLE TRANSAKSI
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from transaksi where Nomor_Transaksi=?");
            con.preparedStatement.setString(1, getTransaksiModel().getNomor_Transaksi());
            con.preparedStatement.executeUpdate();

            //INSERT TABLE TRANSAKSI
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into transaksi (Nomor_Transaksi, ID_User, Tanggal_Transaksi values (?,?,?)");
            con.preparedStatement.setString(1, getTransaksiModel().getNomor_Transaksi());
            con.preparedStatement.setInt(2, getTransaksiModel().getID_User());
            con.preparedStatement.setDate(3, getTransaksiModel().getTanggal_Transaksi());
            con.preparedStatement.executeUpdate();

            //DELETE TABLE DETAIL CPU
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_cpu where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_CPU_Models sm : dt2.values()) {
                //INSERT TABLE CPU
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_cpu (Nomor_Transaksi,ID_CPU, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_CPU());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }
            //DELETE TABLE DETAIL GPU
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_gpu where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_GPU_Models sm : dt3.values()) {

                //INSERT TABLE DETAIL GPU
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_gpu (Nomor_Transaksi,ID_GPU, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_GPU());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }
            //DELETE TABLE DETAIL POWER SUPPLY
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_power_supply where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_PSU_Models sm : dt4.values()) {
                //INSERT TABLE DETAIL POWER SUPPLY
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_power_supply (Nomor_Transaksi,ID_PSU, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_PSU());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }
            //DELETE TABLE DETAIL COOLER
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_cooler where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_Cooler_Models sm : dt5.values()) {

                //INSERT TABLE COOLER
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_cooler (Nomor_Transaksi,ID_COOLER, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_COOLER());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }
            //DELETE TABLE DETAIL MOTHER BOARD
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_mother_board where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_Mother_Board_Models sm : dt6.values()) {
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_mother_board (Nomor_Transaksi,ID_MOTHER_BOARD, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_MOTHER_BOARD());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }
            //DELETE TABLE DETAIL RAM
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_ram where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_RAM_Models sm : dt7.values()) {
                
                //CREATE TABLE RAM
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_ram (Nomor_Transaksi,ID_RAM, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_RAM());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }
            //DELETE TABLE DETAIL SSD
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from detail_ssd where Nomor_Transaksi=?");
            con.preparedStatement.setInt(1, getTransaksiModel().getID_User());
            con.preparedStatement.executeUpdate();
            for (Detail_SSD_Models sm : dt8.values()) {
                //CREATE TABLE DETAIL SSD
                con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into detail_sdd (Nomor_Transaksi,ID_SSD, Quantity) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNomor_Transaksi());
                con.preparedStatement.setString(2, sm.getID_SSD());
                con.preparedStatement.setInt(3, sm.getQuantity());
                con.preparedStatement.executeUpdate();
            }

            con.Database_UTS_Conection.commit();//semua perintah di transaksi dikerjakan
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.Discconnect();
            return berhasil;
        }
    }

}
