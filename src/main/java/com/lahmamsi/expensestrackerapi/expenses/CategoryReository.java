package com.lahmamsi.expensestrackerapi.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReository extends JpaRepository<Category, Integer>{

}
