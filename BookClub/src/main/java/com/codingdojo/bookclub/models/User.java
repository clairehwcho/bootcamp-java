package com.codingdojo.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// This 'User' model will be used to create new users in the database
@Entity
@Table(name = "users")
public class User {

	// ===== PRIMARY KEY =====
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ===== MEMBER VARIABLES =====
	@NotEmpty(message = "Name is required.")
	@Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters.")
	private String name;

	@NotEmpty(message = "Email is required.")
	@Email(message = "Please enter a valid email.")
	private String email;

	@NotEmpty(message = "Password is required.")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters.")
	private String password;

	// @Transient allows us to use the confirm password on an instance of User temporarily,
	// without ever storing it to the database
	@Transient
	@NotEmpty(message = "Confirm Password is required.")
	@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters.")
	private String confirmPassword;

	// ===== RELATIONSHIPS =====
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Book> books;
	
	// ===== DATA CREATION TRACKERS =====
	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;
	
	// ===== DATA CREATION EVENT =====
	// Save the date that the object is created at
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	// Save the date that the object is updated at
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// ===== CONSTRUCTORS =====
	public User() {
	}

	public User(Long id, String name, String email, String password, String confirmPassword, List<Book> books,
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.books = books;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// ===== GETTERS &SETTERS =====

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
