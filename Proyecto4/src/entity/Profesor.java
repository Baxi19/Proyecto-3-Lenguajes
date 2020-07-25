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
public class Profesor  implements Factory, Decorador{ 
    private int id;
    private String nombre;
    private String apellidos;
    private String cedula;

    public Profesor() {
       
    }

    public Profesor(int id, String nombre, String apellidos, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + '}';
    }

    

    @Override
    public String getClase() {
        return "Profesor";
    }

    @Override
    public String getHecho() {
       return  "profesor('" + 
                    getNombre() + "', '"+
                    getApellidos() + "', '"+
                    getCedula() + 
                "')." ;
    }
     
}
