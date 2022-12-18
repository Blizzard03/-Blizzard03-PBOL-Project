/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Muhamad Ariq Rasyid
 */
public class SqlConnection {
    
    public static Connection DbConnector(){        
        try{  
            Connection conn = null;
            
           Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database_pbol_uts?user=root&password=");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
           System.out.println(e);     
                }
        return null;
    }}
