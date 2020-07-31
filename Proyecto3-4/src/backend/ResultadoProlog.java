/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author Baxi
 */
public class ResultadoProlog {
    protected String consulta;
    protected ArrayList<String> variables;
    protected ArrayList<String> resultado;

    public ResultadoProlog(String consulta) {
        this.consulta = consulta;
        this.variables = new ArrayList<>();
        this.resultado = new ArrayList<>();
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public ArrayList<String> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }

    public ArrayList<String> getResultado() {
        return resultado;
    }

    public void setResultado(ArrayList<String> resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "\nResultadoProlog{" + "\nconsulta=" + consulta + ", \nvariables=" + variables + ", \nresultado=" + resultado + '}';
    }

   
    
    
    
}
