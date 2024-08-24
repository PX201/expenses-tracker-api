package com.lahmamsi.expensestrackerapi.expenses;

public class AmountDto {
	private double amount;
	private double AmountPercentage;
	
	public AmountDto(double amount, double total) {
		
		this.amount = amount;
		this.AmountPercentage = amount * 100 / total;
	}

	public double getAmount() {
		return amount;
	}

	public double getAmountPercentage() {
		return AmountPercentage;
	}
	
	

}
