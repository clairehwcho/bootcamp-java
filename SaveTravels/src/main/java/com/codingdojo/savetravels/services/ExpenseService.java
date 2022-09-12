package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// dependency injection of repository
	// the variable 'expenseRepository' will call all the methods in the repository
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	// METHODS to wrap up CrudRepository interface

	// gets all the expenses
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	// creates an expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	public Expense getOneExpense(Long id) {
		// Optional means the object can exist or not
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}
	}
}
