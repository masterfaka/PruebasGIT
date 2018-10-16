/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
class EntradaSalida {
    static private Scanner sc=new Scanner(System.in);

    static int mostrarMenu(String[] opciones) {
        int i=0;
        System.out.println("Introduce tu opcion(1-4)");
        for (int j = 0; j < opciones.length; j++) {
            System.out.println(opciones[j]);
        }
        i=sc.nextInt();
        sc.nextLine();
        return i;
    }

    static Contacto obtenerContacto() {
        Contacto c= new Contacto();
        System.out.println("pon nombre");
        c.setNombre(sc.nextLine());
        System.out.println("pon apellidos");
        c.setApellido(sc.nextLine());
        System.out.println("pon telefono");
        c.setTel(sc.nextInt());
        sc.nextLine();
        return c;
    }

    static String obtenerN() {
        System.out.println("Introduce Nombre Buscado:");
        String n=sc.nextLine();
        return n;
    }
    
}
