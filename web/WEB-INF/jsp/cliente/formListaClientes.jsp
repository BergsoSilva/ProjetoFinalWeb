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
        <title>Lista de Clientes </title>
        <link rel="stylesheet" href="<c:url value='resources/css/principal.css'/>">
         
    </head>
    <body>
          <a href="<c:url value='/'/>">Voltar</a> <br><br>
          <table>
             <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th> Operacao </th>
             </tr>
            <c:forEach items="${listaCli}" var="cliente">
            <tr>
                <td>${cliente.id}</td>
                <td>${cliente.cli_nome}</td>
                <td>${cliente.cli_email}</td>
                <td><a href="exibeCliente?id=${cliente.id}"> Alterar </a>
                    <a href="Remover?id=${cliente.id}"
                       onclick="return confirm('Deseja realmente Excluir')">Remover</a>
                    
                </td>
             </c:forEach>
        </table>
    </body>
</html>
