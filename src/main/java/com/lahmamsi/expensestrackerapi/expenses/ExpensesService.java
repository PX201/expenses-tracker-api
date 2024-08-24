package com.lahmamsi.expensestrackerapi.expenses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lahmamsi.expensestrackerapi.exceptions.CategoryNotFoundException;
import com.lahmamsi.expensestrackerapi.exceptions.ExpensesNotFoundException;
import com.lahmamsi.expensestrackerapi.exceptions.UserNotFoundException;
import com.lahmamsi.expensestrackerapi.user.UserRepository;

@Service
public class ExpensesService {

	private ExpensesRepository expensesRepo;
	private CategoryReository categoryRepo;
	private UserRepository userRepo;

	public ExpensesService(ExpensesRepository expensesRepo, CategoryReository categoryRepo, UserRepository userRepo) {
		this.categoryRepo = categoryRepo;
		this.expensesRepo = expensesRepo;
		this.userRepo = userRepo;
	}

	public Expenses addExpences(ExpensesDto expensesDto) throws UserNotFoundException, CategoryNotFoundException {
		Expenses expenses = new Expenses();
		expenses.setAmount(expensesDto.getAmount());
		expenses.setDescription(expensesDto.getDescription());
		expenses.setDate(expensesDto.getDate());
		expenses.setCategory(categoryRepo
							.findById(expensesDto.getCategoryId())
							.orElseThrow(() -> new CategoryNotFoundException(" ")));
		expenses.setUser(userRepo
							.findById(expensesDto.getUserId())
							.orElseThrow(() -> new UserNotFoundException(" ")));
		
		return expensesRepo.save(expenses);
	}

	public List<Expenses> getAllExpenses(long userId){
		// TODO Auto-generated method stub
		return expensesRepo.findAllByUserId(userId);
	}

	public Expenses getExpenses(long userId, long expensesId) throws ExpensesNotFoundException {
		// TODO Auto-generated method stub
		return expensesRepo.findByIdAndUserId(expensesId, userId).orElseThrow(() -> new ExpensesNotFoundException(" "));
	}

	public void deleteExpences(long userId, long expensesId) {
		// TODO Auto-generated method stub
		expensesRepo.deleteByIdAndUserId(expensesId, userId);
		
	}

	public Expenses updateExpences(long expensesId, ExpensesDto expensesDto) throws ExpensesNotFoundException, CategoryNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		Expenses expenses = expensesRepo.findById(expensesId).orElseThrow(() -> new ExpensesNotFoundException(" "));
		expenses.setAmount(expensesDto.getAmount());
		expenses.setDescription(expensesDto.getDescription());
		expenses.setDate(expensesDto.getDate());
		expenses.setCategory(categoryRepo
							.findById(expensesDto.getCategoryId())
							.orElseThrow(() -> new CategoryNotFoundException(" ")));
		expenses.setUser(userRepo
							.findById(expensesDto.getUserId())
							.orElseThrow(() -> new UserNotFoundException(" ")));
		
		
		return expensesRepo.save(expenses);
		
	}

	public ExpensesReport getExpensesReport(long userId, LocalDate startDate, LocalDate endDate) {
		List<Expenses>  expensesList = new ArrayList<Expenses>();
		expensesList = expensesRepo.getAllExpenses(userId, startDate, endDate);
		double total = 0;
		
		Map<String, Double> expensesAmountByCategory = expensesList.stream()
				.collect(
						Collectors.groupingBy( e -> e.getCategory().getName() , Collectors.summingDouble(Expenses::getAmount) ));
		
		for(var e: expensesList) {
			 
			total+= e.getAmount();
		}
		
		return ExpensesReport.of(expensesAmountByCategory, total);
		
	}
	
	

}
