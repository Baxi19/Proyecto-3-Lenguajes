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
import java.util.ArrayList;


public class MetodosProlog {
    private static MetodosProlog metodosProlog = null;
    public JIPEngine jip = new JIPEngine(); 
    
    private MetodosProlog(){
    }
    
    public void InsertarDatoEnMemoria(String query){ 
         JIPTerm queryTerm = jip.getTermParser().parseTerm(query);
         jip.asserta(queryTerm);
    }
   /* 
    // Función para insertar los hechos de la base de datos en memoria del intérprete de prolog
    public void assertFacts(){
        ArrayList<Entrada> listaEntradas = Conexion.getInstance().obtenerEntradas();
        ArrayList<Postre> listaPostres = Conexion.getInstance().obtenerPostres();
        ArrayList<Carbohidrato> listaCarbohidratos = Conexion.getInstance().obtenerCarbohidratos();
        ArrayList<Vegetal> listaVegetales = Conexion.getInstance().obtenerVegetales();
        ArrayList<Proteina> listaProteinas = Conexion.getInstance().obtenerProteinas();
        assertEntradas(listaEntradas);
        assertPostres(listaPostres);
        assertCarbohidrato(listaCarbohidratos);
        assertVegetal(listaVegetales);
        assertProteina(listaProteinas);
        
    }
    
    // Función para insertar hechos tipo entrada a memoria del intérprete de prolog
    public void assertEntradas(ArrayList<Entrada> listaEntradas){
        listaEntradas.stream().map((entrada) -> 
            "entrada('" +
            entrada.getNombre() + "'," + 
            entrada.getCalorias() + "," + 
            entrada.isVegetariano() + ").").forEachOrdered((hecho) -> {
            //en prolog: entrada(string nombre, int calorias, bool vegetariano).
            InsertarDatoEnMemoria(hecho);
        });
    }
    // Función para insertar hechos tipo Postrea memoria del intérprete de prolog
    public void assertPostres(ArrayList<Postre> listaPostres){
        listaPostres.stream().map((postre) -> 
            "postre('" + 
            postre.getNombre() + "'," + 
            postre.getCalorias()+ ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }
    
    // Función para insertar hechos tipo proteina a memoria del intérprete de prolog
    public void assertProteina(ArrayList<Proteina> listaProteinas){
        listaProteinas.stream().map((proteina) -> 
            "proteina('" + 
            proteina.getNombre() + "'," + 
            proteina.getCalorias() + "," + 
            proteina.getTipo() + ").").forEachOrdered((hecho) -> {
            // en prolog: proteina(string nombre, int calorias, bool vegetariano).
            InsertarDatoEnMemoria(hecho);
        });
    }
    
    // Función para insertar hechos tipo Carbohidrato a memoria del intérprete de prolog
    public void assertCarbohidrato(ArrayList<Carbohidrato> listaCarbohidratos){
        listaCarbohidratos.stream().map((carbohidrato) -> 
            "carbohidrato('" + 
            carbohidrato.getNombre() + "'," + 
            carbohidrato.getCalorias()+ ").").forEachOrdered((hecho) -> {
            // en prolog: carbohidrato(string nombre, int calorias).
            InsertarDatoEnMemoria(hecho);
        });
    }
    
    // Función para insertar hechos tipo vegetal a memoria del intérprete de prolog
    public void assertVegetal(ArrayList<Vegetal> listaVegetales){
        listaVegetales.stream().map((vegetal) -> 
            "vegetal('" + 
            vegetal.getNombre() + "'," + 
            vegetal.getCalorias()+ ").").forEachOrdered((hecho) -> {
            InsertarDatoEnMemoria(hecho);
        });
    }
    
    
    public ArrayList<Solucion> HacerConsulta(String query){
        JIPTerm queryTerm = null;
        // parse query
        try
        {
            // Carga código prolog de un archivo .pl
            jip.consultFile("FuncionesProlog.pl");
            queryTerm = jip.getTermParser().parseTerm(query); 
        }
        catch(JIPSyntaxErrorException ex)
        {
            System.exit(0); // needed to close threads by AWT if shareware
        }
        // open Query
    
        JIPQuery jipQuery = jip.openSynchronousQuery(queryTerm);
        JIPTerm solution;
        // Loop while there is another solution
        try{
            ArrayList<Solucion> soluciones = new ArrayList<>();
            while (jipQuery.hasMoreChoicePoints())
            {
                solution = jipQuery.nextSolution();
                if(solution != null){
                    Solucion sln = new Solucion(solution.toString());
                    JIPVariable[] vars = solution.getVariables();
                    for (JIPVariable var : vars) {
                        if (!var.isAnonymous()) {
                            String atributo = var.getName();
                            String respuesta = var.toString(jip);
                            sln.respuestas.add(respuesta);
                            sln.atributos.add(atributo);

                        }
                    }
                    soluciones.add(sln);
                }
                else{
                    System.out.println("Solución: Falsa");
                }
            }
            return soluciones;
        }
        catch(NullPointerException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
*/    
    public static MetodosProlog getInstance(){
        if(metodosProlog == null){
            metodosProlog = new MetodosProlog();
        }
        return metodosProlog;
    }

}

