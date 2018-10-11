/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presupuestoreforma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoFichero {
private  static String ruta="C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\PresupuestoReforma";
private static String arch="\\presupuesto.csv";
private static String separador=",";

 
    static void grabarAccion(Accion a) {
       
        try {
            FileWriter fr=new FileWriter((ruta+arch), true);
            String texto=a.getNombre()+separador+a.getPrecio(); //accion, precio \n
            fr.write(texto);
            fr.write("\n");
             fr.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ArrayList<Accion> getAcciones() {
           ArrayList<Accion> l=new ArrayList<>();
           FileReader fr;
            try {
                fr = new FileReader(ruta+arch);
               BufferedReader br =new BufferedReader(fr);
               String linea= br.readLine();
                while (linea!=null) {
                    Accion a= new Accion();  
                    String[] campo=linea.split(separador);
                     a.setNombre(campo[0]);//1er campo =nombre 2=precio
                     a.setPrecio(Integer.parseInt(campo[1]));//parseamos por ser string pero sabemos ke es int fijo
                      l.add(a);
                      linea= br.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
            }  
         return l;
    }
    
}
