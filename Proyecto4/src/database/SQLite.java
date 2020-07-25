/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static com.sun.jmx.mbeanserver.Util.cast;
import entity.Aula;
import entity.Curso;
import entity.Dia;
import entity.Disponibilidad;
import entity.Horario;
import patterns.HorarioBuilder;
import entity.Imparte;
import entity.Leccion;
import entity.Profesor;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import patterns.Decorador;
import patterns.Singleton;

/**
 *
 * @author Baxi
 */
public class SQLite {
    /*------------------------------------------------------------------------*/
    /*Variables*/
    public static SQLite instance = null;
    public int cantidadColumnas;
    public DefaultTableModel modelo = new DefaultTableModel();
    public ResultSet resultadoConsulta  ;
    
    /*------------------------------------------------------------------------*/
    //Patron de diseno: Singleton
    public static SQLite getInstance() {
        if (instance == null) {
            return instance = new SQLite();
        }
        return instance;
    }
    /*------------------------------------------------------------------------*/
    // SQLite conexion
    private Connection conexion() {
        String filePath = new File("").getAbsolutePath();
        String url = "jdbc:sqlite:" + filePath+"/database/database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;       
    }
    
    /*------------------------------------------------------------------------*/
    //metodo para consultas generico
    public DefaultTableModel executeSQL(String sql) {
        modelo = new DefaultTableModel();
        Runnable myRunnable
                = new Runnable() {
            @Override
            public void run() {
                try {
                    Connection con = conexion();
                    Statement statement = con.createStatement();
                    resultadoConsulta = statement.executeQuery(sql);
                    ResultSetMetaData rsMetaData = resultadoConsulta.getMetaData();
                    cantidadColumnas = rsMetaData.getColumnCount();
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMetaData.getColumnName(i));
                    }
                    while (resultadoConsulta.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            fila[i] = resultadoConsulta.getObject(i + 1);
                        }
                        modelo.addRow(fila);
                    }
                    resultadoConsulta.close();
                    statement.close();
                    con.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        };
        myRunnable.run();
        return modelo;
    }
    
    /*------------------------------------------------------------------------*/
    //eliminar 
    public boolean eliminar(int id, String tabla){
       String query = "UPDATE "+ tabla +" SET activo = 'F' WHERE ID = " + id;
       try {
            Connection conn = conexion();
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(query);
            stmt.close();
            conn.close();
            return true;
        }catch (SQLException e) {
            if(e.getMessage().equals("query does not return ResultSet")){
                return true;
            }else{
                System.out.println(e.getMessage());
                return false;
            }    
        }
    }
    
    /*------------------------------------------------------------------------*/
    //agregar profesor
    public Boolean agregarProfesor(String nombre, String apellidos, String cedula){
        String sql =    " INSERT INTO Profesor(nombre, apellidos, cedula, activo ) " +
                        " VALUES( '"+ nombre + "', '" + apellidos+ "', '"+ cedula+"','T');";
        try {
            Connection conn = conexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }  
    }
    
    /*------------------------------------------------------------------------*/
    //agregar curso
    public Boolean agregarCurso(String nombre, String asignatura,int creditos,int semestre, int cantidadDias){
        String sql =    " INSERT INTO Curso(nombre, asignatura, creditos,semestre, cantidad_dias, activo ) " +
                        " VALUES( '"+ nombre + "', '" 
                                    + asignatura+ "', "
                                    + creditos+", "
                                    + semestre + ", "
                                    + cantidadDias+", "
                                    + "'T');";
        System.out.println("\n SQL = " + sql);
        try {
            Connection conn = conexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }  
    }
    
    /*------------------------------------------------------------------------*/
    //agregar aula
    public Boolean agregarAula(String nombre, int capacidad, String tipo){
        String sql =    " INSERT INTO Aula(nombre, capacidad, tipo, activo ) " +
                        " VALUES( '"+ nombre + "', " + capacidad+ ", '"+ tipo+"','T');";
        try {
            Connection conn = conexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }  
    }
    
    /*------------------------------------------------------------------------*/
    //agregar imparte
    public Boolean agregarImparte(int profesorId, int cursoId){
        String sql =    " INSERT INTO Imparte(profesor_id, curso_id, activo ) " +
                        " VALUES( "+ profesorId + ", " + cursoId+ ",'T');";
        try {
            Connection conn = conexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }  
    } 
    
    /*------------------------------------------------------------------------*/
    //agregar disponibilidad
    public Boolean agregarDisponibilidad(int profesorId, int diaId){
        String sql =    " INSERT INTO Disponibilidad(profesor_id, dia_id, activo ) " +
                        " VALUES( "+ profesorId + ", " + diaId+ ",'T');";
        try {
            Connection conn = conexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }  
    } 
    
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener las aulas y agregarlos en una lista
    public Boolean obtenerAula(){
        String sql = "SELECT * FROM Aula WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Aula item = new Aula(resultadoConsulta.getInt("id"), 
                                resultadoConsulta.getString("nombre"), 
                                resultadoConsulta.getInt("capacidad"), 
                                resultadoConsulta.getString("tipo")
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaAulas.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 

    /*------------------------------------------------------------------------*/
    //metodo para obtener los cursos y agregarlos en una lista
    public Boolean obtenerCurso(){
        String sql = "SELECT * FROM Curso WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Curso item = new Curso(resultadoConsulta.getInt("id"), 
                                resultadoConsulta.getString("nombre"), 
                                resultadoConsulta.getString("asignatura"), 
                                resultadoConsulta.getInt("creditos"),
                                resultadoConsulta.getInt("semestre"),
                                resultadoConsulta.getInt("cantidad_dias")
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaCursos.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener los dias y agregarlos en una lista
    public Boolean obtenerDias(){
        String sql = "SELECT * FROM Dia WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Dia item = new Dia(resultadoConsulta.getInt("id"), 
                                resultadoConsulta.getString("dia")
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaDias.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener las lecciones y agregarlos en una lista
    public Boolean obtenerLeccion(){
        String sql = "SELECT * FROM Leccion WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Leccion item = new Leccion(resultadoConsulta.getInt("id"), 
                                resultadoConsulta.getString("leccion"), 
                                Singleton.getInstance().buscarDia(resultadoConsulta.getInt("dia_id")), 
                                resultadoConsulta.getString("hora_inicio"),
                                resultadoConsulta.getString("hora_salida")
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaLeccion.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener los profesores y agregarlos en una lista
    public Boolean obtenerProfesor(){
        String sql = "SELECT * FROM Profesor WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Profesor item = new Profesor(resultadoConsulta.getInt("id"), 
                                resultadoConsulta.getString("nombre"),  
                                resultadoConsulta.getString("apellidos"),
                                resultadoConsulta.getString("cedula")
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaProfesores.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener los profesores y los cursos que imparte para  agregarlos en una lista
    public Boolean obtenerImparte(){
        String sql = "SELECT * FROM Imparte WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Imparte item =new Imparte(resultadoConsulta.getInt("id"), 
                                Singleton.getInstance().buscarProfesor(resultadoConsulta.getInt("profesor_id")),
                                Singleton.getInstance().buscarCurso(resultadoConsulta.getInt("curso_id"))
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaImparte.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener los profesores y los cursos que imparte para  agregarlos en una lista
    public Boolean obtenerDisponibilidad(){
        String sql = "SELECT * FROM Disponibilidad WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                Disponibilidad item = new Disponibilidad(resultadoConsulta.getInt("id"), 
                                Singleton.getInstance().buscarDia(resultadoConsulta.getInt("dia_id")),
                                Singleton.getInstance().buscarProfesor(resultadoConsulta.getInt("profesor_id"))
                        );
                Singleton.getInstance().listaHechos.add(item.getHecho());
                Singleton.getInstance().listaDisponibilidades.add(item);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 
    
    /*------------------------------------------------------------------------*/
    //metodo para obtener los horarios para  agregarlos en una lista
    public Boolean obtenerHorario(){
        String sql = "SELECT * FROM Horario WHERE  activo ='T';";
        try {
            Connection con = conexion();
            Statement statement = con.createStatement();
            resultadoConsulta = statement.executeQuery(sql);
            while (resultadoConsulta.next()) {
                HorarioBuilder builder = new HorarioBuilder();
                Horario horario = builder.withId(resultadoConsulta.getInt("id"))
                        .withLeccion(Singleton.getInstance().buscarLeccion(resultadoConsulta.getInt("leccion_id")))
                        .withCurso(Singleton.getInstance().buscarCurso(resultadoConsulta.getInt("curso_id")))
                        .withProfesor(Singleton.getInstance().buscarProfesor(resultadoConsulta.getInt("profesor_id")))
                        .withAula(Singleton.getInstance().buscarAula(resultadoConsulta.getInt("aula_id")))
                        .build();
                Singleton.getInstance().listaHorarios.add(horario);  
            }
            resultadoConsulta.close();
            statement.close();
            con.close();           
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    } 

}
