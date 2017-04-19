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
        <title>Lista de Produtos</title>
    </head>
    <body>
          <a href="<c:url value='/'/>">Home</a> <br><br>
          <table>
             <tr>
                <th>Id</th>
                <th>Descricao</th>
                <th>Qntde</th>
                <th>Preço</th>
                <th>Imagem</th>
                <th> Operacao </th>
             </tr>
            <c:forEach items="${listaPro}" var="pro">
             <tr>
                <td>${pro.proid}</td>
                <td>${pro.prodescricao}</td>
                <td>${pro.proquantde}</td>
                <td>${pro.provalor}</td>
                <td>${pro.proimagem}</td>
                <td><a href="exibeProduto?id=${pro.proid}"> Alterar </a>
                    <a href="removerProduto?id=${pro.proid}"
                       onclick="return confirm('Deseja realmente Excluir')">Remover</a>
                    
                </td>
              </tr>  
             </c:forEach>
        </table>
    </body>
</html>
