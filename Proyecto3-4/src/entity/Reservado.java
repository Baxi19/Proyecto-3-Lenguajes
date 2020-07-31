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
public class Reservado {
    public String profesor;
    public String curso;
    public String dia1;
    public String dia2;
    public String leccion1;
    public String leccion2;
    public String aula;
    public String semestre;

    public Reservado() {
    }

    public Reservado(String profesor, String curso, String dia1, String dia2, String leccion1, String leccion2, String aula, String semestre) {
        this.profesor = profesor;
        this.curso = curso;
        this.dia1 = dia1;
        this.dia2 = dia2;
        this.leccion1 = leccion1;
        this.leccion2 = leccion2;
        this.aula = aula;
        this.semestre = semestre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDia1() {
        return dia1;
    }

    public void setDia1(String dia1) {
        this.dia1 = dia1;
    }

    public String getDia2() {
        return dia2;
    }

    public void setDia2(String dia2) {
        this.dia2 = dia2;
    }

    public String getLeccion1() {
        return leccion1;
    }

    public void setLeccion1(String leccion1) {
        this.leccion1 = leccion1;
    }

    public String getLeccion2() {
        return leccion2;
    }

    public void setLeccion2(String leccion2) {
        this.leccion2 = leccion2;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "\nReservado{" + "profesor=" + profesor + ", curso=" + curso + ", dia1=" + dia1 + ", dia2=" + dia2 + ", leccion1=" + leccion1 + ", leccion2=" + leccion2 + ", aula=" + aula + ", semestre=" + semestre + '}';
    }

        
}
