/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.CPU;

import DataBaseConnector.Database_Connection;
import Models.Master.CPU.CPUModels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_CPU {

    private CPUModels CPU = new CPUModels();

    public CPUModels GetModel() {
        return (CPU);
    }

    public void SetCPUModels(CPUModels CPU_Models) {
        CPU = CPU_Models;
    }

    
    
    

    /**
     *
     * Read Data
     * @return 
     */
    
    public ObservableList<CPUModels> Load() {
        try {
            ObservableList<CPUModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from cpu");
            int i = 1;
            while (rs.next()) {
                CPUModels d = new Models.Master.CPU.CPUModels();
                d.setID_CPU(rs.getString("ID_CPU"));
                d.setNama_CPU(rs.getString("Nama_CPU"));
                d.setBase_Clock(rs.getString("Base_Clock"));
                d.setMax_Turbo_Clock(rs.getString("Max_Turbo_Clock"));
                d.setCores(rs.getInt("Cores"));
                d.setThread(rs.getInt("Thread"));
                d.setHarga(rs.getInt("Harga"));
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

    /**
     *
     * @param nomor
     * @return
     */
    public int validasi(String nomor) {
        int val = 0;
        try {
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from cpu where ID_CPU = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.Discconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    
   

    /**
     *Search Data
     * @param kode
     * @param nama
     * @return
     */
    public ObservableList<CPUModels> CariCPU(String kode, String nama) {
        try {
            ObservableList<Models.Master.CPU.CPUModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from cpu WHERE ID_CPU LIKE '" + kode + "%' OR Nama_CPU LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                CPUModels d = new CPUModels();
                d.setID_CPU(rs.getString("ID_CPU"));
                d.setNama_CPU(rs.getString("Nama_CPU"));
                d.setBase_Clock(rs.getString("Base_Clock"));
                d.setMax_Turbo_Clock(rs.getString("Max_Turbo_Clock"));
                d.setCores(rs.getInt("Cores"));
                d.setThread(rs.getInt("Thread"));
                d.setHarga(rs.getInt("Harga"));

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

    public boolean insert_Data() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into cpu (ID_CPU,Nama_CPU, Socket, Base_Clock, Max_Turbo_Clock, Cores, Thread,TDP, Harga) values (?,?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, GetModel().getID_CPU());
            con.preparedStatement.setString(2, GetModel().getNama_CPU());
            con.preparedStatement.setString(3, GetModel().getSocket());
            con.preparedStatement.setString(4, GetModel().getBase_Clock());
            con.preparedStatement.setString(5, GetModel().getMax_Turbo_Clock());
            con.preparedStatement.setInt(6, GetModel().getCores());
            con.preparedStatement.setInt(7, GetModel().getThread());
            con.preparedStatement.setString(8, GetModel().getTDP());
            con.preparedStatement.setInt(9, GetModel().getHarga());
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
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from cpu where ID_CPU  = ? ");
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

    public boolean Update_Data() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update cpu set Nama_CPU =?, Socket = ?, Base_Clock=?, Max_Turbo_Clock=?, Cores=?, Thread,TDP, Harga  where  ID_CPU = ? ");
            con.preparedStatement.setString(1, GetModel().getNama_CPU());
            con.preparedStatement.setString(2, GetModel().getSocket());
            con.preparedStatement.setString(3, GetModel().getBase_Clock());
            con.preparedStatement.setString(4, GetModel().getMax_Turbo_Clock());
            con.preparedStatement.setInt(5, GetModel().getCores());
            con.preparedStatement.setInt(6, GetModel().getThread());
            con.preparedStatement.setString(7, GetModel().getTDP());
            con.preparedStatement.setInt(8, GetModel().getHarga());
            con.preparedStatement.setString(9, GetModel().getID_CPU());
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

}
