package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	// ===== CONSTRUCTORS =====
	// dependency injection of repository
	// the variable 'userRepository' will call all the methods in the repository
	// Same as:
	// private final UserRepository userRepository;
	// public UserService(UserRepository userRepository){
	// this.userRepository = userRepository;
	// }
	@Autowired
	private ProductRepository productRepository;
	
	// ===== METHODS =====
	// CREATE & UPDATE
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	// READ
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getOneProductById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public List<Product> getAssignedCategories(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedCategories(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}

	
	// DELETE
	public void deleteProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			productRepository.deleteById(id);
		}
	}
}
