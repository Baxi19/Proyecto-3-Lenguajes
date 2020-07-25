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
public class Aula implements Decorador, Factory{
    private int id;
    private String nombre;
    private int capacidad;
    private String tipo;

    public Aula() {
    }

    public Aula(int id, String nombre, int capacidad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", tipo=" + tipo + '}';
    }

    @Override
    public String getClase() {
        return "Aula";
    }

    @Override
    public String getHecho() {
        return  "aula('" + 
                    getNombre() + "', "+
                    getCapacidad() + ", '"+
                    getTipo() +
                    "').";

         
    }

    

    
    
    
}
