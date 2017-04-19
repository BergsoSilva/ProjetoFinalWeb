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
        <title>Lista de Categorias</title>
    </head>
    <body>
          <a href="<c:url value='/'/>">Home</a> <br><br>
          <table>
             <tr>
                <th>Id</th>
                <th>Descriçao</th>
                <th> Operacao </th>
             </tr>
            <c:forEach items="${cats}" var="cat">
            <tr>
                <td>${cat.id}</td>
                <td>${cat.descricao}</td>
                <td><a href="exibeCat?id=${cat.id}"> Alterar </a>
                    <a href="removerCat?id=${cat.id}"
                       onclick="return confirm('Deseja realmente Excluir')">Remover</a>
                    
                </td>
             </c:forEach>
        </table>
    </body>
</html>
