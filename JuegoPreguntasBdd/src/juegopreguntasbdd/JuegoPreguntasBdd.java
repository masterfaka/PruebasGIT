/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopreguntasbdd;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class JuegoPreguntasBdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int puntuacion, totales, aciertos;
       puntuacion=0;
       aciertos=0;
       totales=0;
        String[] opciones={"1-Insertar Pregunta","2-Jugar", "3-Ver Ranking","4-Salir" };
       int opcion=EntradaSalida.mostrarMenu(opciones);
        while (opcion!=4) {
            switch (opcion) {
                case 1: //insertar pregunta
                   Pregunta p= EntradaSalida.leerPregunta();
                   AccesoBdd.crearTablaPregunta();
                   AccesoBdd.crearTablaRanking();
                //  AccesoBdd.guardarPregunta(p);
                    
                    break;
                case 2: //jugar
                    String usr=EntradaSalida.preguntarNombre();
                    
           /*         Pregunta pregunta=AccesoBdd.obtenerPregunta();
                    int respuesta=EntradaSalida.leerResp();
                    if (respuesta==pregunta.getCorrecta()) {
                        aciertos++;
                        totales++;
                    }else{
                        AccesoBdd.guardarPuntuacion();
                    }

        */  
                    int punt=Ranking.obtenerPuntuacion(aciertos, totales);
                    AccesoBdd.guardarRanking(usr, punt);
                    break;
                case 3: //mostra r ranking
                            ArrayList<Ranking> lista=AccesoBdd.obtenerRanking();
                            EntradaSalida.mostrarRanking(lista);
                    break;
                default://salir, opcion incorrecta
                    break;
            }
            
            opcion=EntradaSalida.mostrarMenu(opciones);
            
        }
       
       
    }
    
}
