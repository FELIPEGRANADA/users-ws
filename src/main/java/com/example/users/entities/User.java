package com.example.users.entities;

// Clase que representa el usuario
public class User 
{
	// Identificador del usuario
	private int id;
	// Login del usuario
	private String username;
	// Contraseña del usuario
	private String password;
	// Email del usuario
	private String email;
	// Nombre del usuario
	private String name;
	// Telefóno del usuario
	private String phone;
	
	// Constructores de la clase
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
	
	// Métodos de acceso y obtención de datos
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
