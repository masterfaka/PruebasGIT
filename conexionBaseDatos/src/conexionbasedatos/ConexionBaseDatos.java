/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Mañanas
 */
public class ConexionBaseDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendasalzillo?serverTimezone=UTC", "root","");
            //syntax :: ruta/DB(selepasa por get `pork peta) , user, password;
            Statement st=c.createStatement();

            
            ResultSet rs=st.executeQuery("SELECT * From persons");
            //se guardan en una variable los results(records con varis campos)
            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));//nombres de los campos
                System.out.println(rs.getString("descripcion"));
                System.out.println(rs.getString("precio"));
            
            }

            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
            //com.mysql.cj.jdbc.Driver.

                    
    }
    
}
