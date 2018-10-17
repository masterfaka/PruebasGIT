/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopreguntasbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoBdd {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/juegopreguntas?serverTimezone=UTC";

    static void crearTablaPregunta() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver
            String query="CREATE TABLE IF NOT EXISTS preguntas\n" +
"(\n" +
"enunciado varchar(250),\n" +
"    resp0 varchar(50),\n" +
                    "    resp1 varchar(50),\n" +
                    "    resp2 varchar(50),\n" +
                    "    resp3 varchar(50),\n" +
"    correcta int \n" +
"    \n" +
");";
            try {
                Connection c=DriverManager.getConnection(url, usuario, password);
                // query="INSERT INTO preguntas VALUES("+p.getPregunta()+" ,"+p.getRespuestas()[0]+" ,"++" ,"++")";
                Statement st= c.createStatement();
                  st.executeUpdate(query);
                  st.close();
                  c.close();
                  //con tabla creada procedemos
            } catch (SQLException ex) {
                Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void crearTablaRanking() {
        /*   Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver   no 2 veces*/
        String query="CREATE TABLE IF NOT EXISTS Ranking\n" +
                "(\n" +
                "nombre varchar(250),\n" +
                "    puntuacion int" +
                ");";
        try {
            Connection c=DriverManager.getConnection(url, usuario, password);
            // query="INSERT INTO preguntas VALUES("+p.getPregunta()+" ,"+p.getRespuestas()[0]+" ,"++" ,"++")";
            Statement st= c.createStatement();
            st.executeUpdate(query);
            st.close();
            c.close();
            //con tabla creada procedemos
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    static ArrayList<Ranking> obtenerRanking() {
        //obtener la lista de rankings
        ArrayList<Ranking> l= new ArrayList<>();
        try {
            Connection c=DriverManager.getConnection(url, usuario, password);
            String query="SELECT * FROM ranking ORDER BY DESC;";
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
                Ranking r= new  Ranking();
                r.setNombre(rs.getString("nombre"));
                r.setPuntuacion(rs.getInt("puntuacion"));//sacamos los valores
                //añadimos a la lista
                l.add(r);
            }
            //aki habra ke cerrar tmbn
            st.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return l;
    }

    static void guardarRanking(String usr, int punt) {
        try {
            Connection c=DriverManager.getConnection(url, usuario,password);
            String query="INSERT INTO ranking VALUES";
            Statement st=c.createStatement();
            query+="(' "+usr+"   ',  "+punt+" )";//puntuacion es int y no lleva comillas simple ?
            st.executeUpdate(query);
            System.out.println(query);
            st.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
