package com.lahmamsi.expensestrackerapi.expenses;

import java.time.LocalDate;

public class ExpensesDto {

	private long userId;

	private double amount;

	private String description;

	private LocalDate date;

	private int categoryId;

	public ExpensesDto() {
		// TODO Auto-generated constructor stub
	}

	public ExpensesDto(long userId, double amount, String description, LocalDate date, int categoryId) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.categoryId = categoryId;
	}
	
	public ExpensesDto( double amount, String description, LocalDate date, int categoryId) {
		super();
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.categoryId = categoryId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
