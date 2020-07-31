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
public class Imparte  implements Factory, Decorador{
    private int id;
    private Profesor profesor;
    private Curso curso;

    public Imparte() {
       
    }

    public Imparte(int id, Profesor profesor, Curso curso) {
        this.id = id;
        this.profesor = profesor;
        this.curso = curso;
    }
    public Imparte(Profesor profesor, Curso curso) {
        this.id = id;
        this.profesor = profesor;
        this.curso = curso;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Imparte{" + "id=" + id + ", profesor=" + profesor + ", curso=" + curso + '}';
    }
    
   
    @Override
    public String getClase() {
        return "Imparte";
    }

    @Override
    public String getHecho() {
        return  "imparte('"+
                    getProfesor().getNombre()+ "', '"+
                    getCurso().getNombre() +
                "').\n";
    }

    public String getDatos() {
        return  "imparte('"+
                    getProfesor().getNombre()+ "', '"+
                    getCurso().getNombre() +
                "')";
    }
    
}
