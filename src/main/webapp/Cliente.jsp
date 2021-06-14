<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Cliente" %>
<html>
<head>
    <title>Clientes</title>
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
        <table>
            <thead>
                <td>RFC</td>
                <td>Nombre</td>
                <td>Telefono</td>
                <td>Calle</td>
                <td>Codigo Postal</td>
                <td>Ciudad</td>
                <td>Pais</td>
            </thead>
            <% List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes"); %>
            <% for(Cliente c : clientes) {%>
            <tr>
                <td><% out.println(c.getRfc()); %></td>
                <td><% out.println(c.getNom_pila() + " " + c.getApellido1() + " " + c.getApellido2()); %></td>
                <td><% out.println(c.getTelefono()); %></td>
                <td><% out.println(c.getCalle() + " " + c.getNumero()); %></td>
                <td><% out.println(c.getCodigo_postal()); %></td>
                <td><% out.println(c.getCiudad()); %></td>
                <td><% out.println(c.getPais()); %></td>
            </tr>
            <%}%>
        </table>
        <a href="InsertarCliente.jsp">Nuevo cliente</a>
    </div>
</body>
</html>
