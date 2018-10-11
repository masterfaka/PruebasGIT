/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.io.BufferedReader;
import java.io.File;
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
class AccesoArchivo {
    private static String ruta="C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\Alumnos\\alumnos.csv";
   private static String separador=",";
    
    static void grabarAlumnos(ArrayList<Alumno> lista) {
        File arc=new File(ruta);
        try {
            FileWriter fr =new FileWriter(arc, true);
            for (int i = 0; i < lista.size(); i++) {
                Alumno a=lista.get(i);
                 fr.write(a.getNombre()+separador+a.getNota()); 
                 fr.write("\n");
            }
           
            fr.close();
            
        } catch (IOException ex) {
            Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    static ArrayList<Alumno> obtenerAlumnos() {
       ArrayList<Alumno> lista= new ArrayList<>();
       File arch=new File(ruta);
        try {
            FileReader fr= new FileReader(arch);
            BufferedReader br= new BufferedReader(fr);
            String linea=br.readLine();
            while (linea!=null) {
                String[] campo=linea.split(separador);
                Alumno a =new Alumno();
                a.setNombre(campo[0]);
                a.setNota(Integer.parseInt(campo[1]));
                
                lista.add(a);
                linea=br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return lista;
    }
    
}
