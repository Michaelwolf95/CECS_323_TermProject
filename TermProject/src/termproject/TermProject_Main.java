/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termproject;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class TermProject_Main 
{
    //  Database credentials
    static String USER = DATABASE_INFO.USER;
    static String PASS = DATABASE_INFO.PASS;
    static String DBNAME = DATABASE_INFO.DBNAME;
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static String DB_URL = "jdbc:derby://localhost:1527/";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Constructing the database URL connection string
        DB_URL = DB_URL + DBNAME + ";user="+ USER + ";password=" + PASS;
        Connection conn = null; //initialize the connection
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            
            // == Call "Main" of seperate application class here.===============
            
            
            // =================================================================
            
            conn.close();
        } 
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        
        //System.out.println("\nGoodbye!");
    }
    
}
