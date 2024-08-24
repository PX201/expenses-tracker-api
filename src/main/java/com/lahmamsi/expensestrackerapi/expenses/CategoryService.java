package com.lahmamsi.expensestrackerapi.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	CategoryReository categoryRepo;
	
	public Category AddCategory(String name) {
		return categoryRepo.save(new Category(name));
		
	}
}
