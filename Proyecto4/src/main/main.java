/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import patterns.Singleton;
import database.SQLite;
import entity.*;
import frontend.WindowsMenu;
import java.util.ArrayList;




/**
 *
 * @author Baxi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowsMenu w1 = new WindowsMenu();
        w1.setVisible(true);
    }

}
