package com.codingdojo.productsandcategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	// ===== PRIMARY KEY =====
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // ===== MEMBER VARIABLES =====
    @NotEmpty
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters.")
    private String name;

    @NotEmpty
    @Size(min=3, max=30, message="Description must be between 3 and 30 characters.")
    private String description;
    
    @NotNull
	@Min(value = 1, message = "Amount must be greater than 0")
    private double price;
    
    // ===== RELATIONSHIPS =====
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    
    
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
    public Product() {   
    }
    
    public Product(String name, String description, double price) {
    	this.name = name;
    	this.description = description;
    	this.price = price;
    }
    
	// ===== GETTERS & SETTERS =====
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
    
    
}