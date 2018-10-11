/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class AccesoFichero {
    private static String ruta_fichero="C:\\ranking_cuadernillo\\ranking.csv";
    private static String separador=",";
    public static void grabarPuntuacion(Puntuacion puntos)
    {
        Scanner sc=new Scanner(System.in);
        boolean ruta_correcta=false;
        while(ruta_correcta==false)
        {
                System.out.println("Introduce el nombre de la carpeta");
                String nombre_carpeta=sc.nextLine();
                ruta_fichero="C:\\"+nombre_carpeta+"\\ranking.csv";
                 String texto=puntos.getNombre()+separador+puntos.getAciertos()+separador+puntos.getTotales();
                try {
                    FileWriter fw=new FileWriter(ruta_fichero, true);
                    fw.write(texto);
                    fw.write("\n");
                    fw.close();
                    ruta_correcta=true;
                    System.out.println("Datos correctamente grabados");
                } catch (IOException ex) {
                    Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Por favor, escriba de nuevo el nombre de la carpeta");
                    
                }
        }
        
    }

    static ArrayList<Puntuacion> obtenerPuntuaciones() {
    ArrayList<Puntuacion> lista=new ArrayList();
        try {
            FileReader lector=new FileReader(ruta_fichero);
            BufferedReader br=new BufferedReader(lector);
            String linea=br.readLine();
            while(linea !=null)
            {
                String[] campos=linea.split(separador);
                String nombre=campos[0];
                String aciertos=campos[1];
                String totales=campos[2];
                Puntuacion p=new Puntuacion(nombre, Integer.parseInt(aciertos),
                        Integer.parseInt(totales));
                lista.add(p);
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
