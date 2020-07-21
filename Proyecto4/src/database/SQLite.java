/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entity.Aula;
import entity.Dia;
import entity.Profesor;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Baxi
 */
public class SQLite {
    /*------------------------------------------------------------------------*/
    /*Variables*/
    public static SQLite instance = null;
    public int numberOfColumns;
    public DefaultTableModel model = new DefaultTableModel();
    public ResultSet result  ;
    
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
        model = new DefaultTableModel();
        Runnable myRunnable
                = new Runnable() {
            @Override
            public void run() {
                try {
                    Connection con = conexion();
                    Statement statement = con.createStatement();
                    result = statement.executeQuery(sql);
                    ResultSetMetaData rsMetaData = result.getMetaData();
                    numberOfColumns = rsMetaData.getColumnCount();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        model.addColumn(rsMetaData.getColumnName(i));
                    }
                    while (result.next()) {
                        Object[] fila = new Object[numberOfColumns];
                        for (int i = 0; i < numberOfColumns; i++) {
                            fila[i] = result.getObject(i + 1);
                        }
                        model.addRow(fila);
                    }
                    result.close();
                    statement.close();
                    con.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        };
        myRunnable.run();
        return model;
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
    
    
}
