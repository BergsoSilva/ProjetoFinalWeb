<%-- 
    Document   : hearder
    Created on : 24/05/2016, 02:38:25
    Author     : GRS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="<c:url value='resources/css/header.css'/>" >
        <title>JSP Page</title>
    </head>
    <body>

        <div class="perfil">
            <c:set var="user" scope="session" value="${usuarioSession}"/>
            <c:set var="cliente" scope="session" value="${clienteSession}"/>

            <c:if test="${user != null}">
                <b>Ola!  eu so ${usuarioSession.usulogin}</b><br>
                <a href="<c:url  value='/exibeCliente?id=${usuarioSession.usucliid}'/>" > Ver Perfil </a>
            </c:if>
            <c:if test="${cliente!= null}">
                <b>Ola!  eu so ${clienteSession.clinome}</b><br>
                <a href="<c:url  value='/exibeCliente?id=${clienteSession.cli_id}'/>" > Ver Perfil </a>
            </c:if>


        </div>

        <div  id="hd1">

            <table class="tbCarrinho">
                <tr>
                    <td><a href="<c:url  value='/verCarrinho'/>"><figure> <img src="<c:url value="/resources/imagens/carrinho.png"/>" </figure></a></td>
                    <td>${scproduto.size()}</td>
                </tr>
                <tr>
                    <c:set var="user" scope="session" value="${usuarioSession.usucliid}"/>

                    <c:if test="${user == null}">
                        <td><a href="<c:url  value='/formLoginCliente'/>" >EfetuarLogin</a></td>
                        <td><a href="<c:url  value='/formCadCliente'/>" > Cadastre-se</a></td>
                    </c:if>
                    <c:if test="${user != null}">
                        <td><a href="<c:url  value='/logout'/>" >Logof</a></td>
                    </c:if>                        
                </tr>
            </table>


        </div>

        <div class="imgem">
            <figure> <img src="<c:url value="resources/imagens/body_index.jpg"/>" </figure>
        </div>


    </body>
</html>
