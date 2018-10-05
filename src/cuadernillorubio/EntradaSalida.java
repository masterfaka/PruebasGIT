/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class EntradaSalida {
    static Scanner sc=new Scanner(System.in);
    public static int mostrarMenu()
    {
        System.out.println("Introduzca una opción:");
        System.out.println("1-Sumar");
        System.out.println("2-Restar");
        System.out.println("3-Multiplicar");
        System.out.println("4-Salir");
        int o=sc.nextInt();
        sc.nextLine();
        return o;
    }
    public static int preguntarCuantas()
    {
        System.out.println("¿Cuántas operaciones?");
        int n=sc.nextInt();
        sc.nextLine();
        return n;
    }
    public static String preguntarNombre()
    {
        System.out.println("¿Cómo te llamas?");
        String s=sc.nextLine();
        return s;
    }
    public static int mostrarOperacion(Operacion mi_operacion, String nombre)
    {
        int n1=mi_operacion.getOperando1();
        int n2=mi_operacion.getOperando2();
        char signo=mi_operacion.getSigno();//ASCII 43
        System.out.println("Responde "+nombre+":");
        System.out.println(n1+""+signo+""+n2+"=");
        int respuesta=sc.nextInt();
        return respuesta;
    }

    static void darEnhorabuena() {
        System.out.println("Muy bien");
    }
}
