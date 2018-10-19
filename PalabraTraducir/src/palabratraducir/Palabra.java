/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabratraducir;

/**
 *
 * @author Mañanas
 */
public class Palabra {
    private String ingles,espanol;

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public Palabra(String ingles, String espanol) {
        this.ingles = ingles;
        this.espanol = espanol;
    }
    
}
