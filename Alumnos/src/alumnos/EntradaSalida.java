/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
public class EntradaSalida {  
    private static Scanner sc= new Scanner(System.in);
    static int mostrarMenu(){

        System.out.println("Elige(1-3):");
        System.out.println("1.Insertar Alumno");
        System.out.println("2.Listar Alumnos");
        System.out.println("3.salir");
       
        int i=sc.nextInt();
        sc.nextLine();//pork nos conocemos y keremos ke no se kede esperando bug¿!¿!¿!¿
        return i;
    
    }

    static Alumno leerAlumno() {
        System.out.println("introduce Nombre:");
        Alumno a=new Alumno();
        a.setNombre(sc.nextLine());
                System.out.println("introduce Nota:");
        a.setNota(sc.nextInt());
        sc.nextLine();//para ke no pete con int
        return a;
    }

    static void imprimirAlumnos(ArrayList<Alumno> lista) {

        for (int i = 0; i <lista.size(); i++) {
          Alumno  a=lista.get(i);
            System.out.println("Alumno:"+a.getNombre()+" nota= "+a.getNota());
        }
    }
    
}
