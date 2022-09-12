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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
	// ===== PRIMARY KEY =====
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    // ===== MEMBER VARIABLES =====
    @NotEmpty
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters.")
	private String name;
	
    // ===== RELATIONSHIPS =====
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "categories_products",
			joinColumns = @JoinColumn(name = "category_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	
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
	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
