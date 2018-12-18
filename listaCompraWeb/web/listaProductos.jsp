<%-- 
    Document   : listaProductos
    Created on : 17-dic-2018, 13:40:59
    Author     : Mañanas
--%>

<%@page import="session.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Producto> lista=(ArrayList<Producto>)request.getAttribute("lista");
            ArrayList<Producto> listaC=(ArrayList<Producto>)session.getAttribute("listaC");
             //para ke no pete hay ke setear la lista compra vacia, AL PRINCIPIO        %>
      <h1>llevas comprados:<%=listaC.size() %></h1>   
        aki en cada link mandamos como accion comprar para que el servlet sepa
        pintamos con java la tabla    
        <%for (int i = 0; i < lista.size(); i++) {
                Producto p= lista.get(i);
                
          %>
          
          <button class="w3-button w3-blue w3-block"><a href="ServletSession?id=<%=p.getId()%>&accion=comprar"><%=p.getNombre()%></a></button>
          <%     
            }
        %>
        
        
        
        
    </body>
</html>
