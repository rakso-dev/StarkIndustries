<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 27/05/21
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Ingeniero"%>
<html>
<head>
    <title>Ingenieros</title>
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
        <% List<Ingeniero> ing = (List<Ingeniero>) request.getAttribute("ingenieros");%>
        <table>
            <thead>
                <td>Cedula</td>
                <td>Nombre</td>
                <td>telefono</td>
                <td>Direccion</td>
                <td>Codigo Postal</td>
                <td>Ciudad</td>
                <td>Pais</td>
                <td>Estudios</td>
            </thead>
            <% for(Ingeniero i : ing) {%>
            <tr>
                <td><% out.println(i.getCedula()); %></td>
                <td><% out.println(i.getNom_pila() + " " + i.getApellido1() + " " + i.getApellido2()); %></td>
                <td><% out.println(i.getTelefono()); %></td>
                <td><% out.println(i.getCalle() + " " + i.getNumero()); %></td>
                <td><% out.println(i.getCodigo_postal()); %></td>
                <td><% out.println(i.getCiudad()); %> </td>
                <td><% out.println(i.getPais()); %></td>
                <td><% out.println(i.getEstudios()); %></td>
            </tr>
            <%}%>
        </table>
        <a href="InsertarIngeniero.jsp">Agregar empleado</a>
    </div>
</body>
</html>