<%-- 
    Document   : formCadastrarClinte
    Created on : 14/05/2016, 21:14:02
    Author     : GRS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Alterar Adiministradoes</title>
    </head>
    <body>
        <h3> Alterando - ${pro.proid}</h3>
        <form action="<c:url value='/alteraProduto'/>" method="post">
            Id: 
            <br>
                <input type="hidden" name="proid" value="${pro.proid}" />
            <br>
            Descricao:
            <br>
                <input type ="text" name="prodescricao" value="${pro.prodescricao}">
            <br>
            Qantidade:
            <br>
                <input name="proquantde" value="${pro.proquantde}">
            <br>
            <br>
            Valor:
             <br>
                <input  name="provalor" value="${pro.provalor}">
            <br>
            <br>
            Categoria:
             <br>
                <input  name="procatid" value="${pro.procatid}">
            <br>
            <br>
            Responsavel:
             <br>
                <input  name="proadminid" value="${pro.proadminid}">
            <br>
            Imagem:
            <br>
               <figure> <img src="<c:url value="resources/imagens/${pro.proimagem}"/>" </figure>
               <br>
               <input type="file" name="proimagem" >
            <br>
            <br>
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
