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
public class Curso implements Decorador, Factory{
    private int id;
    private String nombre;
    private String asignatura;
    private int creditos;
    private int semestre;
    private int cantidadDias;

    public Curso() {
        
    }

    public Curso(int id, String nombre, String asignatura, int creditos, int semestre, int cantidadDias) {
        this.id = id;
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.creditos = creditos;
        this.semestre = semestre;
        this.cantidadDias = cantidadDias;
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

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + ", asignatura=" + asignatura + ", creditos=" + creditos + ", semestre=" + semestre + ", cantidadDias=" + cantidadDias + '}';
    }

    
    
    @Override
    public String getClase() {
        return "Curso";
    }

    @Override
    public String getHecho() {
        return  "curso(" + 
                    getId()+ ", '"+
                    getNombre() + "', '"+
                    getAsignatura() + "', " +
                    getCreditos() +  ", " +  
                    getSemestre() +  ", " +  
                    getCantidadDias()+         
                "). \n";
    }

    
    
    
    
    
}
