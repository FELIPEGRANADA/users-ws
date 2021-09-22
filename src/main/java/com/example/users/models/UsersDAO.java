package com.example.users.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.users.entities.User;

public class UsersDAO 
{
    // Attributes to execute statements on DataBase
    private Connection conn;
    private PreparedStatement ps;
    
    // Class constructor
    public UsersDAO() 
    {
        // Get DataBase Connection
        DBConnection dnConnection = new DBConnection();
        conn = dnConnection.getConnection();  
    }
    
    // Create an user
 	public void createUser(User newUser)
 	{				
        // Statement to insert an user on DataBase
        String sql = "INSERT INTO \"User\" (id, username, password, email, name, phone)\n" +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try
        {
            // Execute statement to insert the record
            ps = conn.prepareStatement(sql);
            ps.setInt(1, newUser.getId());
            ps.setString(2, newUser.getUsername());
            ps.setString(3, newUser.getPassword());
            ps.setString(4, newUser.getEmail());
            ps.setString(5, newUser.getName());
            ps.setString(6, newUser.getPhone());
            ps.executeUpdate();
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println("Error ejecutando sentencia en la base de datos: "+ e);
        }
 	}
 	
	// Get user by identifier
	public User getUser(int id)
	{
		// Create an user -1 for when it isn't on the DataBase
		User searchUser = new User();
		// Statement to search an user on DataBase
        String sql = "SELECT * FROM \"User\"\n" +
                     "WHERE id = ?";
        ResultSet result;
        try
        {
            // Execute statement to get the record by id
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeQuery();
            while(result.next())
            {
            	searchUser.setId(result.getInt(1));
            	searchUser.setUsername(result.getString(2));
            	searchUser.setPassword(result.getString(3));
            	searchUser.setEmail(result.getString(4));
            	searchUser.setName(result.getString(5));
            	searchUser.setPhone(result.getString(6));
            }
            
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println("Error ejecutando sentencia en la base de datos: "+ e);
        }
		
		return searchUser;
	}
}
