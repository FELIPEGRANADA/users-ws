package com.example.users.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.entities.User;
import com.example.users.services.UsersService;
import com.github.fge.jsonpatch.JsonPatch;

// Class that represents API for the web service
@RestController
public class UsersApi 
{
	@Autowired
	UsersService usersService;
	
	// Create an user 
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User createUser(@RequestBody User newUser)
	{
		return usersService.createUser(newUser);
	}
	
	// List all users
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> listUsers()
	{
		return usersService.listUsers();
	}
	
	// Get user by identifier
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable Integer id)
	{
		return usersService.getUser(id);
	}
	
	// Update all information of an user
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public User updateAllInfoUser(@RequestBody User updateUser, @PathVariable Integer id)
	{
		return usersService.updateAllInfoUser(updateUser, id);
	}
	
	// Update some fields of an user such as email
	@RequestMapping(value="/users/{id}", consumes="application/json-patch+json", method=RequestMethod.PATCH)
	public User updateFieldsUser(@RequestBody JsonPatch patch, @PathVariable Integer id)
	{
		return usersService.updateFieldsUser(patch, id);
	}
	
	// Delete an user
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer id)
	{
		return usersService.deleteUser(id);
	}
}
