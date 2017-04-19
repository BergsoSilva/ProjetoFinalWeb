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
        <title>Page Cadastro Mensagem</title>
    </head>
    <body>
        <h1>Formulario de Cadastro de Menssagens </h1>
        <form action="<c:url value='/adicionarClinte' />" method="POST">
            Tipo:<br>
            <input type="text" name="txtTipo"> <br><br>
             Descrição:<br>
            <input type="text" name="txtDescricao"><br>
           <br>
            <input type="submit" value="Salvar">
            
            
        </form>
    </body>
</html>
