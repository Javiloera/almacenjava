/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alber
 */
public class ProductosDAO {
    
    Connection conexion;
    
    public ProductosDAO()
    {
        Conexion con = new Conexion();
        
        conexion = con.getConexion();
    }
    
    public List<Productos> listarProductos()
    {
        
        PreparedStatement ps;
        ResultSet rs;
        List<Productos> lista = new ArrayList<>();
        
        try {
            ps = conexion.prepareStatement("SELECT id, codigo, nombre, precio, existencia FROM productos");
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                Productos producto = new Productos(id, codigo, nombre, precio, existencia);
                
                            
                lista.add(producto);
            }
            
            return lista;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            
            return null;
        }
    }
    
    public Productos mostrarProducto(int _id)
    {
        
        PreparedStatement ps;
        ResultSet rs;
        Productos producto = null;
        
        try {
            ps = conexion.prepareStatement("SELECT id, codigo, nombre, precio, existencia FROM productos WHERE id = ?");
            ps.setInt(1, _id);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                producto = new Productos(id, codigo, nombre, precio, existencia);
                
            }
            
            return producto;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            
            return null;
        }
    }
    
    public boolean insertarProducto(Productos producto)
    {
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("INSERT INTO productos (codigo, nombre, precio, existencia) VALUES (?, ?, ?, ?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            
            return false;
        }
    }
    
    public boolean actualizarProducto(Productos producto)
    {
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("UPDATE productos SET codigo = ?, nombre = ?, precio = ?, existencia = ? WHERE id = ?");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.setInt(5, producto.getID());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            
            return false;
        }
    }
    
    public boolean eliminarProducto(int _id)
    {
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("DELETE FROM productos WHERE id = ?");
            ps.setInt(1, _id);
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            
            return false;
        }
    }
}
