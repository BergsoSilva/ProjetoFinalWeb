<%-- 
    Document   : formCadastrarClinte
    Created on : 14/05/2016, 21:14:02
    Author     : GRS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Compras</title>
    </head>
    <body>
          <a href="<c:url value='/'/>">Home</a> <br><br>
          <table>
             <tr>
                <th>Id</th>
                <th>Cliente</th>
                <th>Status</th>
                <th>Operacao </th>
             </tr>
             <c:forEach items="${compras}" var="comp">
             <tr>
                <td>${comp.compid}</td>
                <td>${comp.compcliid}</td>
                <td>${comp.compstaid}</td>
                <td><a href="exibeCompra?id=${comp.compid}"> Alterar </a>
                    <a href="removerCompra?id=${comp.compid}"
                       onclick="return confirm('Deseja realmente Excluir')">Remover</a>
                </td> 
             </tr> 
             </c:forEach>
        </table>
    </body>
</html>
