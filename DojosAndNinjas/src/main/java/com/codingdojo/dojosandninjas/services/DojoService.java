package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	// dependency injection of repository
	// the variable 'expenseRepository' will call all the methods in the repository
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	// METHODS to wrap up CrudRepository interface

	// gets all the dojos
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}

	// creates a dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	// gets one dojo
	public Dojo getOneDojo(Long id) {
		// Optional means the object can exist or not
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
