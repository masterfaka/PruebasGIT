/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionbdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class AccesoFichero {
    
      /*  static ArrayList<Contaminacion> obtenerDatos() {
       ArrayList<Contaminacion> a=new ArrayList<>();
       File arch=new File("C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\ContaminacionBdd\\contaminacion.csv");
        try {
            FileReader fr= new FileReader(arch);
            BufferedReader br= new BufferedReader(fr);
            String Linea=br.readLine();
            //la primera linea se lee 2 veces por ser CSV!!
            while (Linea!=null) {  
                 
                 String[] aux= Linea.split(";");
            /*   c.setEstacion(aux[2]);
                 c.setMagnitud(aux[3]);
                 c.setAno(aux[5]);
                 c.setMes(aux[6]);
                 c.setDia(aux[7]);
            /
                 ArrayList<String> datos_aux=new ArrayList<>();
                 for (int i = 8; i < aux.length; i=i+2) {//esto se podria acer aparte ller stringValores
                     //se leen de a 2 pork solo los ke llevan v valen aunke sea 0
                     datos_aux.add(aux[i]);     
                 }
                 Contaminacion c= new Contaminacion(aux[0],aux[1],aux[2], aux[3],aux[4],aux[5],aux[6],aux[7],datos_aux);
                 // objeto se contruye con constructor siempre
                 a.add(c);
                 Linea=br.readLine();
            }          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
       return a;
    }*/


    static ArrayList<String> leerIndices() {
       ArrayList<String> a=new ArrayList<>();
        File arch=new File("C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\ContaminacionBdd\\contaminacion.csv");
            try {
                FileReader fr=new FileReader(arch);
                BufferedReader br = new BufferedReader(fr);
                String linea=br.readLine();
                String[] campo=linea.split(";");
                for (int i = 0; i < campo.length; i++) {
                    if (i>7 &&(i%2!=0)) {//posiciones impareas mayor ke 7
                        //no hacer na
                    }else{
                        a.add(campo[i]);
                    }
                    
                }                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       return a;
    }

    static ArrayList<Contaminacion> leerDatos() {
          ArrayList<Contaminacion> lista=new ArrayList<>();

        File arch=new File("C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\ContaminacionBdd\\contaminacion.csv");
            try {
                FileReader fr=new FileReader(arch);
                BufferedReader br = new BufferedReader(fr);
                String linea=br.readLine();
                while (linea !=null) {
                        String[] campo=linea.split(";");
                        //leer datos contaminacioncampos8-fin
                        ArrayList<String> aux_datos=new ArrayList<>();
                        for (int i = 8; i < campo.length; i++) {
                             aux_datos.add(campo[i]);
                        }
                        //contruimos el obj
                        Contaminacion c=new Contaminacion(campo[0], campo[1], campo[2], campo[3], campo[4], campo[5], campo[6], campo[7], aux_datos);
                        //añadimos a lista
                        lista.add(c);
                        //volvemos a leer linea
                        linea=br.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       return lista;
    }
    
}
