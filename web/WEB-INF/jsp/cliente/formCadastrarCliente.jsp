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
        <h1>Formulario de Cadastro de Clientes</h1>
        <form action="<c:url value='/adicionarCliente'/>" method="POST">
            Nome:<br>
            <input type="text" name="cli_nome"> <br><br>
            Email:<br>
            <input type="text" name="cli_email"><br>
             Senha:<br>
            <input type="password" name="cli_senha"><br>
             Endereço:<br>
            <input type="text" name="cli_endereco"><br> 

           <br>
            <input type="submit" value="Salvar">
           
        </form>
    </body>
</html>
