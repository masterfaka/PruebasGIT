<%-- 
    Document   : openweaterJSONjscript
    Created on : 22-ene-2019, 10:04:16
    Author     : Mañanas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		        <link rel="stylesheet" href="stylo.css">
				<script src="js/funciones.js"></script>
        <title>Json parse Jscript</title>
    </head>
    <body onLoad="cargarOyentes()">
        <h1>Parsear Json</h1>
        <select name ="ciudad" id="cuidad">
            <option value="0">Selecciona ciudad</option>
            <option value="Madrid">Madrid</option>
            <option value="mostoles">Mostoles</option>
            <option value="toledo">toledo</option>
            <option value="Valencia">Valencia</option>
        </select>
        <table id="tabla" class="w3-table w3-centered w3-bordered w3-hoverable" >
            <tr>
                <th>Ciudad</th><th>Max</tH><th>Min</tH>
            </tr>     
            
        </table>
    </body>
</html>
