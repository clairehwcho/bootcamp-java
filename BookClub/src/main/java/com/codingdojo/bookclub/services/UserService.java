package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class UserService {

	// ===== CONSTRUCTORS =====
	// dependency injection of repository
	// the variable 'userRepository' will call all the methods in the repository
	// Same as:
	// private final UserRepository userRepository;
	// public UserService(UserRepository userRepository){
	// this.userRepository = userRepository;
	// }
	@Autowired
	private UserRepository userRepository;

	// ===== METHODS =====
	// REGISTER
	// newUser is an object with the information from the register form
	public User register(User newUser, BindingResult result) {

		// 1. Check and reject if email is taken (present in database)
		if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Matches", "Email is already in use.");
		}

		// 2. Check and reject if password doesn't match confirmation
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password.");
		}

		// 3. Final check to see if there are errors
		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}
		// 4. Hash and set password, save user to database
		// Hash the password and set the newUser object's password to the new hash
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);

		return userRepository.save(newUser);

	}

	// LOGIN
	public User login(LoginUser newLoginUser, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}

		// 1. Check to see if the user with the entered email exists
		Optional<User> potentialUser = userRepository.findByEmail(newLoginUser.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email does not exists.");
			// If the email is not found, skip checking the password and just return null
			return null;
		}

		// 2. If the email exists, get the User object from the Optional
		User user = potentialUser.get();
		// 3. Check and reject if BCrypt password doesn't match
		// Return null if result has errors
		if (!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		}
		// Otherwise, return the user object
		return user;
	}

	
	// GET ALL USERS
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	// GET A USER BY ID
	public User getUserById(Long id) {
		Optional<User> potentialUser = userRepository.findById(id);
		if (potentialUser.isPresent()) {
			return potentialUser.get();
		}
		return null;
	}

}
