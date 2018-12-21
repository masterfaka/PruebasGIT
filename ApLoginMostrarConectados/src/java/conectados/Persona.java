/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectados;

/**
 *
 * @author Mañanas
 */
public class Persona {
    private String nombre, contra;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Persona(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }
}
