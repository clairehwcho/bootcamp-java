package com.codingdojo.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.UserService;

@Controller
public class ProjectController {

	// ===== MEMBER VARIABLES =====
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;


	// ===== METHODS =====
	// ----- DISPLAY -----
	// DASHBOARD PAGE
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		// If no currentUser is found in session, redirect to logout
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}

		// Else, we get the currentUser from the session
		// Cast the result to a Long
		// as the 'session.getAttribute("currentUser") returns an object
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		model.addAttribute("unassignedProjects",projectService.getUnassignedUsers(userService.getUserById(currentUser)));
		model.addAttribute("assignedProjects",projectService.getAssignedUser(userService.getUserById(currentUser)));
				
		return "dashboard.jsp";
	}

	// ADD A NEW PROJECT PAGE
	@GetMapping("/projects/new")
	public String showNewProject(@ModelAttribute("project") Project project, HttpSession session, Model model) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		
		return "add.jsp";
	}
	
	// SHOW A PROJECT PAGE
	@GetMapping("/projects/{id}")
	public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		Project project = projectService.getOneProjectById(id);
		model.addAttribute("project", project);
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));

		return "show.jsp";
	}

	// EDIT A PROJECT PAGE
	@GetMapping("/projects/edit/{id}")
	public String showEditProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		Project project = projectService.getOneProjectById(id);
		model.addAttribute("project", project);
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		
		return "edit.jsp";
	}
	
	// SHOW TASKS PAGE
	@GetMapping("/projects/{id}/tasks")
	public String showTasks(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("currentUser") == null) {
			return "redirect:/logout";
		}
		Project project = projectService.getOneProjectById(id);
		model.addAttribute("project", project);
		
		Long currentUser = (Long) session.getAttribute("currentUser");
		model.addAttribute("user", userService.getUserById(currentUser));
		
		return "tasks.jsp";
	}
	
	// ----- ACTIONS -----
	@PostMapping("/createProject")
	public String createBooK(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "add.jsp";
		} else {
			projectService.createProject(project);
			return "redirect:/dashboard";
		}
	}

	@PutMapping("/{id}/update")
	public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "edit.jsp";
		} else {
			projectService.updateProject(project);
			return "redirect:/projects/{id}";
		}
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteProject(@PathVariable("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/projects";
	}
}