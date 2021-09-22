package com.example.users.entities;

// Class Entity User
public class User 
{
	// User identifier
	private int id;
	// User login
	private String username;
	// User password
	private String password;
	// User email
	private String email;
	// User name
	private String name;
	// User phone
	private String phone;
	
	// Class constructor
	public User()
	{
		this.id = -1;
		this.username = "";
		this.password = "";
		this.email = "";
		this.name = "";
		this.phone = "";
	}
	
	public User(int id, String username, String password, String email, String name, String phone) 
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	
	// Set and Get Methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
		
}
