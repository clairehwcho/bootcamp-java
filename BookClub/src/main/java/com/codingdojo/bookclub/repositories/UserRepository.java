package com.codingdojo.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.User;

@Repository
//extends CrudRepository<Model, primary key type>
//CrudRespository allows us to do CRUD operations and queries
public interface UserRepository extends CrudRepository<User, Long>{

	// ===== METHODS =====
	List<User> findAll();
	
    Optional<User> findByEmail(String email);
}
