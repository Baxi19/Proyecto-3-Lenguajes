/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import entity.Aula;
import entity.Dia;
import entity.Curso;
import entity.Disponibilidad;
import entity.Horario;
import entity.Imparte;
import entity.Leccion;
import entity.Profesor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Baxi
 */
public class Metodos {
    /*------------------------------------------------------------------------*/
    /*Variables*/
    public static Metodos instance = null;
    public ArrayList<Aula> listaAulas = new ArrayList<>();
    public ArrayList<Curso> listaCursos = new ArrayList<>();
    public ArrayList<Dia> listaDias = new ArrayList<>();
    public ArrayList<Disponibilidad> listaDisponibilidades = new ArrayList<>();
    public ArrayList<Horario> listaHorarios = new ArrayList<>();
    public ArrayList<Imparte> listaImparte = new ArrayList<>();
    public ArrayList<Leccion> listaLeccion = new ArrayList<>();
    public ArrayList<Profesor> listaProfesores = new ArrayList<>();
    
    /*------------------------------------------------------------------------*/
    //Patron de diseno: Singleton
    public static Metodos getInstance() {
        if (instance == null) {
            return instance = new Metodos();
        }
        return instance;
    }
    
    /*------------------------------------------------------------------------*/
    public void closeSystem(){    
        try {
            int dialoButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, 
                    "Desea cerrar el sistema?", "Salir", dialoButton);
            if (result == 0) {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
