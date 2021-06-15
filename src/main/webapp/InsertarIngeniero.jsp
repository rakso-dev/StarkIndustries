<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 13/06/21
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo empleado</title>
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
        <form method="post" action="/StarkIndustries/Ingeniero">
            <input type="hidden" name="option" value="1">
            Cedula Profesional <input type="text" name="cedula" maxlength="8"> <br>
            Nombre <input type="text" name="nombre" maxlength="15"> <br>
            Primer apellido <input type="text" name="primerApellido" maxlength="20"> <br>
            Segundo apellido <input type="text" name="segundoApellido" maxlength="20"> <br>
            Telefono <input type="text" name="telefono" maxlength="10"> <br>
            Calle <input type="text" name="calle" maxlength="20">
            Numero <input type="text" name="numero"> <br>
            Codigo Postal <input type="text" name="codigoPostal" maxlength="5"> <br>
            Ciudad <input type="text" name="ciudad" maxlength="20"> <br>
            Pais <input type="text" name="pais" maxlength="20"> <br>
            Estudios <input type="text" name="estudios" maxlength="15" > <br>
            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>
