<%-- 
    Document   : comfirmacompra
    Created on : 19-dic-2018, 10:28:26
    Author     : Mañanas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="session.Producto"%>
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
            
            ArrayList<Producto> listaC=(ArrayList<Producto>)session.getAttribute("listaC");
             //para ke no pete hay ke setear la lista compra vacia, AL PRINCIPIO        
          String usuario=(String)session.getAttribute("usuario");
          %>
        <h1>Hello usuario:<%=usuario%>!has comprado:<%=listaC.size()%> elementos</h1>
        <table border="1" align="center">
            <tr><th>Producto </th>
                    <th>precio</th>
                    <th>Stock restante</th>
            </tr>
           <% for (int i = 0; i < listaC.size(); i++) {
                Producto p= listaC.get(i);
                 
          %>
           <tr> 
               <td>       <%=p.getNombre()%></td>
                <td><%=p.getPrecio()%></td>
                <td><%=(p.getStock()-1)%><%//actualizamos valor de stock y el prducto en la lista en sesion%>
                <% //listaC.get(i).setStock((p.getStock()-1));
                    //lo mejor de esto es cambiarlo directo a la BDD y asi al sacarlo sale el valr atualizado siempre.
                    //ahora faltaria cambiar el valor en la BDD o al confirmar la compra
                    //pero de momento lo recordaremos en la sesion
                  //  session.setAttribute("listaC", listaC);
                    
                %>
                </td>
            </tr>
         <%     
            }
        %>
        
        </table>
        <button class="w3-button w3-teal w3-display-middle" ><a href="index.jsp">Volver Inicio</a></button>
    </body>
</html>
