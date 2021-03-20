package com.uniovi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String title;
	private String details;
	private Date orderDate;
	private boolean available;
	private double amount;
	
	public Offer() {
	}
	
	public Offer(String title, String details, double amount) {
		this.title = title;
		this.details = details;
		this.orderDate = new Date();
		this.amount = amount;
		this.available = true;
	}
	
	public Long getId() {
		return id;
	}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(boolean b) {
		this.available= b;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Offer [title=" + title + ", details=" + details + ", orderDate=" + orderDate + ", amount=" + amount
				+ "]";
	}
	
	
	

}
