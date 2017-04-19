<%-- 
    Document   : menuNavegacao
    Created on : 29/05/2016, 11:01:01
    Author     : GRS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="resources/css/principal.css" rel="stylesheet"/>
        <title>Navegação</title>
    </head>
    <body>
    
       <ul> 
                <li><a href="<c:url  value='/'/>" >Home</a></li></li>
                <li><a href="<c:url  value='#'/>" >Cordões</a></li></li>
                <li><a href="<c:url  value='/#'/>" >Pulseiras</a></li></li>
                <li><a href="<c:url  value='/#'/>" >Aneis</a></li></li>
               
        </ul>
  
    </body>
</html>
