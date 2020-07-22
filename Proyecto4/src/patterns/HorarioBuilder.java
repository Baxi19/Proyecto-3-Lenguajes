/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import entity.Aula;
import entity.Curso;
import entity.Horario;
import entity.Leccion;
import entity.Profesor;
import patterns.Decorador;
import patterns.IBuilder;

/**
 *
 * @author Baxi
 */
public class HorarioBuilder implements IBuilder{
    
    private int id; //importante pasarlo al constructor
    private Leccion leccion;
    private Curso curso;
    private Profesor profesor;
    private Aula aula;

    public HorarioBuilder() {
        
    }
    
    /*Constructores para Builder*/
    public HorarioBuilder withId(int id){
        this.id = id;
        return this;
    }
    
    public HorarioBuilder withLeccion(Leccion leccion){
        this.leccion = leccion;
        return this;
    }
    
    public HorarioBuilder withCurso(Curso curso){
        this.curso = curso;
        return this;
    }
    
    public HorarioBuilder withProfesor(Profesor profesor){
        this.profesor = profesor;
        return this;
    }
    
    public HorarioBuilder withAula(Aula aula){
        this.aula = aula;
        return this;
    }
    
    @Override
    public Horario build() {
        Horario horario = new Horario();
        horario.setLeccion(this.leccion);
        horario.setCurso(this.curso);
        horario.setProfesor(this.profesor);
        horario.setAula(this.aula);
        return horario;
    }
}
