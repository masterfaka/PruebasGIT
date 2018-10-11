/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presupuestoreforma;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PresupuestoReforma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] opciones={"1-Insertar accion","2-Listar Acciones","3-Salir"};
       int opcion=EntradaSalida.mostrarMenu(opciones);
        while (opcion!=3) {//3salir
            switch (opcion) {
                case 1://insertar
                    Accion a= EntradaSalida.preguntarAccion();
                    AccesoFichero.grabarAccion(a);
                    
                    break;
                case 2://listar
                    ArrayList<Accion> lista=  AccesoFichero.getAcciones();
                    EntradaSalida.mostrarAcciones(lista);
                    EntradaSalida.mostrarFsinIva(lista);  
                    EntradaSalida.mostarFIVA(lista);
                   
                    break;
                default://tratar mismatch eception en caso de meter un string en leer
                   // System.out.println("opcion incorrecta");
                    break;
            }
        opcion=EntradaSalida.mostrarMenu(opciones);
        }
    }
    
}
