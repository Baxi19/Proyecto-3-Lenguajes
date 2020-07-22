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
public class Profesor extends Decorador implements Clase{ 
    private int id;
    private String nombre;
    private String apellidos;
    private String cedula;

    public Profesor() {
        super();
    }

    public Profesor(String nombre, String apellidos, String cedula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }
    
    public Profesor( int id, String nombre, String apellidos, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }
    
    public Profesor(int id, String nombre, String apellidos, String cedula, String nombreClase) {
        super(id, nombreClase);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
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
        return "Profesor{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + '}';
    }

    @Override
    public String getClase() {
        return "Profesor";
    }
     
}
