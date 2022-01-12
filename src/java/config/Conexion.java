/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author alber
 */
public class Conexion {
    
    public Connection getConexion()
    {
        try {
            
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen",
                    "root", "");
            
            return conexion;
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
            return null;
        }
    }
    
}
