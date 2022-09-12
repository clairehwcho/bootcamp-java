package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookController {

	// ===== MEMBER VARIABLES =====
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;


	// ===== METHODS =====
	// ----- DISPLAY -----
	// DASHBOARD PAGE
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		// If no currentUser is found in session, redirect to logout
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}

		// Else, we get the currentUser from the session
		// Cast the result to a Long
		// as the 'session.getAttribute("currentUser") returns an object
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		
		// get all books
		List<Book> books = bookService.getAllBooks();
		
		model.addAttribute("books", books);
		
		return "dashboard.jsp";
	}

	// ADD A NEW BOOK PAGE
	@GetMapping("/books/new")
	public String books(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		
		return "add.jsp";
	}
	
	// SHOW A BOOK PAGE
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		Book book = bookService.getOneBookById(id);
		model.addAttribute("book", book);
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));

		return "show.jsp";
	}

	// EDIT A BOOK PAGE
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		Book book = bookService.getOneBookById(id);
		model.addAttribute("book", book);
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		
		return "edit.jsp";
	}
	
	// ----- ACTIONS -----
	@PostMapping("/createBook")
	public String createBooK(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "add.jsp";
		} else {
			bookService.saveBook(book);
			return "redirect:/books";
		}
	}

	@PutMapping("/{id}/update")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "edit.jsp";
		} else {
			bookService.saveBook(book);
			return "redirect:/books/{id}";
		}
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}