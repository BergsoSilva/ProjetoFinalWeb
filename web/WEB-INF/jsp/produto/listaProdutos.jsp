<%-- 
    Document   : listaProdutos
    Created on : 24/05/2016, 03:34:45
    Author     : GRS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="resources/css/vitrine.css" rel="stylesheet"/>
        <title>Listando....</title>
    </head>
    <body>
        <div class="container">
       
  <!-- **************************************************************************
       ************************************************************************** -->
         <c:forEach var="produto" items="${listaPro}">
          
                <aside>
              
                    <table id="t">
                        <tr> <!-- linha1 -->
                              <td colspan="3"><p> <strong>${produto.prodescricao}</strong> <br /></td>
                        </tr>
                        <tr> <!-- linha2 -->
                            <td rowspan="2">
                                <!-- Enviar pedido de produto selecionado formCompra.jsp-->
                                <a href="formCadCompra?id=${produto.proid}" > 
                                    <figure> <img src="<c:url value="resources/imagens/${produto.proimagem}"/>" </figure>
                                 </a>
                            </td> 
                            <td colspan="2">
                                <h2>Código : ${produto.proid}</h2>
                                <h2>Preco  : ${produto.provalor}</h2>
                            </td>
                    
                   
                        </tr>
                        <tr> <!-- linha4 -->
                             <td colspan="2">
                                 <form method="post"  <form action="<c:url value='/formCadCompra?id=${produto.proid} '/>">
                                <br />
                                <input class="button" type="submit" value="Conprar">
                                </form>
	                                       
                         </td>
                     
                        </tr>
                    </table>  
                </aside>
          
        </c:forEach>                
        </div>  
    </body>
</html>
