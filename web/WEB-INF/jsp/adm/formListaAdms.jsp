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
        <title>Lista de Admisnistradores</title>
    </head>
    <body>
          <a href="<c:url value='/'/>">Home</a> <br><br>
          <table>
             <tr>
                <th>Id</th>
                <th>Nome</th>
                <th> Operacao </th>
             </tr>
            <c:forEach items="${listaAdm}" var="adm">
            <tr>
                <td>${adm.id}</td>
                <td>${adm.nome}</td>
                <td><a href="exibeAdm?id=${adm.id}"> Alterar </a>
                    <a href="removerAdm?id=${adm.id}"
                       onclick="return confirm('Deseja realmente Excluir')">Remover</a>
                    
                </td>
             </c:forEach>
        </table>
    </body>
</html>
