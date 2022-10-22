/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.Mother_Board;

import DataBaseConnector.Database_Connection;
import Models.Master.Mother_Board_Models.Mother_Board_Models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_MotherBoard {

    private Mother_Board_Models mobo = new Mother_Board_Models();

    public Mother_Board_Models getMother_Board_Models() {
        return (mobo);
    }

    public void setMother_Board_Models(Mother_Board_Models mbm) {
        mobo = mbm;
    }

    public ObservableList<Mother_Board_Models> Load() {
        try {
            ObservableList<Mother_Board_Models> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from mother_board");
            int i = 1;
            while (rs.next()) {
                Mother_Board_Models mobo = new Mother_Board_Models();
                mobo.setID_MOTHER_BOARD(rs.getString("ID_MOTHER_BOARD"));
                mobo.setVendor(rs.getString("Vendor"));
                mobo.setNama_Mother_Board(rs.getString("Nama_Mother_Board"));
                mobo.setType(rs.getString("Type"));
                mobo.setSocket(rs.getString("Socket"));
                mobo.setHarga(rs.getInt("Harga"));
                tableData.add(mobo);
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from mother_board where ID_MOTHER_BOARD = '" + nomor + "'");
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into mother_board (ID_MOTHER_BOARD,Vendor,Nama_Mother_Board,Type,Socket,Harga ) values (?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getMother_Board_Models().getID_MOTHER_BOARD());
            con.preparedStatement.setString(2, getMother_Board_Models().getVendor());
            con.preparedStatement.setString(3, getMother_Board_Models().getNama_Mother_Board());
            con.preparedStatement.setString(4, getMother_Board_Models().getType());
            con.preparedStatement.setString(5, getMother_Board_Models().getSocket());
            con.preparedStatement.setInt(6, getMother_Board_Models().getHarga());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update mother_board set ID_MOTHER_BOARD=?,Vendor=?,Nama_Mother_Board=?,Type=?,Socket=?,Harga=? ");
            con.preparedStatement.setString(1, getMother_Board_Models().getID_MOTHER_BOARD());
            con.preparedStatement.setString(2, getMother_Board_Models().getVendor());
            con.preparedStatement.setString(3, getMother_Board_Models().getNama_Mother_Board());
            con.preparedStatement.setString(4, getMother_Board_Models().getType());
            con.preparedStatement.setString(5, getMother_Board_Models().getSocket());
            con.preparedStatement.setInt(6, getMother_Board_Models().getHarga());
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

    public ObservableList<Mother_Board_Models> CariUser(String kode, String nama) {
        try {
            ObservableList<Mother_Board_Models> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from mother_board WHERE ID_MOTHER_BOARD LIKE '" + kode + "%' OR Nama_Mother_Board LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                Mother_Board_Models mobo = new Mother_Board_Models();
                mobo.setID_MOTHER_BOARD(rs.getString("ID_MOTHER_BOARD"));
                mobo.setVendor(rs.getString("Vendor"));
                mobo.setNama_Mother_Board(rs.getString("Nama_Mother_Board"));
                mobo.setType(rs.getString("Type"));
                mobo.setSocket(rs.getString("Socket"));
                mobo.setHarga(rs.getInt("Harga"));
                tableData.add(mobo);
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
