/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBaseConnector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import Controller.MainMenu.Main_Menu2Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author mariq
 */
public class DataBaseUtilities {

    public static void ChangedScences(ActionEvent e, String FXML_FILE, String Tittle, String Nama_User) {
        Parent root = null;
        if (Nama_User != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DataBaseUtilities.class.getResource(FXML_FILE));
                root = loader.load();
              } catch (IOException Eror) {
                Eror.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DataBaseUtilities.class.getResource(FXML_FILE));
            } catch (IOException Eror) {
                Eror.printStackTrace();
            }
        }
        Stage stg = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stg.setTitle(Tittle);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(new Scene(root));
        stg.show();
    }

    public static void signupuser(ActionEvent e, String Nama_User, String Email_User, String Alamat_User, String Nomor_Telepon_User, String Password) {
        Connection connect = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckEmailExists = null;
        ResultSet rs = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_pbol_uts", "root", "");
            psCheckEmailExists = connect.prepareStatement("SELECT * FROM user WHERE Email_User =?");
            psCheckEmailExists.setString(1, Email_User);
            rs = psCheckEmailExists.executeQuery();
            if (rs.isBeforeFirst()) {
                System.out.println("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email already used!" + "\n" + "You can't used this email");
                alert.show();
            } else {
                psInsert = connect.prepareStatement("INSERT INTO user (Nama_User, Email_User, Alamat_User, Nomor_Telepon_User, Password) VALUES (?,?,?,?,?)");
                psInsert.setString(1, Nama_User);
                psInsert.setString(2, Email_User);
                psInsert.setString(3, Alamat_User);
                psInsert.setString(4, Nomor_Telepon_User);
                psInsert.setString(5, Password);
                psInsert.executeUpdate();
                ChangedScences(e, "/FXML_AND_CONTROLLERS/FirstDisplay/MainMenu.fxml", "Main Menu", null);
            }
        } catch (SQLException eror) {
            eror.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            if (psCheckEmailExists != null) {
                try {
                    psCheckEmailExists.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
        }
    }

    public static void login(ActionEvent e, String Email, String Password) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_pbol_uts", "root", "");
            statement = con.prepareStatement("SELECT Password,Nama_User FROM user Where Email_User=? ");
            statement.setString(1, Email);
            rs = statement.executeQuery();
            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Access Dennied!!! ⛔" + "\n"
                        + "404 Not Found!" + "\n"  
                        + "Email Not Found In Data Base!");
                alert.show();
            } else {
                while (rs.next()) {
                    String getPassword = rs.getString("Password");
                    String getName = rs.getString("Nama_User");
                    if (getPassword.equals(Password)) {
                        ChangedScences(e, "/FXML_AND_CONTROLLERS/MainMenu/Main_Menu2.fxml", "Main Menu", getName);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Access Dennied!!! ⛔" + "\n" +
                                "Passwords Did Not Match!");
                        alert.show();
                    }
                }

            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
              if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
                if (con != null) {
                try {
                    con.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
        }
    }

    public static void MainMenu(ActionEvent e, String Nama){
        
    }
}
