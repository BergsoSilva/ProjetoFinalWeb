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
        <title>Page Alterar Clientes</title>
        <link rel="stylesheet" href="<c:url value='resources/css/principal.css'/>">
         
    </head>
    <body>
        <h3>Alterar cliente - ${cliente.id}</h3>
        
                <form action="<c:url value='/alteraCliente'/>" method="post">
                    Id: 
                    <br>
                        <input type="hidden" name="id" value="${cliente.id}" />
                    <br>
                    Nome:
                    <br>
                        <input type ="text" name="cli_nome" value="${cliente.cli_nome}">
                    <br>
                    Email:
                    <br>
                        <input type ="text" name="cli_email" value="${cliente.cli_email}">
                    <br>
                    Senha:
                    <br>
                    <input type ="password" name="cli_senha" value="${cliente.cli_senha}">
                    <br>
                    Endereço:
                    <br>
                    <input type ="text" name="cli_endereco" value="${cliente.cli_endereco}">
                    <br>
                            <input type="submit" value="Alterar"/>
                    <br><br>            
                </form>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
