<%-- 
    Document   : formCadastrarClinte
    Created on : 14/05/2016, 21:14:02
    Author     : GRS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Cadastro Administradores</title>
    </head>
    <body>
        <h1>Formulario de Cadastro de Administradores</h1>
        <form action="<c:url value='/adicionarAdm'/>" method="POST">
            Nome:<br>
            <input type="text" name="nome"> <br><br>
            <br>
            <input type="submit" value="Salvar">
           
        </form>
    </body>
</html>
