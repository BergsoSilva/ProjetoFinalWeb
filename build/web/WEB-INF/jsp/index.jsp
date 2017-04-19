<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Tela Inicial</title>

        <link rel="stylesheet" href="<c:url value='resources/css/principal.css'/>">

    </head>

    <body>

    <header>
        <c:import url="hearder.jsp" />
    </header>
    <nav>
        <c:import url="menuNavegacao.jsp"/>
    </nav>

    <section>
        <iframe name="listaProdutos" src="<c:url value='/listaProImagem'/>" id="iframeP"  scrolling="yes"></iframe>  
    </section>

    <footer> 
        <c:import url="footer.jsp"/>  
    </footer>


</body>
</html>
