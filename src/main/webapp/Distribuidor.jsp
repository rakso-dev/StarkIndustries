<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Distribuidor" %>
<html>
<head>
    <title>Distribuidores</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <a href="index.html"></a>
</header>
<nav class="navbar">
    <ul>
        <li><a href="index.html">Inicio</a></li>
        <li>Comprar</li>
        <li><a href="/StarkIndustries/Ingeniero">Empleados</a></li>
        <li><a href="/StarkIndustries/Fabricante">Proveedores</a></li>
        <li><a href="/StarkIndustries/Distribuidor">Distibuidores</a></li>
    </ul>
</nav>
<div class="mainbody">
    <% List<Distribuidor> distribuidores = (List<Distribuidor>) request.getAttribute("distribuidores"); %>
    <table>
        <thead>
        <td>RFC</td>
        <td>Nombre</td>
        <td>Calle</td>
        <td>Codigo Postal</td>
        <td>Ciudad</td>
        <td>Pais</td>
        </thead>
        <%for(Distribuidor d : distribuidores) {%>
        <tr>
            <td><%out.println(d.getRfc());%></td>
            <td><%out.println(d.getNombre());%></td>
            <td><%out.println(d.getCalle() + " " + d.getNumero());%></td>
            <td><%out.println(d.getCodigo_postal());%></td>
            <td><%out.println(d.getCiudad());%></td>
            <td><%out.println(d.getPais());%></td>
        </tr>
        <%}%>
    </table>
    <a href="/StarkIndustries/InsertarDistribuidor.jsp">Conviertete en distribuidor</a>
</div>
</body>
</html>
