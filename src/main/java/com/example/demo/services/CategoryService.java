package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.models.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories();

	public Category createNewCategory(CategoryDTO categoryDTO);

	public Category getCategoryById(String categoryId);

	public Category updateCategoryById(String categoryId, CategoryDTO categoryDTO);

	public List<ProductDTO> getListOfProductsForCategory(String categoryId);

	public ProductDTO getSpecificProductForCategory(String categoryId, String productId);

	public void deleteCategory(String categoryId);
}
