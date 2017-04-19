<%-- 
    Document   : formFinalizarCompra
    Created on : 29/05/2016, 13:02:58
    Author     : GRS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="resources/css/compra.css" rel="stylesheet"/>
        <title>Carrinho de Compra</title>
   </head>
    <body>
        
        <h2> Valor da compra : </h2>
          ${scmenssagem}
        <form action="<c:url value='/fecharCompra'/>" method="post">
                  
            <table>
                <tr> <th> Descriçao</th>
                     <th> Valor </th> 
                     <th> Qntde</th>
                     <th> OPeração</th>
                </tr>
                <c:forEach var="pro" items="${scproduto}">
                <tr>
                    
                    <td> <input  name="descricaoProduto" value="${pro.descricaoProduto}" disabled="true"> </td>
   
                    <td> <input  name="valorProduto" value="${pro.valorProduto}" disabled="true"></td>

                    <td> <input  name="qtdeItemSelecionado" value="${qtdeItemSelecionado}" > </td>
                    
                    <td> <a href="removerItem?id=${pro.produtoid}"
                       onclick="return confirm('Deseja realmente Excluir')">Remover</a></a>
                </tr>
               </c:forEach>
                <tr> <td> Total compra ${sctotalCompra}</td></tr>
                <tr> <td colspan="3">  <td> <input type="submit" value="Fechar Pedidoo"></td></tr>
          </table>
           
       </form>   

    </body>
</html>
