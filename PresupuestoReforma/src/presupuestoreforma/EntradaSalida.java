/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presupuestoreforma;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
class EntradaSalida {
    private static Scanner sc=new Scanner(System.in);

    static int mostrarMenu(String[] opciones) {
        System.out.println("Elige OPcion(1--"+opciones.length+"):");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(opciones[i]);
        }
        int aux=0;
        try {
        int i=sc.nextInt();
        sc.nextLine();
        aux=i;        
        }catch(InputMismatchException e){
            System.out.println("Introduce un numero entero!");
        }
      
        return aux;
    }

    static Accion preguntarAccion() {
        Accion a=new Accion();
        System.out.println("Introduce Accion:");
         a.setNombre(sc.nextLine());
         System.out.println("Introduce Precio:");
         //leer como string y pasarlo a int resuelve el posible Input mismatch a no ser ke se introduzcan chars
         a.setPrecio(Integer.parseInt(sc.nextLine()));
                
        return a;
    }

    static void mostrarAcciones(ArrayList<Accion> lista) {
        for (int i = 0; i < lista.size(); i++) {
             System.out.println(lista.get(i).toString());
        }
    }

    static void mostarFIVA(ArrayList<Accion> lista) {
        int suma, TotalIva;
        suma=0;
        for (int i = 0; i < lista.size(); i++) {
            suma=suma+lista.get(i).getPrecio();
        }
        TotalIva= suma+ (suma*(21)/100);
        System.out.println("Total con IVA:"+TotalIva);
    }

    static void mostrarFsinIva(ArrayList<Accion> lista) {
                  int suma=0;
        for (int i = 0; i < lista.size(); i++) {
            suma=suma+lista.get(i).getPrecio();
        }
        System.out.println("Total Sin IVA:"+suma);  
    }
    
}
