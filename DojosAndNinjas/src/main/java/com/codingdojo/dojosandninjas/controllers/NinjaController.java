package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	// allows Spring to resolve and inject collaborating beans into our bean
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	// dependency injection of @ModelAttribute for data binding
	// 1. add an empty ninja object to the view model in the get route that
	// renders the form
	// same as:
	// public String ninjas(Model model) {model.addAttribute("ninjas", new Ninja());
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Ninja> ninjas = ninjaService.getAllNinjas();
		model.addAttribute("ninjas", ninjas);
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		// 2. render the view
		return "addNinja.jsp";
	}

	// 3. fill the object with the form data

	@PostMapping("/addNinja")
	public String createNewNinja(
			// 4. pass the filled object from the view model into the post method
			@Valid @ModelAttribute("ninja") Ninja ninja,
			// use the result variable which collects information about the object to handle error
			// the BindingResult parameter must be immediately following the annotated @ModelAttribute parameter
			BindingResult result, Model model, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			List<Ninja> ninjas = ninjaService.getAllNinjas();
			model.addAttribute("ninjas", ninjas);
			return "addNinja.jsp";
		} else {
			// 5. save the new object back to the database
			ninjaService.createNinja(ninja);
			redirectAttrs.addAttribute("id",ninja.getDojo());
			return "redirect:/dojos/{id}";
		}
	}


}
