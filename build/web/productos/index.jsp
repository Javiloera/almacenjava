<%-- 
    Document   : index
    Created on : 12 ene. 2022, 15:34:49
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMACÉN</title>
    </head>
    <body>
        <h1>PRODUCTOS</h1>
        
        <a href="ProductosController?accion=nuevo">Nuevo producto </a><!-- comment -->
        
        <br/> <br/><!-- comment -->
        
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Existencia</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${lista}" >
                    <tr>
                        <td><c:out value="${producto.codigo}"></c:out></td>
                        <td><c:out value="${producto.nombre}"></c:out></td>
                        <td><c:out value="${producto.precio}"></c:out></td>
                        <td><c:out value="${producto.existencia}"></c:out></td>
                        <td><a href="ProductosController?accion=modificar&id=<c:out value="${producto.ID}"></c:out>">Editar</a></td>
                        <td><a href="ProductosController?accion=eliminar&id=<c:out value="${producto.ID}"></c:out>">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
