/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Baxi
 */
class Curso {
    private int id;
    private String asignatura;
    private int creditos;
    private int semestre;
    private int cantidadDias;

    public Curso() {
    }

    public Curso(int id, String asignatura, int creditos, int semestre, int cantidadDias) {
        this.id = id;
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
    
    
}
