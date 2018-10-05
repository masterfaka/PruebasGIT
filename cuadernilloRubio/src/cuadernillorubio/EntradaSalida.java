/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mañanas
 */
class EntradaSalida {
           private static final Scanner sc=new  Scanner(System.in);
    static int mostrarMenu() {
       int opcion;

        System.out.println("Elige opcion(1-4):");
        System.out.println("1.Sumar");
        System.out.println("2.Restar");
        System.out.println("3.Multiplicar");
        System.out.println("4.Salir");
        opcion= sc.nextInt();       
        return opcion; 
    }

    static int preguntarCuantas() {
        System.out.println("Cuantas operaciones");
        int c=sc.nextInt();
      //  sc.nextLine();
        return c;
    }

    static String preguntarNombre() {
        System.out.println("Dame un nombre");
        String s=sc.nextLine();
        return s;
    }

    static int mostrarOperacion(Operacion o) {
   

        //        sc.nextLine();
        System.out.print("Operacion: "+o.getS1()+o.getSigno()+o.getS2()+"= ");
                 int resultadoCliente=sc.nextInt();
        return resultadoCliente;//To change body of generated methods, choose Tools | Templates.
    }

    static void darEnhorabuena(String n) {
            System.out.println("Enhorawena "+n+"!!!");
    }

    static void exportarResultados(int a, int b, String s) {
        File arch=new File("C:\\IFCT0609\\NetBeans 8.2\\EjerciciosClase\\Clases-Java\\cuadernilloRubio\\resultados.txt");
               try {
                   FileWriter fr=new FileWriter(arch, true);
                   String linea=s+", ha hecho:"+a+" intentos; y "+b+" aciertos.";
                   fr.write(linea+" \n ");
                   fr.close();
                   System.out.println("Bybye done");
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
    
}
