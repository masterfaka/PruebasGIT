/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
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
    static String url="jdbc:mysql://localhost:3306/ejcontaminacion?serverTimezone=UTC";

    static void crearTabla(ArrayList<String> camposTabla) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection(url,usuario, password);
            Statement st=c.createStatement();
            String query="CREATE TABLE IF NOT EXISTS contaminacion";
            query+=" (  "+camposTabla.get(0)+" varchar(50)";//empezamos luego en el 1 por la coma
            for (int i = 1; i < camposTabla.size(); i++) {
                query=query+","+camposTabla.get(i) +" varchar(50)";
            }
            query+=")";
            System.out.println(query);
            st.executeUpdate(query);
            
            
            st.close();
            c.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    static void rellenarTabla(ArrayList<Contaminacion> lista) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection(url,usuario, password);
            Statement st=c.createStatement();
            for (int i = 0; i < lista.size(); i++) {
                 String query="INSERT INTO contaminacion VALUES";
                 Contaminacion cont=lista.get(i);
                 query+="("
                         + "    ' "+cont.getProv()+" ' "
                         + "'"+cont.getMunicipio()+" '"
                         + "'"+cont.getEst()+" '"
                         + "'"+cont.getMagnitud()+" '"
                         + "'"+cont.getPunto()+" '"
                         + "'"+cont.getAno()+" '"
                         + "'"+cont.getMes()+" '"
                         + "'"+cont.getDia()+" '"
                         + ") ";
                 st.executeUpdate(query);
                 
            }
           


           // System.out.println(query);
            st.close();
            c.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }


    
}
