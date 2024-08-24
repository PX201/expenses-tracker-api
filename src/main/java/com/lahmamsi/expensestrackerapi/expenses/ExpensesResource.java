package com.lahmamsi.expensestrackerapi.expenses;

import java.time.LocalDate;
import java.util.List;

import com.lahmamsi.expensestrackerapi.exceptions.CategoryNotFoundException;
import com.lahmamsi.expensestrackerapi.exceptions.ExpensesNotFoundException;
import com.lahmamsi.expensestrackerapi.exceptions.UserNotFoundException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/expenses")
@Controller
public class ExpensesResource {
	@Autowired
	ExpensesService service;

	@PostMapping("")
	public ResponseEntity<Expenses> addExpences(@Validated @RequestBody ExpensesDto expensesDto) {
		try {
			Expenses expenses = service.addExpences(expensesDto);
			return new ResponseEntity<Expenses>(expenses, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Catched");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Expenses>> retrieveAllExpenses(@PathVariable(value = "userId") long userId) {

		return ResponseEntity.accepted().body(service.getAllExpenses(userId));
	}

	@GetMapping("/{id}/{userId}")
	public ResponseEntity<Expenses> retrieveExpenses(@PathVariable(value = "id") long userId,
			@PathParam(value = "UserId") long expensesId) throws ExpensesNotFoundException {
		return ResponseEntity.accepted().body(service.getExpenses(userId, expensesId));
	}

	@DeleteMapping("/{id}/{userId}")
	public ResponseEntity<Void> deleteExpenses(@PathVariable(value = "id") long expensesId,
			@PathParam(value = "UserId") long userId) {

		service.deleteExpences(userId, expensesId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateExpensesInfo(@PathVariable(value = "id") long expensesId,
			@RequestBody ExpensesDto expensesDto)
			throws ExpensesNotFoundException, CategoryNotFoundException, UserNotFoundException {

		service.updateExpences(expensesId, expensesDto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@GetMapping("/{userId}/{from}/{to}")
	public ResponseEntity<ExpensesReport> getExpensesReport(@PathVariable(value = "userId") long userId,
			@PathVariable(value = "from") LocalDate from, @PathVariable(value = "to") LocalDate to) {

		return 	ResponseEntity.accepted().body(service.getExpensesReport(userId, from, to));

	}

}
