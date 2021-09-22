package com.example.users.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.users.entities.User;
import com.example.users.models.UsersDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

// Class implements business logic on users
@Service
public class UsersService 
{
	// Users List
	private List<User> usersList;
	// Instance DAO Users
	UsersDAO usersDAO;
	
	// Class constructor
	public UsersService()
	{
		// Initialize the users list
		this.usersList = new ArrayList<User>();
		// Create instance DAO Users
		this.usersDAO = new UsersDAO();
	}
	
	// Create an user
	public User createUser(User newUser)
	{				
		// Create identifier for the user
		int id = (int)Math.floor(Math.random()*100);
		// Create a new user to add to the list
		User user = new User(id, 
				            newUser.getUsername(),
				            newUser.getPassword(),
				            newUser.getEmail(),
				            newUser.getName(),
				            newUser.getPhone());
		
		// Add the user to DataBase
		this.usersDAO.createUser(user);
		// Add the user to the list
		this.usersList.add(user);
		// Return the user
		return user;
	}
	
	// List all users
	public List<User> listUsers()
	{
		// Return the user list
		return this.usersList;
	}
	
	// Get an user by identifier
	private int getUserById(int id)
	{
		int index = -1;
		// Search the user in the list
		for(int i = 0; i < this.usersList.size(); i++)
		{
			if(this.usersList.get(i).getId() == id)
			{
				index = i;
				break;
			}
		}
		
		// Return the index  
		return index;
	}
	
	// Get user by identifier
	public User getUser(Integer id)
	{
		// Get User from DataBase
		return this.usersDAO.getUser(id.intValue());
	}
	
	// Update all information of an user
	private void updateList(int index, User updateUser)
	{
		this.usersList.get(index).setUsername(updateUser.getUsername());
		this.usersList.get(index).setPassword(updateUser.getPassword());
		this.usersList.get(index).setEmail(updateUser.getEmail());
		this.usersList.get(index).setName(updateUser.getName());
		this.usersList.get(index).setPhone(updateUser.getPhone());
	}
	
	// Update all information of an user
	public User updateAllInfoUser(User updateUser, Integer id)
	{
		// Create an user -1 for when it isn't in the list
		User searchUser = new User();
		// Index: User's position in the list
		int index = this.getUserById(id.intValue());
		// If the user is in the list execute the action
		if(index != -1)
		{
			// Update the list with the user's information
			this.updateList(index, updateUser);
			// Return updated user
			searchUser = this.usersList.get(index);
		}
		
		return searchUser;
	}
	
	// Apply the changes in JsonNode user
	private User applyPatchToUser(JsonPatch patch, User targetUser) throws JsonProcessingException, JsonPatchException
	{
		// Create object to map an user to JsonNode
		ObjectMapper objectMapper = new ObjectMapper();
		// Convert user to JsonNode and mix with the patch
		JsonNode patched = patch.apply(objectMapper.convertValue(targetUser, JsonNode.class));
		// Convert JsonNode to User
		return objectMapper.treeToValue(patched, User.class);
	}
	
	// Update some fields of an user such as email
	public User updateFieldsUser(JsonPatch patch, Integer id)
	{
		// Create an user -1 for when it isn't in the list
		User searchUser = new User();
		// Index: User's position in the list
		int index = this.getUserById(id.intValue());
		// If the user is in the list execute the action
		if(index != -1)
		{
			try
			{
				// Get updated user
				User userPatched = this.applyPatchToUser(patch, this.usersList.get(index));
				// Update the list with user's information
				this.updateList(index, userPatched);
				// Return updated user
				searchUser = this.usersList.get(index);
			}
			catch (JsonPatchException | JsonProcessingException e) 
			{
		        return searchUser;
		    } 
		}
		
		return searchUser;		
	}
	
	// Delete an user
	public String deleteUser(Integer id)
	{
		// Response
		String response = "User not found";
		// Index: User's position in the list
		int index = this.getUserById(id.intValue());
		// If the user is in the list execute the action
		if(index != -1)
		{
			// Delete the user from the list
			this.usersList.remove(index);
			// Set successful message
			response = "Deleted user";
		}
		
		return response;		
	}

}
