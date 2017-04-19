<%-- 
    Document   : formUsuario
    Created on : 13/05/2009, 21:28:32
    Author     : GRS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="<c:url value='resources/css/principal.css'/>">
         
    </head>
    <body>
        <h2> Pagina de Login</h2>
        
        <div class="msgErro" >${msgLoginIvalido}</div>
        <br><br>
        <form action="<c:url value='/efetuarLogin'/>" method="post">
            Login:
            <br>
            <input type="text" name="usulogin" required>
            <br>
            Senha:
            <br>
            <input type="password" name="ususenha" required>
            <br>
            <input type="submit" value="Entrar" required>
            <input type="button" value="Voltar" onclick="history.back()">
            
        </form>
                
    </body>
</html>
