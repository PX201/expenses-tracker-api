package com.lahmamsi.expensestrackerapi.expenses;

import java.time.LocalDate;

import com.lahmamsi.expensestrackerapi.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private double amount;

	private String description;

	private LocalDate date;

	private Category category;

	@ManyToOne
	private User user;

	public Expenses() {
		// TODO Auto-generated constructor stub
	}

	public Expenses(double amount, String description, LocalDate date, Category category, User user) {
		super();
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.category = category;
		this.user = user;
	}

	public Expenses(long id, double amount, String description, LocalDate date, Category category, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.category = category;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
