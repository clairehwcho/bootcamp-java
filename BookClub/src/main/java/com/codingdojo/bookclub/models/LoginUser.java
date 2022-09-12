package com.codingdojo.bookclub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// The 'LoginUser' model will be used for validating input from the login form
// We will never save LoginUser object instances to the database
// This model does not have the @Entity annotation
// We only use it temporarily, whenever users log in just to validate their form input. After form input passes or doesn't pass validation and authentication, that LoginUser instance disappears.
public class LoginUser {
	
	// ===== MEMBER VARIABLES =====
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    
    // ===== CONSTRUCTORS =====
    public LoginUser() {}

    
    // ===== GETTERS & SETTERS =====
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
