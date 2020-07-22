package backend;

/**
 *
 * @author Baxi
 */

//import ClasesMenu.*;
//import ConexionSQLite.*;
import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPSyntaxErrorException;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import entity.Aula;
import entity.Curso;
import entity.Dia;
import entity.Disponibilidad;
import entity.Horario;
import entity.Imparte;
import entity.Leccion;
import entity.Profesor;
import java.util.ArrayList;
import patterns.Singleton;


public class SingletonProlog {
    /*------------------------------------------------------------------------*/
    /*Variables*/
    private static SingletonProlog metodosProlog = null;
    public JIPEngine interpreteProlog = new JIPEngine(); 
    
    private SingletonProlog(){
    }
    
    /*------------------------------------------------------------------------*/
    //Patron de diseno: Singleton
    public static SingletonProlog getInstance(){
        if(metodosProlog == null){
            metodosProlog = new SingletonProlog();
        }
        return metodosProlog;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodo de lib jiprolog
    public void InsertarDatoEnMemoria(String query){ 
         JIPTerm queryTerm = interpreteProlog.getTermParser().parseTerm(query);
         interpreteProlog.asserta(queryTerm);
    }
   
    // Metodo que agrega los hechos de la base de datos en memoria del intérprete de prolog
    public void assertDatosProlog(){
        assertCurso(Singleton.getInstance().listaCursos);
        assertAula(Singleton.getInstance().listaAulas);
        assertProfesor(Singleton.getInstance().listaProfesores);
        assertDia(Singleton.getInstance().listaDias);
        assertLeccion(Singleton.getInstance().listaLeccion);
        assertDisponibilidad(Singleton.getInstance().listaDisponibilidades);
        assertImparte(Singleton.getInstance().listaImparte);
        assertHorario(Singleton.getInstance().listaHorarios);
        
    }
    
    public ArrayList<Tabla> consulta(String query){
        JIPTerm queryTerm = null;
        // intentamos consultar el archivo
        try{
            // Carga código prolog de un archivo .pl
            interpreteProlog.consultFile("backend.pl");
            queryTerm = interpreteProlog.getTermParser().parseTerm(query); 
        }
        // Es necesario cerrar los hilos
        catch(JIPSyntaxErrorException ex){
            System.exit(0); 
        }
        
        // Se abre la consulta
        JIPQuery jipQuery = interpreteProlog.openSynchronousQuery(queryTerm);
        JIPTerm solucion;
        
        // Se itera hasta para buscar todas las soluciones
        try{
            ArrayList<Tabla> soluciones = new ArrayList<>();
            while (jipQuery.hasMoreChoicePoints()){
                solucion = jipQuery.nextSolution();
                if(solucion != null){
                    Tabla tabla = new Tabla(solucion.toString());
                    JIPVariable[] vars = solucion.getVariables();
                    for (JIPVariable var : vars) {
                        if (!var.isAnonymous()) {
                            String atributo = var.getName();
                            String datosProlog = var.toString(interpreteProlog);
                            tabla.datos.add(datosProlog);
                            tabla.atributos.add(atributo);

                        }
                    }
                    soluciones.add(tabla);
                }
                else{
                    System.out.println("Solucion falsa!!");
                }
            }
            return soluciones;
        }catch(NullPointerException e){
            System.out.println(e.toString());
            return null;
        }
    }

    private void assertCurso(ArrayList<Curso> lista) {
        lista.stream().map((curso) -> 
            "curso(" + 
                    curso.getNombre() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((curso) -> 
            "asignatura(" + 
                    curso.getNombre() + ", '"+
                    curso.getAsignatura() +
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((curso) -> 
            "creditos(" + 
                    curso.getNombre() + ", "+
                    curso.getCreditos()+
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((curso) -> 
            "semestre(" + 
                    curso.getNombre() + ", "+
                    curso.getSemestre()+
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((curso) -> 
            "cantidad_dias(" + 
                    curso.getNombre() + ", "+
                    curso.getCantidadDias()+
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }

    private void assertAula(ArrayList<Aula> lista) {
        lista.stream().map((aula) -> 
            "aula(" + 
                    aula.getNombre() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((aula) -> 
            "capacidad(" + 
                    aula.getNombre() + ", "+
                    aula.getCapacidad() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((aula) -> 
            "tipo(" + 
                    aula.getNombre() + ", '"+
                    aula.getTipo() +
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }

    private void assertProfesor(ArrayList<Profesor> lista) {
        lista.stream().map((profesor) -> 
            "profesor(" + 
                    profesor.getNombre() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((profesor) -> 
            "apellidos(" + 
                    profesor.getNombre() + ", '"+
                    profesor.getApellidos() +
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((profesor) -> 
            "cedula(" + 
                    profesor.getNombre() + ", '"+
                    profesor.getCedula() +
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }

    private void assertDia(ArrayList<Dia> lista) {
        lista.stream().map((dia) -> 
            "dia(" + 
                    dia.getDia()+
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((dia) -> 
            "dia_id(" + 
                    dia.getDia() + ", "+
                    dia.getId() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }

    private void assertLeccion(ArrayList<Leccion> lista) {
        lista.stream().map((leccion) -> 
            "leccion(" + 
                    leccion.getLeccion()+
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((leccion) -> 
            "dia_leccion(" + 
                    leccion.getLeccion()+ ", "+
                    leccion.getDia().getId()+
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((leccion) -> 
            "hora_inicio(" + 
                    leccion.getLeccion()+ ", '"+
                    leccion.getHoraInicio()+
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        
        lista.stream().map((leccion) -> 
            "hora_salida(" + 
                    leccion.getLeccion()+ ", '"+
                    leccion.getHoraSalida()+
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }

    private void assertDisponibilidad(ArrayList<Disponibilidad> lista) {
        lista.stream().map((disponibilidad) -> 
            "disponibilidad(" + 
                    disponibilidad.getProfesor().getNombre()+ ", "+
                    disponibilidad.getDia().getId() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }

    private void assertImparte(ArrayList<Imparte> lista) {
        lista.stream().map((imparte) -> 
            "imparte(" + 
                    imparte.getProfesor().getNombre()+ ", "+
                    imparte.getCurso().getId() +
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
            
        });
    }

    private void assertHorario(ArrayList<Horario> lista) {
        
    }
   
    

}

