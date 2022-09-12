package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	// allows Spring to resolve and inject collaborating beans into our bean
	@Autowired
	ExpenseService expenseService;

	@GetMapping("")
	public String index() {
		return "redirect:/expenses";
	}

	@GetMapping("/expenses")
	// dependency injection of @ModelAttribute for data binding
	// 1. add an empty expense object to the view model in the get route that renders the form
	// same as:
	// public String expenses(Model model) {model.addAttribute("expenses", new Expense());
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.getAllExpenses();
		model.addAttribute("expenses", expenses);
		// 2. render the view
		return "index.jsp";
	}

	// 3. fill the object with the form data

	@PostMapping("/addExpenses")
	public String create(
			// 4. pass the filled object from the view model into the post method
			@Valid @ModelAttribute("expense") Expense expense,
			// use the result variable which collects information about the object to handle error
			// the BindingResult parameter must be immediately following the annotated @ModelAttribute parameter
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.getAllExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			// 5. save the new object back to the database
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getOneExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}

	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getOneExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}

	@PutMapping(value = "/update/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	// same as:
	// @DeleteMapping("/delete/{id}")	
    @RequestMapping(value="/delete/{id}", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}
