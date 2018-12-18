package session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mañanas
 */
class AcesoBD {
    /*contamos con ke la tabla y la bd estan
  creadas*/
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/ListaCompraWeb?serverTimezone=UTC";

    static ArrayList<Producto> listarP() {
        ArrayList<Producto> lista= new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver 
            Connection conex=DriverManager.getConnection(url, usuario, password);
             String query="SELECT * FROM productos";
            Statement st=conex.createStatement();
            ResultSet rs= st.executeQuery(query);
            while (rs.next()) {                
                Producto p= new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getString("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
            st.close();
            conex.close();
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AcesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return lista;
    }

    static Producto recuperarp(int id) {//recuperamos producto por id
                        Producto p= new Producto();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//cargar driver 
             Connection conex=DriverManager.getConnection(url, usuario, password);
             String query="SELECT * FROM productos WHERE id="+id;
            Statement st=conex.createStatement();
            ResultSet rs= st.executeQuery(query);
            if(rs.next()){

                p.setId(id);
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getString("precio"));
                p.setStock(rs.getInt("stock"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AcesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return p;    
    }
    
}
