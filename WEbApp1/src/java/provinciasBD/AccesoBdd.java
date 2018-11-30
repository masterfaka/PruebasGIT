/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provinciasBD;

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
 * todo tiene ke iro con public sino no se ve
 */
public class AccesoBdd {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/climamunicipio?serverTimezone=UTC";
    
    public static ArrayList<Provincia> recuperarProvincias(){
        ArrayList l= new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver
               Connection c=DriverManager.getConnection(url, usuario, password);
            String query="SELECT * FROM provincias";
            Statement st=c.createStatement();
            ResultSet rs= st.executeQuery(query);
            while (rs.next()) {                
                Provincia p= new Provincia();
                p.setId(rs.getInt("id_provincia"));
                p.setNombre(rs.getString("provincia"));
                l.add(p);
            }
            st.close();
            c.close();

            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    return l;
    }
/*
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
        /*   Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver   no 2 veces
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
*/
    
 }
