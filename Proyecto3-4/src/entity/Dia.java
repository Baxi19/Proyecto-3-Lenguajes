/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import patterns.Decorador;
import patterns.Factory;

/**
 *
 * @author Baxi
 */
public class Dia  implements Factory, Decorador{
    private int id;
    private String dia;

    public Dia() {
    }

    public Dia(int id, String dia) {
        this.id = id;
        this.dia = dia;
    }
    
    public Dia(String dia) {
        this.id = id;
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Dia{" + "id=" + id + ", dia=" + dia + '}';
    }

    
    
    @Override
    public String getClase() {
        return "Dia";
    }

    @Override
    public String getHecho() {
        return  "dia('"+
                    getDia()+
                "').\n";
    }

    
    
}
