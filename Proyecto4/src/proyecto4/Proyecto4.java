/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto4;



/**
 *
 * @author Baxi
 */
public class Proyecto4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String tl="consult('backend.pl')";
       Query ql = new Query(tl);
       System.out.println(tl+""+(ql.hasSolution()?"sadisfactoria":"insadisfactoria"));
         */
       Query.hasSolution("use_module(library(jpl))"); // only because we call e.g. jpl_pl_syntax/1 below
        Term swi = Query.oneSolution("current_prolog_flag(version_data,Swi)").get("Swi");
        System.out.println("swipl.version = " + swi.arg(1) + "." + swi.arg(2) + "." + swi.arg(3));
        System.out.println("swipl.syntax = " + Query.oneSolution("jpl_pl_syntax(Syntax)").get("Syntax"));
        System.out.println("swipl.home = " + Query.oneSolution("current_prolog_flag(home,Home)").get("Home").name());
        System.out.println("jpl.jar = " + JPL.version_string());
        System.out.println("jpl.dll = " + org.jpl7.fli.Prolog.get_c_lib_version());
        System.out.println("jpl.pl = " + Query.oneSolution("jpl_pl_lib_version(V)").get("V").name());
    }

}
