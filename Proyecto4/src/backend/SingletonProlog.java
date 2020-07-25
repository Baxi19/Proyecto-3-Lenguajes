package backend;

/**
 *
 * @author Baxi
 */

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPSyntaxErrorException;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import database.SQLite;
import entity.Aula;
import entity.Curso;
import entity.Dia;
import entity.Disponibilidad;
import entity.Horario;
import entity.Imparte;
import entity.Leccion;
import entity.Profesor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
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
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener los datos que retorna prolog
    public ArrayList<ResultadoProlog> consulta(String query, String archivo){
        JIPTerm queryTerm = null;
        // intentamos consultar el archivo
        try{
            // Carga código prolog de un archivo .pl
            interpreteProlog.consultFile((archivo+".pl"));
            queryTerm = interpreteProlog.getTermParser().parseTerm(query); 
        }
        // Es necesario cerrar los hilos
        catch(JIPSyntaxErrorException ex){
            //System.exit(0); 
            System.out.println(ex);
        }
        
        // Se abre la consulta
        JIPQuery jipQuery = interpreteProlog.openSynchronousQuery(queryTerm);
        JIPTerm solucion;
        
        // Se itera hasta para buscar todas las soluciones
        try{
            ArrayList<ResultadoProlog> soluciones = new ArrayList<>();
            while (jipQuery.hasMoreChoicePoints()){
                solucion = jipQuery.nextSolution();
                if(solucion != null){
                    ResultadoProlog tabla = new ResultadoProlog(solucion.toString());
                    JIPVariable[] vars = solucion.getVariables();
                    for (JIPVariable var : vars) {
                        if (!var.isAnonymous()) {
                            String atributo = var.getName();
                            String datosProlog = var.toString(interpreteProlog);
                            tabla.resultado.add(datosProlog);
                            tabla.variables.add(atributo);

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
    
    /*------------------------------------------------------------------------*/
    // Metodo que agrega los hechos de la base de datos en memoria del intérprete de prolog
    public Boolean assertDatosProlog(){
        assertCurso(Singleton.getInstance().listaCursos);
        assertProfesor(Singleton.getInstance().listaProfesores);
        assertAula(Singleton.getInstance().listaAulas);
        assertDia(Singleton.getInstance().listaDias);
        assertLeccion(Singleton.getInstance().listaLeccion);
        assertDisponibilidad(Singleton.getInstance().listaDisponibilidades);
        assertImparte(Singleton.getInstance().listaImparte);
        System.out.println("->Assert Prolog Completado");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertCurso(ArrayList<Curso> lista) {
        lista.stream().map((curso) -> 
            "curso('" + 
                    curso.getNombre() + "', '"+
                    curso.getAsignatura() + "', " +
                    curso.getCreditos() +  ", " +  
                    curso.getSemestre() +  ", " +  
                    curso.getCantidadDias()+         
                ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de cursos agregados");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertProfesor(ArrayList<Profesor> lista) {
        lista.stream().map((profesor) -> 
            "profesor('" + 
                    profesor.getNombre() + "', '"+
                    profesor.getApellidos() + "', '"+
                    profesor.getCedula() + 
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de profesores agregados");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertAula(ArrayList<Aula> lista) {
        lista.stream().map((aula) -> 
            "aula('"
                + aula.getNombre() + "', "
                + aula.getCapacidad() + ", '"
                + aula.getTipo()
                + "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de aulas agregados");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertDia(ArrayList<Dia> lista) {
        lista.stream().map((dia) -> 
            "dia('" + 
                    dia.getDia()+
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de dias agregados");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertLeccion(ArrayList<Leccion> lista) {
        lista.stream().map((leccion) -> 
            "leccion('" + 
                    leccion.getLeccion()+ "', '"+
                    leccion.getDia().getDia()+ "', '"+
                    leccion.getHoraInicio()+ "', '"+
                    leccion.getHoraSalida()+
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de lecciones agregados");
       return true;
    }
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertDisponibilidad(ArrayList<Disponibilidad> lista) {
        lista.stream().map((disponibilidad) -> 
            "disponibilidad('" + 
                    disponibilidad.getProfesor().getNombre()+ "', '"+
                    disponibilidad.getDia().getDia()+
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de disponibilidad agregados");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para ingresar los hechos a memoria del interprete
    private Boolean assertImparte(ArrayList<Imparte> lista) {
        lista.stream().map((imparte) -> 
            "imparte('" + 
                    imparte.getProfesor().getNombre()+ "', '"+
                    imparte.getCurso().getNombre()+
                "').").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
        System.out.println("->Datos de Imparte agregados");
        return true;
    }
    
    /*------------------------------------------------------------------------*/
    //Metodos para crear un archivo hechos.pl donde se guardan los hechos
    public Boolean crearArchivo(String nombreArchivo, ArrayList<String> contenido){
        try {
            
            File file = new File(Paths.get("").toAbsolutePath().toString()+"\\" + nombreArchivo+".pl");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            for (int i = 0; i < contenido.size(); i++) {
                Files.write(Paths.get(Paths.get("").toAbsolutePath().toString()+"\\" + nombreArchivo+".pl"), contenido.get(i).getBytes(), StandardOpenOption.APPEND);
            }
            System.out.println("->Escribiendo Hechos de prolog en la ubicacion" + Paths.get("").toAbsolutePath().toString()+"\\" + nombreArchivo+".pl");
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*------------------------------------------------------------------------*/
    /*Metodo para recorrer soluciones de prolog*/
    public DefaultTableModel consultarPrologTabla(String consulta) {
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<ResultadoProlog> resultado = consultaProlog(consulta);
        //columnas
        int cantidadColumnas = resultado.get(0).getVariables().size();
        for (int i = 0; i <  cantidadColumnas; i++) {
            modelo.addColumn(resultado.get(0).getVariables().get(i));
        }
        //para los datos
        for (int i = 0; i < resultado.size(); i++) {
            ArrayList<String> listaDatos = resultado.get(i).getResultado();
            
            //Collections.reverse(listaDatos);
            Object[] fila = new Object[cantidadColumnas];
            for (int j = 0; j <listaDatos.size(); j++) {
                fila[j] = listaDatos.get(j);
                System.out.println(listaDatos.get(j));
            }
            modelo.addRow(fila);   
        }
        return  modelo;
    }
    
    
    /*------------------------------------------------------------------------*/
    /*Metodo de enlase para la consultas en prolog*/
    public ArrayList<ResultadoProlog> consultaProlog(String consulta){
        ArrayList<ResultadoProlog> lista = new ArrayList<>();
        cargarDatosListas();
        SingletonProlog.getInstance().assertDatosProlog();
        lista = SingletonProlog.getInstance().consulta(consulta, "backend");
        return lista;    
    }
    
    /*------------------------------------------------------------------------*/
    private String limpiarListas(){
        Singleton.getInstance().listaHechos.clear();
        Singleton.getInstance().listaProfesores.clear();
        Singleton.getInstance().listaCursos.clear();
        Singleton.getInstance().listaAulas.clear();
        Singleton.getInstance().listaDias.clear();
        Singleton.getInstance().listaLeccion.clear();
        Singleton.getInstance().listaDisponibilidades.clear();
        Singleton.getInstance().listaImparte.clear();
        System.out.println("->Listas limpias");
        return "Listas limpias";
    }
    /*------------------------------------------------------------------------*/
    private String cargarDatosListas() {
        limpiarListas();
        SQLite.getInstance().obtenerAula();
        SQLite.getInstance().obtenerProfesor();
        SQLite.getInstance().obtenerCurso();
        SQLite.getInstance().obtenerDias();
        SQLite.getInstance().obtenerLeccion();
        SQLite.getInstance().obtenerDisponibilidad();
        SQLite.getInstance().obtenerImparte();
        System.out.println("->Listas con los datos cargados");
        return "Listas con los datos cargados";
      
    }
}

