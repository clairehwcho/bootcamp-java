package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	@RequestMapping("")
	public String indexRedirect() {
		return "redirect:/books";
	}

	@Autowired
	BookService bookService;

	@GetMapping("/books/{id}")
	// dependency injection using view model 'Model model'	
	public String index(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}

	@RequestMapping("/books")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookService.getAllBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}

}
