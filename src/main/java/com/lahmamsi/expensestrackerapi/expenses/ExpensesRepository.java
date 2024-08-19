package com.lahmamsi.expensestrackerapi.expenses;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpensesRepository extends JpaRepository<Expenses, Long>{

	List<Expenses> findAllByUserId(long user);

	Optional<Expenses> findByIdAndUserId(long expensesId, long userId);

	void deleteByIdAndUserId(long expensesId, long userId);

	@Query("SELECT new com.lahmamsi.expensestrackerapi.expenses.ExpensesReport( " +
		       "c.name, SUM(e.amount), " +
		       "(SUM(e.amount) / (SELECT SUM(e2.amount) FROM Expense e2 WHERE e2.user.id = :userId AND e2.date BETWEEN :startDate AND :endDate) * 100)) " +
		       "FROM Expense e " +
		       "JOIN e.category c " +
		       "WHERE e.user.id = :userId AND e.date BETWEEN :startDate AND :endDate " +
		       "GROUP BY c.name")
	List<ExpensesReport> getExpenseReport(@Param("userId") long userId,
		                                      @Param("startDate") LocalDate startDate,
		                                      @Param("endDate") LocalDate endDate);

}
