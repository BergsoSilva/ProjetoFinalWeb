<%-- 
    Document   : formCompra
    Created on : 27/05/2016, 22:56:11
    Author     : GRS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="resources/css/compra.css" rel="stylesheet"/>
        <title>Detahes Produto</title>
        <script src="scripts/jquery.js"></script>
    </head>
    <body>
        <div class="container">
       
  <!-- **************************************************************************
       ************************************************************************** -->
                
                <aside>
                            <form action="<c:url value='/formFimCompra?id=${produto.proid}'/>" method="post">        
                                    <table id="t">
                                                      <tr> <!-- linha1 -->
                                                          <td colspan="2">${produto.prodescricao}<br /></td>
                                                      </tr>
                                                      <tr> <!-- linha2 -->
                                                               <td rowspan="2">
                                                                       <figure> <img src="<c:url value="/resources/bigImagens/${produto.proimagem}"/>" </figure>
                                                               </td> 
                                                               <td colspan="2">
                                                                       <h2>Código :${produto.proid}</h2>
                                                                       <h2>Preco  : ${produto.provalor}</h2>
                                                                       <h2> Qtde   : <input name="quantidadeProduto" value="${quantidadeProduto}"></h2>
                                                                       
                                                              </td>

                                                      </tr>
                                                      <tr>
                                                              <td colspan="2">
                                                                       
                                                                                 <input id="btnCompra" type="submit" value="Adicionar ao Carrinho">
                                                               </td>
                                                     </tr>
                                    </table>
                           <form>       
                       
                </aside>
                         
        </div> 
    </body>
</html>
