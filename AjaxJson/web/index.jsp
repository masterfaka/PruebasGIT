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
				<script src="js/funciones.js"></script>
        <title>Json parse Jscript</title>
    </head>
    <body onLoad="cargarOyente()">
        <h1>Parsear Json+ buskeda ajax</h1>
        se mAnda con ajax al servlet y de ahi todo lo demas
        <input type="text" id="buskeda"/>
   <!--     
        <select name ="ciudad" id="cuidad" class="w3-select" size="5">
            <option value="0" disabled selected>Selecciona ciudad</option>
            <option value="Madrid">Madrid</option>
            <option value="mostoles">Mostoles</option>
            <option value="toledo">toledo</option>
            <option value="Valencia">Valencia</option>
        </select>
 
        <table id="tabla" class="w3-table w3-centered w3-bordered w3-hoverable w3-teal" >
            <tr>
                <th>Ciudad</th><th>Max</tH><th>Min</tH>
            </tr>     
            
        </table>
   -->
   <ul id="lista">
       
       
       
   </ul>
    </body>
</html>
