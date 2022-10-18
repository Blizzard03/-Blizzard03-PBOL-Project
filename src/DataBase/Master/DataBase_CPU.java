/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master;

import DataBaseConnector.Database_Connection;
import Models.CPU.CPUModels;
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

    public ObservableList<CPUModels> Load() {
        try {
            ObservableList<CPUModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from cpu");
            int i = 1;
            while (rs.next()) {
                CPUModels d = new Models.CPU.CPUModels();
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
    
      public ObservableList<CPUModels> CariCPU(String kode, String nama) {
        try {
            ObservableList<Models.CPU.CPUModels> tableData;
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
}
