<%-- 
    Document   : formFechaCompra
    Created on : 08/06/2016, 23:28:48
    Author     : GRS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Finalizar Compra , Ususario : <b>${usuario.usulogin}</b></h1></h2>
        
        <form action="<c:url value='/adicionarCompra'/>" method="post">
             
            Usuario:<input  name="compcliid" value="${usuario.usucliid}">
             Status: <input name="compstaid" value="1">
             
             <input type="submit" value="Adiconar Compra"> 
              
        </form>
    </body>
</html>
