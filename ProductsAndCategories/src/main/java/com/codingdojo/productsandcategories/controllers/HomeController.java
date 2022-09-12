package com.codingdojo.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
public class HomeController {

	// ===== CONSTRUCTORS =====
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	// ===== METHODS =====
	// ----- DISPLAY -----
	// HOME PAGE
	@GetMapping("/")
	public String index(Model model) {

		// get all products
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);

		// get all categories
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);

		return "index.jsp";
	}

	// NEW PRODUCT PAGE
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}

	// NEW CATEGORY PAGE
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}

	// SHOW PRODUCT PAGE
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.getOneProductById(id);
		model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
		model.addAttribute("product", product);
		return "showProduct.jsp";
	}

	// SHOW CATEGORY PAGE
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.getOneCategoryById(id);
		model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
		model.addAttribute("category", category);
		return "showCategory.jsp";
	}
	
	// EDIT PRODUCT PAGE
	@GetMapping("/products/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.getOneProductById(id);
		model.addAttribute("product", product);
		return "editProduct.jsp";
	}
	
	// EDIT CATEGORY PAGE
	@GetMapping("/categories/edit/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.getOneCategoryById(id);
		model.addAttribute("category", category);
		return "editCategory.jsp";
	}

	// ----- ACTIONS -----
	// ADD NEW PRODUCT
	@PostMapping("/createProduct")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "addProduct.jsp";
		} else {
			productService.saveProduct(product);
			return "redirect:/";
		}
	}

	// ADD NEW CATEGORY
	@PostMapping("/createCategory")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "addCategory.jsp";
		} else {
			categoryService.saveCategory(category);
			return "redirect:/";
		}
	}
	
	// ADD CATEGORY TO PRODUCT
	@PostMapping("/products/{id}")
	public String addCategoryOfProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long categoryId,
			Model model) {
		Product product = productService.getOneProductById(id);
		Category category = categoryService.getOneCategoryById(categoryId);
		product.getCategories().add(category);
		productService.saveProduct(product);
		model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
		return "redirect:/products/" + id;
	}

	// ADD PRODUCT TO CATEGORY
	@PostMapping("/categories/{id}")
	public String addProductOfCategory(@PathVariable("id") Long id, @RequestParam(value = "productId") Long productId, Model model) {
		Category category = categoryService.getOneCategoryById(id);
		Product product = productService.getOneProductById(productId);
		category.getProducts().add(product);
		categoryService.saveCategory(category);
		model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
		return "redirect:/categories/" + id;
	}

	// EDIT PRODUCT
	@PutMapping("/products/{id}/update")
	public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "addProduct.jsp";
		} else {
			productService.saveProduct(product);
			return "redirect:/";
		}
	}

	// EDIT CATEGORY
	@PutMapping("/categories/{id}/update")
	public String updateCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "addCategory.jsp";
		} else {
			categoryService.saveCategory(category);
			return "redirect:/";
		}
	}

	// DELETE PRODUCT
	@DeleteMapping("/products/{id}/delete")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}

	// DELETE CATEGORY
	@DeleteMapping("/categories/{id}/delete")
	public String deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/";
	}

}
