package com.example.users.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
    // DatabaseConnection  parameters
    private String url = "jdbc:postgresql://localhost:5432/usersws";
    private String user = "postgres";
    private String pass = "Root";
    private Connection conn; 
    
    // Return the Database Connection
    public Connection getConnection()
    {
        try
        {
            // Create the Database connection
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e)
        {
            System.out.println("Se presentaron problemas en la conexión con la base de datos: " + e );
        }
        
        return conn;
    }
    
}
