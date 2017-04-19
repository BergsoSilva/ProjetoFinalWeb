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
        <title>Page Alterar Categorias</title>
    </head>
    <body>
        <h3>Alterar Categoria - ${cat.id}</h3>
        <form action="<c:url value='/alteraCat'/>" method="post">
            Id: 
            <br>
                <input type="hidden" name="id" value="${catbanco.id}" />
            <br>
            Nome:
            <br>
                <input type ="text" name="descricao" value="${catbanco.descricao}">
            <br>
            
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
