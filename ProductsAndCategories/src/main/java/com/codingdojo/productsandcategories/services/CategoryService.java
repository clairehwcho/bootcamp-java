package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	// ===== CONSTRUCTORS =====
	// dependency injection of repository
	// the variable 'userRepository' will call all the methods in the repository
	// Same as:
	// private final UserRepository userRepository;
	// public UserService(UserRepository userRepository){
	// this.userRepository = userRepository;
	// }
	@Autowired
	private CategoryRepository categoryRepository;
	
	// ===== METHODS =====
	// CREATE & UPDATE
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	// READ
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getOneCategoryById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public List<Category> getAssignedProducts(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedProducts(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}

	
	// DELETE
	public void deleteCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			categoryRepository.deleteById(id);
		}
	}
}
