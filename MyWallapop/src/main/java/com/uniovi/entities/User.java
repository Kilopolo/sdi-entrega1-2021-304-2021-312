package com.uniovi.entities;

public class User {
	
	private String email;
	private String name;
	private String lastName;
	private String password;
	private Double money;
	private String role;
	
	public User(String email, String name, String lastName, String password, Double money, String role) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.money = money;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
