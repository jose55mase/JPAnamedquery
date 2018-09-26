<%-- 
    Document   : index
    Created on : 25/09/2018, 04:28:23 PM
    Author     : sebcas
--%>

<%@page import="com.entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP y  JPA</title>
    </head>
    <body>
        <form action="index.jsp">
            <input type="submit" value="Inicio"/>
        </form>
        <form action="EntidadUsuario" method="GET">
            <input type="submit" value="Ver Usuarios"/>
        </form>
        
        <br><br>
        
        <h1>JPA</h1><br>
        <h4>Guardar datos</h4><br>
        <form action="EntidadUsuario" method="POST">            
            Nombre a guardar<input type="text" name="nombre"/><br>
            Usuario a guardar<input type="text" name="usuario"/><br>
            Clave a guardar<input type="text" name="usuario"/><br>
            <input type="submit" value="Guardar Usuario"/><br>
        </form>
        

    </body>
</html>
