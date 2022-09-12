package com.codingdojo.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

	// ===== PRIMARY KEY =====
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // ===== MEMBER VARIABLES =====
    @NotEmpty(message="Title is required.")
    @Size(min=3, max=30, message="Title must be between 3 and 30 characters.")
    private String title;
    
    @NotEmpty(message="Author is required.")
    @Size(min=3, max=30, message="Author must be between 3 and 30 characters.")
    private String author;
    
    @NotEmpty(message="Thoughts is required.")
    @Size(min=3, max=200, message="Thoughts must be between 3 and 200 characters.")
    private String thought;
    
    // ===== RELATIONSHIPS =====
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @NotNull
    private User user;
    
    // ===== DATA CREATION TRACKERS =====
    @Column(updatable=false)
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
    public Book() {
    }
    
	public Book(Long id, String title, String author, String thought, User user, Date createdAt, Date updatedAt) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.thought = thought;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// ===== GETTERS & SETTERS =====
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThought() {
		return thought;
	}

	public void setThought(String thought) {
		this.thought = thought;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
