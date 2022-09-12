package com.codingdojo.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.savetravels.models.Expense;

@Repository
//extends CrudRepository<Model, primary key type>
//CrudRespository allows us to do CRUD operations and queries
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// custom methods
	List<Expense> findAll();
	List<Expense> findByDescriptionContaining(String search);
	
}
