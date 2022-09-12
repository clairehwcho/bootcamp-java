package com.codingdojo.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.models.Dojo;

@Repository
//extends CrudRepository<Model, primary key type>
//CrudRespository allows us to do CRUD operations and queries
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	// custom methods
	List<Dojo> findAll();
	
}
