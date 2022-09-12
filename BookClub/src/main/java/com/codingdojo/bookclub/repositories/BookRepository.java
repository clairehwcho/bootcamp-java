package com.codingdojo.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.Book;

@Repository
//extends CrudRepository<Model, primary key type>
//CrudRespository allows us to do CRUD operations and queries
public interface BookRepository extends CrudRepository<Book, Long> {
	// ===== METHODS =====
	List<Book> findAll();
}
