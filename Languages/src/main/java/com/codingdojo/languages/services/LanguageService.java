package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// dependency injection of repository
	// the variable 'languageRepository' will call all the methods in the repository
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	// METHODS to wrap up CrudRepository interface

	// gets all the languages
	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	// creates an language
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}

	public Language getOneLanguage(Long id) {
		// Optional means the object can exist or not
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}

	public void deleteLanguage(Language language) {
		languageRepository.delete(language);
	}
}
