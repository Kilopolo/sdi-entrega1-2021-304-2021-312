package com.uniovi.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Transient
	private String passwordConfirm;
	@Transient
	private boolean enoughMoney = true;
	private Double money;
	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Offer> offers;

	public User() {
	}

	/**
	 * Uses "123456" as password, "ROLE_USER" as default role and '100.0' as default
	 * money.
	 * 
	 * @param email
	 * @param name
	 * @param lastName
	 */
	public User(String email, String name, String lastName) {
		this.email = email;
		this.name = name;
		this.lastName = lastName;
	}
	

	public boolean getEnoughMoney() {
		return enoughMoney;
	}

	public void setEnoughMoney(boolean enoughMoney) {
		this.enoughMoney = enoughMoney;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public void setId(long id) {
		this.id = id;
	}

	// public String getPassword2() {
//		return password2;
//	}
//	public void setPassword2(String password2) {
//		this.password2 = password2;
//	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Long getId() {
		return id;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	@Override
	public String toString() {
		return "" + email + ".	[" + money + " €]";
	}

}
