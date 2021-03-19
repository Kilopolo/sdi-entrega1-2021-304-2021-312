package com.uniovi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String email;
	private String name;
	private String lastName;
	private String password;
	@Transient // propiedad que no se almacena e la tabla.
	private String passwordConfirm;
	private Double money;
	private String role;
	
	public User(String email, String name, String lastName, String password) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.role = "ROLE_USER";
		this.money = 100.0;
	}

	public User() { 
		
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

	public void setPasswortdConfirm(String p) {
		this.passwordConfirm = p;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", lastName=" + lastName + "]";
	}
	
	
	
	
}
