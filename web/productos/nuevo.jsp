<%-- 
    Document   : nuevo
    Created on : 12 ene. 2022, 15:35:08
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacén</title>
    </head>
    <body>
        <h2>Nuevo registro</h2>
        
        <br> <br><!-- comment -->
        
        <form action="action" method="post" autocomplete="off">
            <p>
                Código:
                <input id="codigo" name="codigo" type="text"/>
            </p>
            <p>
                 Nombre:
                <input id="nombre" name="nombre" type="text"/>
            </p>
            <p>
                 Precio
                <input id="precio" name="precio" type="text"/>
            </p> 
            
            <p>
                 Existencia:
                <input id="existencia" name="existencia" type="text"/>
            </p>
            <p>
                <button id="guardar" name="guardar" type="submit">Guardar</button>
            </p>
        </form>
    </body>
</html>
