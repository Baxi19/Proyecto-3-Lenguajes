/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import patterns.Decorador;
import patterns.Clase;

/**
 *
 * @author Baxi
 */
public class Horario extends Decorador implements Clase{
    private int id;
    private Leccion leccion;
    private Curso curso;
    private Profesor profesor;
    private Aula aula;

    public Horario() {
        super();
    }
    
    /*Constructores clase hija*/
    public Horario(Leccion leccion, Curso curso, Profesor profesor, Aula aula) {
        this.leccion = leccion;
        this.curso = curso;
        this.profesor = profesor;
        this.aula = aula;
    }

    public Horario(int id, Leccion leccion, Curso curso, Profesor profesor, Aula aula) {
        this.id = id;
        this.leccion = leccion;
        this.curso = curso;
        this.profesor = profesor;
        this.aula = aula;
    }
    
    /*Constructor clase padre*/
    public Horario(int id, Leccion leccion, Curso curso, Profesor profesor, Aula aula,  String nombreClase) {
        super(id, nombreClase);
        this.leccion = leccion;
        this.curso = curso;
        this.profesor = profesor;
        this.aula = aula;
    }

    public Leccion getLeccion() {
        return leccion;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
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
        return "Horario{" + "leccion=" + leccion + ", curso=" + curso + ", profesor=" + profesor + ", aula=" + aula + '}';
    }

    @Override
    public String getClase() {
        return "Horario";
    }
}
