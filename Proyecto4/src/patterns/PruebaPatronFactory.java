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
public class PruebaPatronFactory { 
    //Carga los datos de prueba para el factory
    public void probarDatos(){
        PruebaPatronFactory ejemplo1 = new PruebaPatronFactory();
        ejemplo1.nombreClase("AULA");
        
        PruebaPatronFactory ejemplo2 = new PruebaPatronFactory();
        ejemplo2.nombreClase("CURSO");
        
        PruebaPatronFactory ejemplo3 = new PruebaPatronFactory();
        ejemplo3.nombreClase("DIA");
        
        PruebaPatronFactory ejemplo4 = new PruebaPatronFactory();
        ejemplo4.nombreClase("DISPONIBILIDAD");
        
        PruebaPatronFactory ejemplo5 = new PruebaPatronFactory();
        ejemplo5.nombreClase("HORARIO");
        
        PruebaPatronFactory ejemplo6 = new PruebaPatronFactory();
        ejemplo6.nombreClase("IMPARTE");
        
        PruebaPatronFactory ejemplo7 = new PruebaPatronFactory();
        ejemplo7.nombreClase("LECCION");
        
        PruebaPatronFactory ejemplo8 = new PruebaPatronFactory();
        ejemplo8.nombreClase("PROFESOR");
        
    }
    
    // Metodo que recibe un tipo de clase y lo asocia en el factory
    public void nombreClase(String tipoClase) {
        Factory clase = ClaseFactory.getClase(tipoClase);
        clase.getClase();
    }
}
