<%-- 
    Document   : index
    Created on : 17-dic-2018, 12:48:31
    Author     : Mañanas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            String vista="hidden";
             String vista_F="visible";
        String usuario=(String) session.getAttribute("usuario");
        if(usuario==null){
            //no hacer nada
        }else{//mostrar
            vista="visible";
            vista_F="hidden";
        }
       
    
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="ServletSession" action="POST" Style="visibility:<%=vista_F%>">
             <input type="text" name="usuario" placeholder="usuario"/><br>
            <input type="password" name="contra" placeholder="contraseña">
            <input type="hidden" name="accion" value="comprobar">
            <input type="submit" value="comprobar" >
        </form>
        <form action="ServletSession" method="POST">
                
            

            <input type="hidden" name="accion" value="listar">
            <input type="submit" value="Comprar" class="w3-button w3-blue w3-display-middle" Style="visibility:<%=vista%>">
          <!--  <button class="w3-button w3-blue w3-display-middle"	><a href="index.jsp">volver</a></button>-->
       </form>
    </body>
</html>
