package com.lahmamsi.expensestrackerapi.expenses;

import java.util.HashMap;
import java.util.Map;

public class ExpensesReport {

	private Map<String, AmountDto> expensesReportMap;
	private double total;


	public ExpensesReport(Map<String, AmountDto> expensesReportMap, double total) {
		// TODO Auto-generated constructor stub
		this.expensesReportMap = expensesReportMap;
		this.total = total;
		
	}
	
	
	
	
	public Map<String, AmountDto> getExpensesReportMap() {
		return expensesReportMap;
	}




	public double getTotal() {
		return total;
	}




	public static ExpensesReport of(Map<String, Double> expensesAmountByCategory, double total) {
		
		Map<String, AmountDto> expensesReportMap = new HashMap<String, AmountDto>();
		
		expensesAmountByCategory.forEach((category, amount) -> expensesReportMap.put(category, new AmountDto(amount, total)));
		
		return new ExpensesReport(expensesReportMap, total);
		
		
	}
	
	

	

}