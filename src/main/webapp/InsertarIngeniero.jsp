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
    <header>
        <a href="index.html"></a>
    </header>
    <nav class="navbar">
        <ul>
            <li><a href="index.html">Inicio</a></li>
            <li>Comprar</li>
            <li><a href="/StarkIndustries/Ingeniero">Empleados</a></li>
            <li><a href="/StarkIndustries/Fabricante">Proveedores</a></li>
            <li>Conviertete en distibuidor</li>
        </ul>
    </nav>
    <div class="mainbody">
        <form method="post" action="/StarkIndustries/Ingeniero">
            <input type="hidden" name="option" value="1">
            Cedula Profesional <input type="text" name="cedula"> <br>
            Nombre <input type="text" name="nombre"> <br>
            Primer apellido <input type="text" name="primerApellido"> <br>
            Segundo apellido <input type="text" name="segundoApellido"> <br>
            Telefono <input type="text" name="telefono"> <br>
            Calle <input type="text" name="calle">
            Numero <input type="text" name="numero"> <br>
            Codigo Postal <input type="text" name="codigoPostal"> <br>
            Ciudad <input type="text" name="ciudad"> <br>
            Pais <input type="text" name="pais"> <br>
            Estudios <input type="text" name="estudios"> <br>
            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>
