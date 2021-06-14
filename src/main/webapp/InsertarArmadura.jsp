<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nueva Armadura</title>
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
        <form method="post" action="/StarkIndustries/Armadura">
            <input type="hidden" name="option" value="1">
            Numero de serie <input type="text" name="numSerie">
            Modelo <input type="text" name="modelo">
            Diseño <input type="file" name="diseno"> <br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
