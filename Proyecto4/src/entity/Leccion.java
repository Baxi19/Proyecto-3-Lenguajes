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
public class Leccion implements Decorador, Factory{
    private int id;
    private String leccion;
    private Dia dia;
    private String horaInicio;
    private String horaSalida;

    public Leccion() {
    }

    public Leccion(int id, String leccion, Dia dia, String horaInicio, String horaSalida) {
        this.id = id;
        this.leccion = leccion;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeccion() {
        return leccion;
    }

    public void setLeccion(String leccion) {
        this.leccion = leccion;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Leccion{" + "id=" + id + ", leccion=" + leccion + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaSalida=" + horaSalida + '}';
    }

    @Override
    public String getClase() {
        return "Leccion";
    }

    @Override
    public String getHecho() {
        return  "leccion('" + 
                    getLeccion()+ "', '"+
                    getDia().getDia()+ "', '"+
                    getHoraInicio()+ "', '"+
                    getHoraSalida()+
                "').\n";
    }

    
    
        
}
