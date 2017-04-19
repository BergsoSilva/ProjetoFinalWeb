<%-- 
    Document   : menuCadastro
    Created on : 19/05/2016, 11:17:22
    Author     : 03
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela de Menu</title>
        <link rel="stylesheet" href="<c:url value='resources/css/principal.css'/>">  
        <link type="text/css" href="resources/css/menu.css" rel="stylesheet"/>
          
    </head>
    <body>
        <h3>Apenas Administradores!!</h3>
        Bem-Vindo(a), ${usuarioLogado.usulogin}! id ${usuarioLogado.usuid}
        
        <table >
                    <tr>
                            <td><h2><a href="<c:url  value='/formCadCliente'/>" > Cadastrar Cliente</a></h2></td>
                            <td><h2><a href="<c:url  value='/listaCliente'/>" > Listar Clientes </a></h2></td>
                    </tr> 
                    <tr>
                            <td><h2> <a href="<c:url  value='/formCadCategoria'/>" > Cadastrar Categoria</a></h2></td>
                            <td><h2><a href="<c:url  value='/listaCategoria'/>" > Lista</a></h2></td>
                    </tr>
                    <tr>
                            <td><h2><a href="<c:url  value='/formCadCurriculum'/>" > Cadastrar Curriculum</a></h2></td>
                            <td>Lista Currivulums</td>
                    </tr>
                    <tr>
                            <td><h2><a href="<c:url  value='/formCadMenssagem'/>" > Cadastrar Menssagem</a></h2></td>
                            <td>Listar Mensagem</td>
                    </tr>
                    <tr>
                               <td><h2><a href="<c:url  value='/formCadAdm'/>" > Cadastrar Administrador</a></h2></td>
                               <td><h2><a href="<c:url  value='/listaAdministrador'/>" > Lista</a></h2></td>
                    </tr>
                    <tr>
                                <td><h2> <a href="<c:url  value='/formCadProduto'/>" > Cadastrar Produto</a></h2></td>
                                <td><h2><a href="<c:url  value='/listaProduto'/>" > Lista</a></h2></td>
                    </tr>
                    <tr>
                                <td><h2><a href="<c:url  value='/listaCompras'/>" > Lista Compras</a></h2></td>
                    </tr>
                    <tr>
                                <td><h2> <a href="<c:url  value='/'/>" >Home</a></h2></td>
                                <td><h2><a href="<c:url  value='/listaProduto'/>" > Nao faz nada </a></h2></td>
                    </tr>
             
        </table>
        <br><br>
        <a href="<c:url value='/logout'/>">Sair</a>
        <a href="<c:url value='/'/>">Voltar</a>
            
    </body>
</html>
