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
        <title>Page Cadastro Categorias</title>
    </head>
    <body>
        <h1>Formulario de Cadastro de Categorias</h1>
        <form action="<c:url value='/adicionarCategoria' />" method="POST">
            Categoria:<br>
            <input type="text" name="descricao"><br>
           <br>
            <input type="submit" value="Salvar">
            
            
        </form>
    </body>
</html>
