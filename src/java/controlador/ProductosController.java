/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDAO;

/**
 *
 * @author alber
 */
@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductosDAO productoDAO = new ProductosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty())
        {
            dispatcher = request.getRequestDispatcher("productos/index.jsp");
            
            List<Productos> productos = productoDAO.listarProductos();
            
            request.setAttribute("lista", productos);
        }
        else if(accion.equals("nuevo"))
        {
            dispatcher = request.getRequestDispatcher("productos/nuevo.jsp");
        }
        else if(accion.equals("insert"))
        {
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));
            
            Productos producto = new Productos(0, codigo, nombre, precio, existencia);
            
            productoDAO.insertarProducto(producto);
                    
            dispatcher = request.getRequestDispatcher("productos/index.jsp");
            
            List<Productos> productos = productoDAO.listarProductos();
            
            request.setAttribute("lista", productos);
        }
         else if(accion.equals("modificar"))
        {
            dispatcher = request.getRequestDispatcher("productos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Productos producto = productoDAO.mostrarProducto(id);
            request.setAttribute("producto", producto);
        }
        else if(accion.equals("actualizar"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));
            
            Productos producto = new Productos(id, codigo, nombre, precio, existencia);
            
            productoDAO.actualizarProducto(producto);
                    
            dispatcher = request.getRequestDispatcher("productos/index.jsp");
            
            List<Productos> productos = productoDAO.listarProductos();
            
            request.setAttribute("lista", productos);
        }
        else if(accion.equals("eliminar"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            
            productoDAO.eliminarProducto(id);
                    
            dispatcher = request.getRequestDispatcher("productos/index.jsp");
            
            List<Productos> productos = productoDAO.listarProductos();
            
            request.setAttribute("lista", productos);
        }
        else
        {
            dispatcher = request.getRequestDispatcher("productos/index.jsp");
            
            List<Productos> productos = productoDAO.listarProductos();
            
            request.setAttribute("lista", productos);
        }
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
