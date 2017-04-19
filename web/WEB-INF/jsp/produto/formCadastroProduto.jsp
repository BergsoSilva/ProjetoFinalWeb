<%-- 
    Document   : formCadastroProduto
    Created on : 19/05/2016, 22:46:49
    Author     : GRS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <h1> Cadastrando </h1>
         <form action="<c:url value='/adicionarProduto'/>" method="POST">
             
              Descricao:<br>
              <input type="text" name="prodescricao"  size="50"required > <br><br>
              
              Quantidade:<br>
              <input  name="proquantde"><br>
              <br>
              Preço:
              <br>
              <input  name="provalor"><br>
              <br>
              Categoria:<br>
              <select name="procatid" >
              <c:forEach items="${cats}" var="cat"> 
                 <option value="${cat.id}" selected>${cat.descricao}</option>
              </c:forEach>  
              </select> 
              <br> <br>
              Administrador:<br>
              <select name="proadminid" >
              <c:forEach items="${adms}" var="ad"> 
                 <option value="${ad.id}" selected>${ad.nome}</option>
              </c:forEach>  
              </select> 
              <br><br>
              <input type="file" name="proimagem"  value="Upload" >
              <br><br>
              <input type="submit" value="Salvar"> 
              <br><br>
              <h2> <a href="<c:url  value='/'/>" >Home</a></h2>
           
        </form>

    </body>
</html>
