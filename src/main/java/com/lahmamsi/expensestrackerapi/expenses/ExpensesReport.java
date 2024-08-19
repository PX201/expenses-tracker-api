package com.lahmamsi.expensestrackerapi.expenses;

public class ExpensesReport {

	private String category;
	private double totalAmount;
	private double percentage;

	public ExpensesReport(String category, double totalAmount, double percentage) {
		super();
		this.category = category;
		this.totalAmount = totalAmount;
		this.percentage = percentage;
	}

	public ExpensesReport() {
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}