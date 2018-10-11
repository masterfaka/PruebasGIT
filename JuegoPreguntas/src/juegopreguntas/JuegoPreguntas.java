/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopreguntas;

/**
 *
 * @author Mañanas
 */
public class JuegoPreguntas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int puntuacion, totales, aciertos;
       puntuacion=0;
       aciertos=0;
       totales=0;
        String[] opciones={"1-Insertar Pregunta","2-Jugar", "3-Salir" };
       int opcion=EntradaSalida.mostrarMenu(opciones);
        while (opcion!=3) {
            switch (opcion) {
                case 1: //insertar pregunta
                   Pregunta p= EntradaSalida.leerPregunta();
                    AccesoArchivo.guardarPregunta(p);
                    
                    break;
                case 2: //jugar
                    
                    break;
                default://salir mostrar puntuacion
                    break;
            }
            
            opcion=EntradaSalida.mostrarMenu(opciones);
        }
       
       
    }
    
}
