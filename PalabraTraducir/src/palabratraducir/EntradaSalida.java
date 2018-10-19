/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabratraducir;

import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
public class EntradaSalida {
    private static Scanner sc= new Scanner(System.in);
    static int mostrarMenu(String[] Opciones) {
            System.out.println("Elige una opcion(1-3): ");
        for (int i = 0; i < Opciones.length; i++) {
            System.out.println(Opciones[i]);
        }
        int J=sc.nextInt();
        sc.nextLine();
        return J;
    }

    static Palabra preguntarPalabra() {
        System.out.println("introduce palabra en Epañol:");
        String Esp= sc.nextLine();
        System.out.println("Introduce palabra en Ingles:");
        String eng=sc.nextLine();
        Palabra p= new Palabra(eng, Esp);
        return p;
    }

    static int mostrarEleccion(String[] OpcionesIdiomas) {
        System.out.println("Elige:");
        for (int i = 0; i < OpcionesIdiomas.length; i++) {
            System.out.println(OpcionesIdiomas[i]);
        }
        int J=sc.nextInt();
        sc.nextLine();
        return J;
    }

    static String preguntarIngles() {
        System.out.println("Introduce palabra en Ingles:");
        String s=sc.nextLine();
        return s;
    }

    static String preguntarEsp() {
        System.out.println("Introduce palabra Español");
        String s= sc.nextLine();
        return s;
    }

    static void mostrarP(String pEspanol) {
        System.out.println("tu palabra traducida es: "+pEspanol);
    }
    
}
