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
       
    </head>
    <body>
        <div class="footer">
    
                <ul> 
                         <li><a href="<c:url  value='/'/>" >Home</a></li></li>
                         <li><a href="<c:url  value='#'/>" >Trabalhe Conosco</a></li></li>
           
                        <li><a href="<c:url  value='/menuCadastro'/>" >Administradores</a></li></li>
                 
                         <li><a href="<c:url  value='/welcome'/>" > Sobre Nós</a></li> 

                </ul>
                         
                  <p class="copy">&copy; Copyright 2016 WeJoias. Todos os Direitos Reservados</p> 
         </div>       
  
    </body>
</html>
