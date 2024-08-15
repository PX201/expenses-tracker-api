package com.lahmamsi.expensestrackerapi.expenses;

import java.util.List;

import com.lahmamsi.expensestrackerapi.exceptions.ExpensesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/expenses")
public class ExpensesResource {
	@Autowired
	ExpensesService service;

	@PostMapping("")
	public ResponseEntity<Expenses> addExpences(@Validated @RequestBody ExpensesDto expensesDto) {
		try {
			Expenses expenses = service.addExpences(expensesDto);
			return new ResponseEntity<Expenses>(expenses, HttpStatus.CREATED);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Expenses>> retrieveAllExpenses(long userId) {

		return ResponseEntity.accepted().body(service.getAllExpenses(userId));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Expenses> retrieveExpenses(long userId, long expensesId) throws ExpensesNotFoundException {

		return ResponseEntity.accepted().body(service.getExpenses(userId, expensesId));
	}
}
