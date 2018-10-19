/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabratraducir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoBdd {
    private static String usuario="root";
    private static String password="";
    private static String url="jdbc:mysql://localhost:3306/Palabratraducir?serverTimezone=UTC";

    static void insertarPalabra(Palabra p) {
        String query_creart="CREATE TABLE  if not exists diccionario" 
               + "( ingles varchar(50), espanol varchar(20) )";
        String query_insertar="INSERT INTO diccionario VALUES(' "+p.getIngles()+" ' , ' "+p.getEspanol()+" ')";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver
                   Connection c= DriverManager.getConnection(url,usuario, password);
                   Statement st= c.createStatement();
                  //ejecutamos querys
                   st.executeUpdate(query_creart);
                   st.executeUpdate(query_insertar);
                   //cerramos conectores
                   st.close();
                   c.close();
                      

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }

 
    }

    static String traducirIngles(String p) {
        String query=" SELECT * FROM diccionario WHERE ingles ='"+p+" ' ";
        String S="";
        try {
            Connection c= DriverManager.getConnection(url,usuario, password);
            Statement st= c.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
                 S= rs.getString("espanol");//cogemos la palabra española cuando traducimos del inggles
            }
            st.close();
        c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return S;
    }

    static String traducirEspanol(String pEsp) {
                String query=" SELECT * FROM diccionario WHERE espanol ='"+pEsp+" ' ";
        String S="";
        try {
            Connection c= DriverManager.getConnection(url,usuario, password);
            Statement st= c.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
                 S= rs.getString("ingles");//cogemos la palabra inglesa cuando traducimos del español
            }
            st.close();
        c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return S;
    }
    
}