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
        <title>Page Cadastro Cliente</title>
        <link rel="stylesheet" href="<c:url value='resources/css/principal.css'/>">
         
    </head>
    <body>
        <h1> Entrar com  Email e senha</h1>
        <form action="<c:url value='/efetuarLoginCliente'/>" method="POST">
            Email:<br>
            <input type="text" name="cliemail"><br>
             Senha:<br>
            <input type="password" name="clisenha"><br>
           
           <br>
            <input type="submit" value="Logar">
             <input type="button" value="Voltar" onclick="history.back()">
           
        </form>
    </body>
</html>
