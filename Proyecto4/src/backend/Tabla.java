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
    protected String sql;
    protected ArrayList<String> atributos;
    protected ArrayList<String> datos;

    public Tabla(String sql) {
        this.sql = sql;
        this.atributos = new ArrayList<>();
        this.datos = new ArrayList<>();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
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
        return "Tabla{" + "sql=" + sql + ", atributos=" + atributos + ", datos=" + datos + '}';
    }
    
    
    
}
