package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@PostMapping("/categories")
	public Category createNewCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.createNewCategory(categoryDTO);
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category getCategoryById(@PathVariable String categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
	
	@PutMapping("/categories/{categoryId}")
	public Category updateCategoryById(@PathVariable String categoryId, @RequestBody CategoryDTO categoryDTO) {
		return categoryService.updateCategoryById(categoryId, categoryDTO);
	}
	
	@GetMapping("/categories/{categoryId}/products")
	public List<ProductDTO> getListOfProductsForCategory(@PathVariable String categoryId) {
		return categoryService.getListOfProductsForCategory(categoryId);
	}
	
	@GetMapping("/categories/{categoryId}/products/{productId}")
	public ProductDTO getSpecificProductForCategory(@PathVariable String categoryId, @PathVariable String productId) {
		return categoryService.getSpecificProductForCategory(categoryId, productId);
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public void deleteCategory(@PathVariable String categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
