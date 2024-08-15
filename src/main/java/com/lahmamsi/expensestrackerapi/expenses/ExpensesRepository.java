package com.lahmamsi.expensestrackerapi.expenses;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Long>{

	List<Expenses> findAllByUserId(long user);

	Optional<Expenses> findByIdAndUserId(long expensesId, long userId);

}
