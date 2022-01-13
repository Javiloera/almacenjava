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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alber
 */
public class Conexion {
    
    public Connection getConexion() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen",
                    "root", "admin");
            
            System.out.println("Conexion exitosa");
            return conexion;
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }
    
}
