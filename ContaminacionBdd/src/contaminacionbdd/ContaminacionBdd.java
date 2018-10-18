/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionbdd;

import java.util.ArrayList;

/**
 *
 * pasar de un CSV a una bdd los datos
 */
public class ContaminacionBdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> camposTabla=AccesoFichero.leerIndices();
        AccesoBdd.crearTabla(camposTabla);
        ArrayList<Contaminacion> lista   =AccesoFichero.leerDatos();
     //   AccesoBdd.rellenarTabla(lista);
        
    }
    
}
