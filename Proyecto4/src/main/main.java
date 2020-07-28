/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.CalendarView;
import patterns.Singleton;
import database.SQLite;
import entity.*;
import frontend.WindowsMenu;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;




/**
 *
 * @author Baxi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
           
        WindowsMenu w1 = new WindowsMenu();
        w1.setVisible(true);
    }
    
    

}
