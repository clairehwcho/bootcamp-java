package com.codingdojo.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;

@Repository
//extends CrudRepository<Model, primary key type>
//CrudRespository allows us to do CRUD operations and queries
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// ===== METHODS =====
	List<Category> findAll();
	Category findByIdIs(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
