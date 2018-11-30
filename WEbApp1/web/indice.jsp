<%-- 
    Document   : newjspAki se creariaNTODOSjsp
    Created on : 30-nov-2018, 10:11:56
    Author     : Mañanas
--%>

<%@page import="provinciasBD.Provincia"%>
<%@page import="provinciasBD.AccesoBdd"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"
       %>
<% int a=9; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>has  puesto nro <%=a%>!</h1>
        <p>Para que imprima hay que sacar un valor con ese igual</p>
        <h2> Ej. select con las provincias de la BD</h2>
        <%ArrayList< Provincia> provincias=new ArrayList();
        %>
        <%provincias=AccesoBdd.recuperarProvincias();%>
        <select>
            <%for (int i = 0; i < provincias.size(); i++) {
                    %>
                    <option value=" <%=provincias.get(i).getId()%>">
                        <%=provincias.get(i).getNombre()%> </option>
               <% }
            %>
          
         </select>
    </body>
</html>
