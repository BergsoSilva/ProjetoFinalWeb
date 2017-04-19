<%-- 
    Document   : formCadastroUsuario
    Created on : 16/06/2016, 01:35:03
    Author     : GRS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro  de Usuario </title>
    </head>
    <body>
        <form action="<c:url value='/salvarUsuario'/>" method="post">
                   Nome de usuário : <br> <br>
                   <input type="text" name ="usulogin" required>  <br> <br>
                   Senha  : <br> <br>
                   <input type="password" name ="ususenha" required>  <br> <br>
                   <input type="submit" value="Salvar"/>
        </form>
       
    </body>
</html>
