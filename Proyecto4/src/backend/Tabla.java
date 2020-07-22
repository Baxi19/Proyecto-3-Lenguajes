/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author Baxi
 */
public class Tabla {
    protected String consulta;
    protected ArrayList<String> atributos;
    protected ArrayList<String> datos;

    public Tabla(String consulta) {
        this.consulta = consulta;
        this.atributos = new ArrayList<>();
        this.datos = new ArrayList<>();
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    
    public ArrayList<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<String> atributos) {
        this.atributos = atributos;
    }

    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "Tabla{" + "consulta=" + consulta + ", atributos=" + atributos + ", datos=" + datos + '}';
    }
    
    
    
}
