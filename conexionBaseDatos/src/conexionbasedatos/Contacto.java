/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

/**
 *
 * @author Mañanas
 */
public class Contacto {
    private int tel; 
    private String nombre;
     private String apellido;

    @Override
    public String toString() {
       String text="contacto: "+nombre+", apelllido:"+apellido+" ; telefono: "+tel;
       return text;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}

