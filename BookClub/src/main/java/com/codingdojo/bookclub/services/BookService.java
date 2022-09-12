package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {

	// ===== CONSTRUCTORS =====
	// dependency injection of repository
	// the variable 'userRepository' will call all the methods in the repository
	// Same as:
	// private final UserRepository userRepository;
	// public UserService(UserRepository userRepository){
	// this.userRepository = userRepository;
	// }
	@Autowired
	private BookRepository bookRepository;
	
	// ===== METHODS =====
	// CREATE & UPDATE
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	// READ
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book getOneBookById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// DELETE
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}	
}
