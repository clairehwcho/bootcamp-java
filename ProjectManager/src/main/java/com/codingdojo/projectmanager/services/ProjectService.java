package com.codingdojo.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

	// ===== CONSTRUCTORS =====
	// dependency injection of repository
	// the variable 'userRepository' will call all the methods in the repository
	// Same as:
	// private final UserRepository userRepository;
	// public UserService(UserRepository userRepository){
	// this.userRepository = userRepository;
	// }
	@Autowired
	private ProjectRepository projectRepository;

	// ===== METHODS =====
	// CREATE
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	// READ
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public Project getOneProjectById(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if (optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}

	public List<Project> getAssignedUser(User user) {
		return projectRepository.findAllByUsers(user);
	}

	public List<Project> getUnassignedUsers(User user) {
		return projectRepository.findByUsersNotContains(user);
	}

	// UPDATE
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	// DELETE
	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}
}
