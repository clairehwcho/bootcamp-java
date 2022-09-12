package com.codingdojo.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dojos")
public class Dojo {
	// MEMBER VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 255, message = "Field is required.")
	private String name;

	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;

	// This will map the ninjas attribute in the Dojo class to the dojo attribute in the Ninja class
	@OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
	// Notice that in this case, our ninjas attribute is of type List<Ninja>
	private List<Ninja> ninjas;

	// CONTSTRUCTOR
	public Dojo() {
	}
	
	public Dojo(Long id, String name, Date createdAt, Date updatedAt, List<Ninja> ninjas) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.ninjas = ninjas;
	}

	// GETTERS & SETTERS
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

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	
}
