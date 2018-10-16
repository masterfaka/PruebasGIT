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
 *      para concatenar variables y querys como siempre USAR BIEN comillas simples doble string etc
 * 
 *      PARA recuperar SE USAEXECUTEQuery y para insertar Execute Update
 * 
 * 
 */
public class ConexionBaseDatos {

    /**
     * @param args the command line arguments
     * la clase conexion no imprime
     * 
     * menu insertar listar/ buscar contactos
     * 
     * 
     *  sql:
     * 
     * CREATE TABLE Contactos (
    tel int,
    nombre varchar(255),
    apll varchar(255)
);
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendasalzillo?serverTimezone=UTC", "root","");
            //syntax :: ruta/DB(selepasa por get `pork peta) , user, password;
            Statement st=c.createStatement();
            String[] opciones={"1-Insertar Contacto","2-Listar Contactos","3-Buscar por nombre","4-Salir"};
            int opcion=EntradaSalida.mostrarMenu(opciones);
            while(opcion!=4){
                switch (opcion) {
                    case 1://insertar
                        Contacto contacto= new Contacto();
                        contacto=EntradaSalida.obtenerContacto();
                        
                        //comillas simples para el query a las variables ke son strings
                        //cuidado con la diferencia entre execUpdate y query
                       String query=" INSERT INTO contactos "
                                + "VALUES ( "+contacto.getTel()+" ,' "+contacto.getNombre()+" ', ' "+contacto.getNombre()+" ') ";
                       st.executeUpdate(query);

                        st.close();
                                                
                        break;
                   case 2://listar
                        Contacto auxA= new Contacto();
                        String queryContatos="SELECT * FROM contactos";
                        ResultSet rs=st.executeQuery(queryContatos);
                         while (rs.next()) {
                             auxA.setApellido(rs.getString("apll"));
                             auxA.setNombre(rs.getString("nombre"));
                             auxA.setTel(rs.getInt("tel"));
                             System.out.println(auxA.toString());
                       }
                         rs.close();
                        
                        break;
                   case 3://filtrar por name
                       String nombreBuscado=EntradaSalida.obtenerN();
                        Contacto auxb= new Contacto();
                        String queryBuscarN="SELECT * FROM contactos WHERE 'nombre'==' "+nombreBuscado+" ' ";
                        ResultSet rs2=st.executeQuery(queryBuscarN);
                         while (rs2.next()) {
                             auxb.setApellido(rs2.getString("apll"));
                             auxb.setNombre(rs2.getString("nombre"));
                             auxb.setTel(rs2.getInt("tel"));
                             System.out.println(auxb.toString());
                       }
                         rs2.close();
                        
                        break;
                    default:
                           System.out.println("Opcion incorecta introduce otravez");;
                }
               c.close();
            opcion=EntradaSalida.mostrarMenu(opciones);
            }
            
         /*       
            ResultSet rs=st.executeQuery("SELECT * From persons");
            //se guardan en una variable los results(records con varis campos)
        
            //mostrar db productos full
            while(rs.next()){
                System.out.println(rs.getString("nombre"));//nombres de los campos
                System.out.println(rs.getString("descripcion"));
                System.out.println(rs.getString("precio"));
            
            }
*/
            
          //recordar siempre cerrarlos  
        c.close();
        st.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
            //com.mysql.cj.jdbc.Driver.

                    
    }
    
}
