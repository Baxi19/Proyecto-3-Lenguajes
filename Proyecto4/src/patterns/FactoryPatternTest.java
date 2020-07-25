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
public class FactoryPatternTest {
    public static void main(String[] args) {
        FactoryPatternTest example = new FactoryPatternTest();
        example.nombreClase("AULA");
    }

    // Probando el Factory
    public void nombreClase(String tipoClase) {
        Factory clase = ClaseFactory.getClase(tipoClase);
        clase.getClase();

    }
}
