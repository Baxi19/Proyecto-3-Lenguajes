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
public class Horario   implements Decorador, Factory{
    private int id;
    private Leccion leccion;
    private Curso curso;
    private Profesor profesor;
    private Aula aula;

    public Horario() {
        
    }

    public Horario(int id, Leccion leccion, Curso curso, Profesor profesor, Aula aula) {
        this.id = id;
        this.leccion = leccion;
        this.curso = curso;
        this.profesor = profesor;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", leccion=" + leccion + ", curso=" + curso + ", profesor=" + profesor + ", aula=" + aula + '}';
    }
    
    

    @Override
    public String getClase() {
        return "Horario";
    }

    @Override
    public String getHecho() {
        return  "" ;
    }
}
