/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.sql.*;
/**
 *
 * @author h8saini
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Connection c = null;
try {
Class.forName("org.sqlite.JDBC");
c = DriverManager.getConnection("jdbc:sqlite:uclTourney.db");
}
catch ( Exception e ) {
System.err.println("Problem Encountered");
}
System.out.println("Opened database successfully");
    }
    
   
}

