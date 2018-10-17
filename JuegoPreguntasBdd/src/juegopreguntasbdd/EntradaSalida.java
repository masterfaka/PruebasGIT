/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopreguntasbdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
class EntradaSalida {
    private static Scanner sc=new Scanner(System.in);

    static int mostrarMenu(String[] op) {//menu elegante
        for (int i = 0; i < op.length; i++) {
            System.out.println(op[i]);            
        }
  
        int i=sc.nextInt();
          sc.nextLine();
          return i;
    }

    static Pregunta leerPregunta() {
        Pregunta p= new Pregunta();
        System.out.println("introduce enunciado Pregunta:");
        p.setPregunta(sc.nextLine());
        String[] respuestas=new String[p.getRespuestas().length]; 
        for (int i = 0; i < p.getRespuestas().length; i++) {
         
            System.out.println("introduce respuesta "+i+" :");
          respuestas[i]=sc.nextLine();
        }
        p.setRespuestas(respuestas);//guardamos las respuestas
        System.out.println("Introduce Opcion Correcta");
        p.setCorrecta(sc.nextInt());
        sc.nextLine();//para ke no descuadre
        
        return p;
    }

    static String preguntarNombre() {
        System.out.println(" introduce tu nombre:");
        String s=sc.nextLine();
        return s;
    }

    static void mostrarRanking(ArrayList<Ranking> lista) {
     for (int i=0; i<lista.size(); i++)
     {
        Ranking r= lista.get(i);       
         System.out.println(r.getNombre()+"........."+r.getPuntuacion());
     }

    }
    
}
