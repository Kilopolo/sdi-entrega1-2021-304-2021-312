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
	
	public User() { 	
	}
	/**
	 * Uses "123456" as password, "ROLE_USER" as default role and '100.0' as default money.
	 * @param email
	 * @param name
	 * @param lastName
	 */
	public User(String email, String name, String lastName) {
		this(email,name,lastName,"123456");
	}
	
	/**
	 * Uses "ROLE_USER" as default role and '100.0' as default money.
	 * @param email
	 * @param name
	 * @param lastName
	 * @param password
	 */
	public User(String email, String name, String lastName, String password) {
		this(email,name,lastName,"default",100.0,"ROLE_USER");
	}



	public User(String email, String name, String lastName, String password, Double money,
			String role) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.money = money;
		this.role = role;
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
		return "" + email + ", " + money + " euros";
	}

	
	
	
}
