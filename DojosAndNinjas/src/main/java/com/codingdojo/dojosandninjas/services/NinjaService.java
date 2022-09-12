package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// dependency injection of repository
	// the variable 'ninjaRepository' will call all the methods in the repository
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	// METHODS to wrap up CrudRepository interface

	// gets all the ninjas
	public List<Ninja> getAllNinjas() {
		return ninjaRepository.findAll();
	}

	// creates an ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	// gets one ninja
	public Ninja getOneNinja(Long id) {
		// Optional means the object can exist or not
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
