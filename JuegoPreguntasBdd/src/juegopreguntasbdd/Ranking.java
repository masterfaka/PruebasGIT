/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopreguntasbdd;

/**
 *
 * @author Mañanas
 */
public class Ranking {
    private String nombre;
    private int puntuacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
   public static int obtenerPuntuacion(int a, int  t){
       //se calcula subtotal sobre 100
       int P=a/t*100;
       return P;
   } 
}
