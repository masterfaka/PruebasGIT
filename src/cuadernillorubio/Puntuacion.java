/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;

/**
 *
 * @author luis
 */
public class Puntuacion {
    private String nombre;
    private int aciertos, totales;

    public Puntuacion(String nombre, int aciertos, int totales) {
        this.nombre = nombre;
        this.aciertos = aciertos;
        this.totales = totales;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getTotales() {
        return totales;
    }
    
}
