/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class Alumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion=EntradaSalida.mostrarMenu();
        ArrayList<Alumno> lista=new ArrayList<>();
        while(opcion!=3){
            switch (opcion) {
                case 1://insertar
                    Alumno  a=EntradaSalida.leerAlumno();
                    lista.add(a);
                    
                    
                    break;
                case 2://listar
                    //obtener lista
                   lista= AccesoArchivo.obtenerAlumnos();
                    //imprimir lista
                   EntradaSalida.imprimirAlumnos(lista);
                    break;
                default:
                    System.out.println("Elige bien");;
            }
            
            opcion=EntradaSalida.mostrarMenu();
        }
        AccesoArchivo.grabarAlumnos(lista);
    }
    
}
