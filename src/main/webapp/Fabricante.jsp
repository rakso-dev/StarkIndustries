<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Fabricante" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Fabricante</title>
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
        <% List<Fabricante> fabricantes = (List<Fabricante>) request.getAttribute("fabricantes"); %>
        <table>
            <thead>
                <td>RFC</td>
                <td>Nombre</td>
                <td>Calle</td>
                <td>Codigo Postal</td>
                <td>Ciudad</td>
                <td>Pais</td>
            </thead>
            <%for(Fabricante f : fabricantes) {%>
            <tr>
               <td><%out.println(f.getRfc());%></td>
               <td><%out.println(f.getNombre());%></td>
               <td><%out.println(f.getCalle() + " " + f.getNumero());%></td>
               <td><%out.println(f.getCodigo_postal());%></td>
               <td><%out.println(f.getCiudad());%></td>
               <td><%out.println(f.getPais());%></td>
            </tr>
            <%}%>
        </table>
        <a href="InsertarFabricante.jsp">Conviertete en Proveedor</a>
    </div>
</body>
</html>
