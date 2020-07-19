/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Baxi
 */
public class Metodos {
    /*------------------------------------------------------------------------*/
    /*Variables*/
    public static Metodos instance = null;
    
    /*------------------------------------------------------------------------*/
    //Patron de diseno: Singleton
    public static Metodos getInstance() {
        if (instance == null) {
            return instance = new Metodos();
        }
        return instance;
    }
    
}
