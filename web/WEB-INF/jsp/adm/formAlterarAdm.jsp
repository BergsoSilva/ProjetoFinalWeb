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
        <title>Page Alterar Adiministradoes</title>
    </head>
    <body>
        <h3>Alterar Administrador - ${admins.id}</h3>
        <form action="<c:url value='/alteraAdm'/>" method="post">
            Id: 
            <br>
                <input type="hidden" name="id" value="${admins.id}" />
            <br>
            Nome:
            <br>
                <input type ="text" name="nome" value="${admins.nome}">
            <br>
            
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
