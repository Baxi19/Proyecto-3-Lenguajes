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
public class Imparte extends Decorador{
    private int id;
    private Profesor profesor;
    private Curso curso;

    public Imparte() {
        super();
    }

    public Imparte(Profesor profesor, Curso curso) {
        this.profesor = profesor;
        this.curso = curso;
    }

    public Imparte( int id, Profesor profesor, Curso curso) {
        this.id = id;
        this.profesor = profesor;
        this.curso = curso;
    }
    
    public Imparte( int id, Profesor profesor, Curso curso, String nombreClase) {
        super(id, nombreClase);
        this.profesor = profesor;
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        return "Imparte{" + "id=" + id + ", profesor=" + profesor + ", curso=" + curso + '}';
    }

    
    
}
