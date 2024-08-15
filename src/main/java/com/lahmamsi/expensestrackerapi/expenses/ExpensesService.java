package com.lahmamsi.expensestrackerapi.expenses;

import java.util.List;

import com.lahmamsi.expensestrackerapi.exceptions.CategoryNotFoundException;
import com.lahmamsi.expensestrackerapi.exceptions.ExpensesNotFoundException;
import com.lahmamsi.expensestrackerapi.exceptions.UserNotFoundException;
import com.lahmamsi.expensestrackerapi.user.UserRepository;

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
	
	

}
