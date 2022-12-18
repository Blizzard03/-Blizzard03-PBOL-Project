/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase.Master.User;

import DataBaseConnector.Database_Connection;
import Models.Master.User.UsersModels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mariq
 */
public class DataBase_User {

    private UsersModels usr = new UsersModels();

    public UsersModels getUserModels() {
        return (usr);
    }

    public void setUserModels(UsersModels usrsm) {
        usr = usrsm;
    }

    public ObservableList<UsersModels> Load() {
        try {
            ObservableList<UsersModels> tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from user");
            int i = 1;
            while (rs.next()) {
                UsersModels d = new UsersModels();
                d.setID_User(rs.getInt("ID_User"));
                d.setNama_User(rs.getString("Nama_User"));
                d.setEmail_User(rs.getString("Email_User"));
                d.setAlamat_User(rs.getNString("Alamat_User"));
                d.setNomor_Telepon_User(rs.getString("Nomor_Telepon_User"));
                d.setPassword(rs.getNString("Password"));
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

    public int validate(int nomor) {
        int val = 0;
        try {
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = con.Database_UTS_Conection.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from user where ID_User = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.Discconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean Insert_Data() {
        boolean Succes = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("insert into user (Nama_User, Email_User, Alamat_User, Nomor_Telepon_User, Password ) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getUserModels().getNama_User());
            con.preparedStatement.setString(2, getUserModels().getEmail_User());
            con.preparedStatement.setString(3, getUserModels().getAlamat_User());
            con.preparedStatement.setString(4, getUserModels().getNomor_Telepon_User());
            con.preparedStatement.setString(5, getUserModels().getPassword());
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

    public boolean Update_Data() {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("update user set  Email_User = ?, Alamat_User = ?, Nomor_Telepon_User = ?, Password = ? where  ID_User = ? ");  
            con.preparedStatement.setString(1, getUserModels().getEmail_User());
            con.preparedStatement.setString(2, getUserModels().getAlamat_User());
            con.preparedStatement.setString(3, getUserModels().getNomor_Telepon_User());
            con.preparedStatement.setString(4, getUserModels().getPassword());
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
    
    
    public boolean Delete_Data(int ID) {
        boolean Success = false;
        Database_Connection con = new Database_Connection();
        try {
            con.Open_Connection();;
            con.preparedStatement = con.Database_UTS_Conection.prepareStatement("delete from user where ID_User  = ? ");
            con.preparedStatement.setInt(1, ID);
            con.preparedStatement.executeUpdate();
            Success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.Discconnect();
            return Success;
        }
    }

    public ObservableList<UsersModels> CariUser(String kode, String nama) {
        try {
            ObservableList<UsersModels> tableData;
            tableData = FXCollections.observableArrayList();
            Database_Connection con = new Database_Connection();
            con.Open_Connection();
            con.statement = (Statement) con.Database_UTS_Conection.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from user WHERE ID_User LIKE '" + kode + "%' OR Nama_User LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                UsersModels d = new UsersModels();
                d.setID_User(rs.getInt("ID_User"));
                d.setNama_User(rs.getString("Nama_User"));
                d.setEmail_User(rs.getString("Email_User"));
                d.setAlamat_User(rs.getNString("Alamat_User"));
                d.setNomor_Telepon_User(rs.getString("Nomor_Telepon_User"));
                d.setPassword(rs.getNString("Password"));
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
