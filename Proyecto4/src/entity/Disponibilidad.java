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
public class Disponibilidad   implements Factory, Decorador{
    private int id;
    private Dia dia;
    private Profesor profesor;

    public Disponibilidad() {
        
    }

    public Disponibilidad(int id, Dia dia, Profesor profesor) {
        this.id = id;
        this.dia = dia;
        this.profesor = profesor;
    }
    
    public Disponibilidad(Dia dia, Profesor profesor) {
        this.id = id;
        this.dia = dia;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Disponibilidad{" + "id=" + id + ", dia=" + dia + ", profesor=" + profesor + '}';
    }

   
    @Override
    public String getClase() {
        return "Disponibilidad";
    }

    @Override
    public String getHecho() {
        return  "disponibilidad('"+
                getProfesor().getNombre()  + "', '" + 
                getDia().getDia()+ 
                "').\n";
    }

    public String getDatos() {
        return  "disponibilidad('"+
                getProfesor().getNombre()  + "', '" + 
                getDia().getDia()+ 
                "')";
    }
}
