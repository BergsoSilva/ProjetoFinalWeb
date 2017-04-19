<%-- 
    Document   : formCadastrarClinte
    Created on : 14/05/2016, 21:14:02
    Author     : GRS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Alterar Compra</title>
    </head>
    <body>
        <h3> Alterando - ${compalt.compid}</h3>
        <form action="<c:url value='/alteraCompra'/>" method="post">
            Id: 
            <br>
                <input type="hidden" name="compid" value="${compalt.compid}" />
            <br>
            Cliente:
            <br>
                <input type ="text" name="compcliid" value="${compalt.compcliid}">
            <br>
            Status:
            <br>
                <input name="compstaid" value="${compalt.compstaid}">
            <br>
            
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
