<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 14/06/21
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar empleados</title>
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
        <% out.println("");%>
        <form method="post" action="/StarkIndustries/Ingeniero">
            <input type="hidden" name="option" value="2">
            <% out.println("Cedula Profesional <input type=\"text\" name=\"cedula\" maxlength=\"8\" value=\"" + request.getParameter("cedula") + "\");> <br>"); %>
            <% out.println("Nombre <input type=\"text\" name=\"nombre\" maxlength=\"15\" value=\"" + request.getParameter("nom_pila") + "\"> <br>"); %>
            <% out.println("Primer apellido <input type=\"text\" name=\"primerApellido\" maxlength=\"20\" value=\""+ request.getParameter("apellido1") + "\"> <br>"); %>
            <% out.println("Segundo apellido <input type=\"text\" name=\"segundoApellido\" maxlength=\"20\" value=\""+ request.getParameter("apellido2") +"\"> <br>"); %>
            <% out.println("Telefono <input type=\"text\" name=\"telefono\" maxlength=\"10\" value=\"" + request.getParameter("telefono") + "\"> <br>"); %>
            <% out.println("Calle <input type=\"text\" name=\"calle\" maxlength=\"20\" value=\"" + request.getParameter("calle") + "\">"); %>
            <% out.println("Numero <input type=\"text\" name=\"numero\" value=\"" + request.getParameter("numero") + "\"> <br>"); %>
            <% out.println("Codigo Postal <input type=\"text\" name=\"codigoPostal\" maxlength=\"5\" value=\"" + request.getParameter("codigo_postal") + "\"> <br>"); %>
            <% out.println("Ciudad <input type=\"text\" name=\"ciudad\" maxlength=\"20\" value=\"" + request.getParameter("ciudad") + "\"> <br>"); %>
            <% out.println("Pais <input type=\"text\" name=\"pais\" maxlength=\"20\" value=\"" + request.getParameter("pais") + "\"> <br>"); %>
            <% out.println("Estudios <input type=\"text\" name=\"estudios\" maxlength=\"15\" value=\"" + request.getParameter("estudios") + "\"> <br>"); %>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
