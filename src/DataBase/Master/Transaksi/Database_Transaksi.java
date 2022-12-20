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
    private HashMap<String,Detail_CPU_Models > dt2 = new HashMap<String, Detail_CPU_Models>();
    private HashMap<String, Detail_GPU_Models> dt3 = new HashMap<String, Detail_GPU_Models>();
    private HashMap<String, Detail_PSU_Models> dt4 = new HashMap<String, Detail_PSU_Models>();
    private HashMap<String, Detail_Cooler_Models> dt5 = new HashMap<String, Detail_Cooler_Models>();
    private HashMap<String, Detail_Mother_Board_Models> dt6 = new HashMap<String, Detail_Mother_Board_Models>();
    private HashMap<String, Detail_RAM_Models> dt7 = new HashMap<String, Detail_RAM_Models>();
    private HashMap<String, Detail_SSD_Models> dt8 = new HashMap<String, Detail_SSD_Models>();

    public TransaksiModels getTransaksiModel() {
        return (dt);
    }

    public void setJualModel(TransaksiModels s) {
        dt = s;
    }

    public HashMap<String, JualdetilModel> getJualdetilModel() {
        return (dt2);
    }

    public void setJualdetilModel(JualdetilModel d) {
        dt2.put(d.getKodebrg(), d);
    }

    public ObservableList<JualModel> Load() {
        try {
            ObservableList<JualModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select j.nojual,j.tanggal,c.idmember, c.nama from jual j join customer c on(j.idmember=c.idmember)");
            int i = 1;
            while (rs.next()) {
                JualModel d = new JualModel();
                d.setNojual(rs.getString("nojual"));
                d.setTgl(rs.getDate("tanggal"));
                d.setIdmember(rs.getString("idmember"));
                d.setNama(rs.getString("nama"));

                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validasi(String nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from jual where nojual = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into jual (nojual, tanggal,idmember) values (?,?,?)");
            con.preparedStatement.setString(1, getJualModel().getNojual());
            con.preparedStatement.setDate(2, getJualModel().getTgl());
            con.preparedStatement.setString(3, getJualModel().getIdmember());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jual where nojual  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update jual set tanggal = ?, idmember = ?  where  nojual= ? ");
            con.preparedStatement.setDate(1, getJualModel().getTgl());
            con.preparedStatement.setString(2, getJualModel().getIdmember());
            con.preparedStatement.setString(3, getJualModel().getNojual());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public ObservableList<JualModel> CariJual(String kode) {
        try {
            ObservableList<JualModel> tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select nojual, tanggal, idmember from jual WHERE nojual LIKE '" + kode + "%'");
            int i = 1;
            while (rs.next()) {
                JualModel d = new JualModel();
                d.setNojual(rs.getString("nojual"));
                d.setTgl(rs.getDate("tanggal"));
                d.setIdmember(rs.getString("idmember"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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

    public boolean saveall() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.dbKoneksi.setAutoCommit(false); // membuat semua perintah menjadi 1 transaksi
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jual where nojual=?");
            con.preparedStatement.setString(1, getJualModel().getNojual());
            con.preparedStatement.executeUpdate();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into jual (nojual,tanggal,idmember) values (?,?,?)");
            con.preparedStatement.setString(1, getJualModel().getNojual());
            con.preparedStatement.setDate(2, getJualModel().getTgl());
            con.preparedStatement.setString(3, getJualModel().getIdmember());
            con.preparedStatement.executeUpdate();
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jual_detil where nojual=?");
            con.preparedStatement.setString(1, getJualModel().getIdmember());
            con.preparedStatement.executeUpdate();
            for (JualdetilModel sm : dt2.values()) {
                con.preparedStatement = con.dbKoneksi.prepareStatement("insert into jual_detil (nojual,kodebrg, jumlah) values (?,?,?)");
                con.preparedStatement.setString(1, sm.getNojual());
                con.preparedStatement.setString(2, sm.getKodebrg());
                con.preparedStatement.setInt(3, sm.getJumlah());
                con.preparedStatement.executeUpdate();
            }
            con.dbKoneksi.commit();//semua perintah di transaksi dikerjakan
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

}
