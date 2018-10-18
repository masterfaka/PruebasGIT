/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionbdd;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class Contaminacion {
    private String Prov, Municipio,est,magnitud, punto, ano, mes,dia;
    private ArrayList<String> datos;

    public Contaminacion(String Prov, String Municipio, String est, String magnitud, String punto, String ano, String mes, String dia, ArrayList<String> datos) {
        this.Prov = Prov;
        this.Municipio = Municipio;
        this.est = est;
        this.magnitud = magnitud;
        this.punto = punto;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.datos = datos;
    }

   /* @Override
    public String toString() {
        String txt="( ' "+Prov+" ', ' "+Municipio+" ', ' "+est+" ', ' "+magnitud+" ', ' "+punto+" ', ' "+ano+" ', ' "+mes+" ', ' "+dia+" '  ";
        for (int i = 0; i < datos.size(); i++) {
            txt+=" ,' "+datos.get(i)+" '    ";
            
        }
        txt+=")";
        return txt; //To change body of generated methods, choose Tools | Templates.
    }*/

    public void setProv(String Prov) {
        this.Prov = Prov;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    public String getProv() {
        return Prov;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public String getEst() {
        return est;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public String getPunto() {
        return punto;
    }

    public String getAno() {
        return ano;
    }

    public String getMes() {
        return mes;
    }

    public String getDia() {
        return dia;
    }

    public ArrayList<String> getDatos() {
        return datos;
    }
    
    
}
