<%-- 
    Document   : index
    Created on : 21-dic-2018, 12:21:55
    Author     : Mañanas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>JSP Page</title>
    </head>
    <body>
        <% String saludo="";
        boolean ok=Boolean.parseBoolean(String.valueOf(request.getAttribute("loginOk")));
        if(ok){
           // aki acemos los request pork antes no los hay
          saludo+=request.getAttribute("texto");
        }else{
        
        
        }
            
        
        %>
        <h1>Hello!</h1>
        <h2><%=saludo%></h2>
               <form action="servletConectados" method="POST">
        <fieldset>
          <legend>Insertar Libro</legend>
          Nombre:  <input name="nombre" class="w3-input w3-border w3-animate-input" type="text" style="width:40%"placeholder="Nombre">
          pass:  <input name="contra" class="w3-input w3-border w3-animate-input" type="text" style="width:40%"placeholder="contraseña">

          <input type="hidden"  name="accion" value="login">
          <input type="submit" value="Login" >
        </fieldset>
        </form>
    </body>
</html>
