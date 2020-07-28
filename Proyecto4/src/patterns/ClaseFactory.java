/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import entity.Aula;
import entity.Curso;
import entity.Dia;
import entity.Disponibilidad;
import entity.Horario;
import entity.Imparte;
import entity.Leccion;
import entity.Profesor;

/**
 *
 * @author Baxi
 */
public class ClaseFactory {
    public static Factory getClase(String tipoClase){
        if (tipoClase == null) {
            return null;
        }
        if (tipoClase.equalsIgnoreCase("AULA")) {
            return new Aula();
        } else if (tipoClase.equalsIgnoreCase("CURSO")) {
            return new Curso();
        } else if (tipoClase.equalsIgnoreCase("DIA")) {
            return new Dia();
        } else if (tipoClase.equalsIgnoreCase("DISPONIBILIDAD")) {
            return new Disponibilidad();
        } else if (tipoClase.equalsIgnoreCase("HORARIO")) {
            return new Horario();
        }else if (tipoClase.equalsIgnoreCase("IMPARTE")) {
            return new Imparte();
        } else if (tipoClase.equalsIgnoreCase("LECCION")) {
            return new Leccion();
        }else if (tipoClase.equalsIgnoreCase("PROFESOR")) {
            return new Profesor();
        }else {
            throw new IllegalStateException("No se encontro el tipo de clase: " + tipoClase);
        }
    }
}
