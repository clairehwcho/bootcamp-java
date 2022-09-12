package com.codingdojo.languages.controllers;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {

	// allows Spring to resolve and inject collaborating beans into our bean
	@Autowired
	LanguageService languageService;

	@GetMapping("")
	public String index() {
		return "redirect:/languages";
	}

	@GetMapping("/languages")
	// dependency injection of @ModelAttribute for data binding
	// 1. add an empty language object to the view model in the get route that renders the form
	// same as:
	// public String languages(Model model) {model.addAttribute("languages", new Language());
	public String languages(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.getAllLanguages();
		model.addAttribute("languages", languages);
		// 2. render the view
		return "index.jsp";
	}

	// 3. fill the object with the form data

	@PostMapping("/addLanguage")
	public String create(
			// 4. pass the filled object from the view model into the post method
			@Valid @ModelAttribute("language") Language language,
			// use the result variable which collects information about the object to handle error
			// the BindingResult parameter must be immediately following the annotated @ModelAttribute parameter
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Language> languages = languageService.getAllLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		} else {
			// 5. save the new object back to the database
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.getOneLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}

	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.getOneLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	// same as:
	// @Putmapping(value="/update/{id}")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	// same as:
	// @DeleteMapping("/delete/{id}")	
    @RequestMapping(value="/delete/{id}", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(languageService.getOneLanguage(id));
        return "redirect:/languages";
    }
}
