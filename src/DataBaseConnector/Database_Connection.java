/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author mariq
 */
public class Database_Connection {

    public Connection Database_UTS_Conection;
    public Statement statement;
    public PreparedStatement preparedStatement;

    public Database_Connection() {
        this.Database_UTS_Conection = null;
    }

    public void Open_Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Database_UTS_Conection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database_pbol_uts?user=root&password=");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Discconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (Database_UTS_Conection != null) {
                Database_UTS_Conection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
