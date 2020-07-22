/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import patterns.Decorador;

/**
 *
 * @author Baxi
 */
public class Dia extends Decorador{
    private int id;
    private String dia;

    public Dia() {
        super();
    }

    public Dia(String dia) {
        this.dia = dia;
    }
    
    public Dia(int id, String dia) {
        this.id = id;
        this.dia = dia;
    }
    
    public Dia(int id, String dia,  String nombreClase) {
        super(id, nombreClase);
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNombreClase() {
        return nombreClase;
    }

    @Override
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    @Override
    public String toString() {
        return "Dia{" + "id=" + id + ", dia=" + dia + '}';
    }

    
    
}
