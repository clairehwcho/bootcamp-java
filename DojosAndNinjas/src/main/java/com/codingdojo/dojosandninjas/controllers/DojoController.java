package com.codingdojo.dojosandninjas.controllers;

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

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {

	// allows Spring to resolve and inject collaborating beans into our bean
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;

	@GetMapping("/dojos/new")
	// dependency injection of @ModelAttribute for data binding
	// 1. add an empty dojo object to the view model in the get route that renders the form
	// same as:
	// public String dojos(Model model) {model.addAttribute("dojos", new Dojo());
	public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		// 2. render the view
		return "addDojo.jsp";
	}

	// 3. fill the object with the form data

	@PostMapping("/addDojo")
	public String createNewDojo(
			// 4. pass the filled object from the view model into the post method
			@Valid @ModelAttribute("dojo") Dojo dojo,
			// use the result variable which collects information about the object to handle error
			// the BindingResult parameter must be immediately following the annotated @ModelAttribute parameter
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "addDojo.jsp";
		} else {
			// 5. save the new object back to the database
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.getOneDojo(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> ninjas = ninjaService.getAllNinjas();
		model.addAttribute("ninjas", ninjas);
		return "showNinjas.jsp";
	}

}
