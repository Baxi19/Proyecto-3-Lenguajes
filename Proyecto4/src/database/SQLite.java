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
        String url = "jdbc:sqlite:" + filePath+"\\database\\database.db";
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
    //Buscar un dia por id
    public Dia getDia(int id){
        Dia dia = new Dia();
        String query = "SELECT dia FROM Dia WHERE ID = " +  id;
        try (Connection conn = this.conexion();
            Statement stmt  = conn.createStatement();
            ResultSet rs   = stmt.executeQuery(query)){
            rs.next();
            dia.setId(id);
            dia.setDia(rs.getString("dia"));
            rs.close();
            stmt.close();
            conn.close();
            return dia;
        } 
        catch (SQLException e) {
            return null;
        } 
    }
    /*------------------------------------------------------------------------*/
    //Buscar un profesor por id
    public Profesor getProfesor(int id){
        Profesor profesor = new Profesor();
        String query = "SELECT * FROM Profesor WHERE ID = " +  id;
        try (Connection conn = this.conexion();
            Statement stmt  = conn.createStatement();
            ResultSet rs   = stmt.executeQuery(query)){
            rs.next();
            profesor.setId(id);
            profesor.setNombre(rs.getString("nombre"));
            profesor.setApellidos(rs.getString("apellidos"));
            profesor.setApellidos(rs.getString("cedula"));
            rs.close();
            stmt.close();
            conn.close();
            return profesor;
        } 
        catch (SQLException e) {
            return null;
        } 
    }

}
