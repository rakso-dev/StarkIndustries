<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Armadura" %>
<html>
<head>
    <title>Comprar</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <a href="index.html"></a>
    </header>
    <nav class="navbar">
        <ul>
            <li><a href="index.html">Inicio</a></li>
            <li><a href="/StarkIndustries/Armadura">Comprar</a></li>
            <li><a href="/StarkIndustries/Ingeniero">Empleados</a></li>
            <li><a href="/StarkIndustries/Fabricante">Proveedores</a></li>
            <li><a href="/StarkIndustries/Distribuidor">Distibuidores</a></li>
        </ul>
    </nav>
    <div class="mainbody">
        <% List<Armadura> armaduras = (List<Armadura>) request.getAttribute("armaduras");%>
        <% for(Armadura a: armaduras) { %>
        <div>
        <% out.println(a.getNum_serie());%> <br>
        <% out.println(a.getModelo()); %> <br>
        </div>
        <%}%>
        <a href="InsertarArmadura.jsp">Crear nueva armadura</a>
    </div>
</body>
</html>
