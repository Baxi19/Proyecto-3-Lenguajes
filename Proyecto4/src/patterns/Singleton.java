/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;
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
public class Singleton {
    /*------------------------------------------------------------------------*/
    /*Variables*/
    public static Singleton instance = null;
    public ArrayList<Aula> listaAulas = new ArrayList<>();
    public ArrayList<Curso> listaCursos = new ArrayList<>();
    public ArrayList<Dia> listaDias = new ArrayList<>();
    public ArrayList<Disponibilidad> listaDisponibilidades = new ArrayList<>();
    public ArrayList<Horario> listaHorarios = new ArrayList<>();
    public ArrayList<Imparte> listaImparte = new ArrayList<>();
    public ArrayList<Leccion> listaLeccion = new ArrayList<>();
    public ArrayList<Profesor> listaProfesores = new ArrayList<>();
    public ArrayList<String> listaHechos = new ArrayList<>();
    public ArrayList<Object[]> listaReservas = new ArrayList<>();
    /*------------------------------------------------------------------------*/
    //Patron de diseno: Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            return instance = new Singleton();
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
    
    private Boolean imprime(ArrayList lista){
        System.out.println("");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //metodo para buscar profesor por id
    public Profesor buscarProfesor(int id){
        for (Profesor profe : listaProfesores) {
            if(profe.getId() == id){
                return profe;
            }
        }
        System.out.println("(X) Problema al ubicar Profesor id = " + id);
        return null;
    }
    
    /*------------------------------------------------------------------------*/
    //metodo para buscar dia por id
    public Dia buscarDia(int id){
        for (Dia dia : listaDias) {
            if(dia.getId() == id){
                return dia;
            }
        }
        System.out.println("(X) Problema al ubicar Dia id = " + id);
        return null;
    }
    
    /*------------------------------------------------------------------------*/
    //metodo para buscar leccion por id
    public Leccion buscarLeccion(int id){
        for (Leccion leccion : listaLeccion) {
            if(leccion.getId() == id){
                return leccion;
            }
        }
        System.out.println("(X) Problema al ubicar Leccion id = " + id);
        return null;
    }
    
    /*------------------------------------------------------------------------*/
    //metodo para buscar curso por id
    public Curso buscarCurso(int id){
        for (Curso curso : listaCursos) {
            if(curso.getId() == id){
                return curso;
            }
        }
        System.out.println("(X) Problema al ubicar Curso id = " + id);
        return null;
    }
    
    /*------------------------------------------------------------------------*/
    //metodo para buscar aula por id
    public Aula buscarAula(int id){
        for (Aula aula : listaAulas) {
            if(aula.getId() == id){
                return aula;
            }
        }
        System.out.println("(X) Problema al ubicar Aula id = " + id);
        return null;
    }
    
    
    /*------------------------------------------------------------------------*/
    //metodo que verifica si existe disponibilidad
    public Boolean verificaHorario(Horario posibleHorario){
        for (Horario horario : listaHorarios) {
            if(horario.getAula().getNombre().equals(posibleHorario.getAula().getNombre())){
                if(horario.getLeccion().getLeccion().equals(posibleHorario.getLeccion().getLeccion())){
                    if(horario.getCurso().getNombre().equals(posibleHorario.getCurso().getNombre())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
