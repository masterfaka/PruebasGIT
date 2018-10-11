/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopreguntas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoArchivo {
      private static  String ruta="C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\JuegoPreguntas\\preguntas.csv";
       private static File arch=new File(ruta);
       private static String separador=",";
    static void guardarPregunta(Pregunta p) {
          try {
              FileWriter fr=new FileWriter(arch, true);
              String respuestas="";
              for (int i = 0; i < p.getRespuestas().length; i++) {
                  if (i==p.getRespuestas().length) {
                   respuestas+=p.getRespuestas()[i];    
                  }else{
                  respuestas+=p.getRespuestas()[i]+separador;}
              }
              String texto=p.getPregunta()+separador+respuestas+p.getCorrecta();
              fr.write(texto);
              fr.write("\n");
              fr.close();
          } catch (IOException ex) {
              Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}
