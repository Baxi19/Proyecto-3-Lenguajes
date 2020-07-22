/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

/**
 *
 * @author Baxi
 */
public class Decorador {
    protected int id;
    protected String nombreClase;

    public Decorador() {
    }
    
    
    public Decorador(int id, String nombreClase) {
        this.id = id;
        this.nombreClase = nombreClase;
        
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

   

    @Override
    public String toString() {
        return "\nNombre Clase=" + nombreClase;
    }

    
    
    
    
}
