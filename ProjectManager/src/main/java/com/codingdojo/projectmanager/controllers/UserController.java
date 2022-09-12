package com.codingdojo.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.projectmanager.models.LoginUser;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.UserService;

@Controller
public class UserController {

	// ===== MEMBER VARIABLES =====
	@Autowired
	private UserService userService;

	// ===== METHODS =====
	// ----- DISPLAY -----
	// LOGIN & REGISTRATION PAGE
	// Same as:
	// @GetMapping("")
	// public String index(@ModelAttribute("newUser") User newUser,
	// @ModelAttribute("newLogin") LoginUser newLogin){
	// return "index.jsp";
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("currentUser") !=null) {
			return "redirect:/dashboard";
		}

		// Add an empty User and LoginUser object to the view model in the get route that renders the form
		// Bind empty User and LoginUser objects to the JSP to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	// ----- ACTIONS -----
	// REGISTER
	// Pass the object filled with the form data from the view model into the post method
	// Use the result variable which collects information about the object to handle error
	// The BindingResult parameter must be immediately following the annotated
	// @ModelAttribute parameter
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// Call a register method in the service
		User user = userService.register(newUser, result);

		// Do some extra validations and create a new user
		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		// If no errors,store their ID from the DB in session
		session.setAttribute("currentUser", user.getId());
		return "redirect:/dashboard";
	}
	
	// LOGIN
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("currentUser", user.getId());
		return "redirect:/dashboard";
	}
	
	// LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("currentUser");
		return "redirect:";
	}

}
