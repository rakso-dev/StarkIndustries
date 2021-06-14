<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo cliente</title>
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
        <form method="post" action="/StarkIndustries/Cliente">
            <input type="hidden" name="option" value="1">
            RFC <input type="text" name="rfc"> <br>
            Nombre <input type="text" name="nombre"> <br>
            Primer apellido <input type="text" name="apellido1"> <br>
            Segundo apellido <input type="text" name="apellido2"> <br>
            Telefono <input type="text" name="telefono"> <br>
            Direccion <input type="text" name="calle" placeholder="Calle">
            <input type="text" name="numero" placeholder="Numero"> <br>
            <input type="text" name="cp" placeholder="Codigo postal"> <br>
            <input type="text" name="ciudad" placeholder="Ciudad"> <br>
            <input type="text" name="pais" placeholder="Pais">
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
