package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.exceptions.APIException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	
	private ProductRepository productRepository;
	
	private ProductService productService;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ProductService productService) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.productService = productService;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category createNewCategory(CategoryDTO categoryDTO) {
		
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setDescription(categoryDTO.getDescription());
		
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(String categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isPresent()) {
			return category.get();
		} else {
			throw new APIException("No Category Found with Given Id", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Category updateCategoryById(String categoryId, CategoryDTO categoryDTO) {
		
		Category category = getCategoryById(categoryId);
		
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setDescription(categoryDTO.getDescription());
		
		return categoryRepository.save(category);
	}

	@Override
	public List<ProductDTO> getListOfProductsForCategory(String categoryId) {
		
		Category category = getCategoryById(categoryId);
		List<Product> products = category.getProducts();
		List<ProductDTO> productDtos = new ArrayList<>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setDescription(product.getDescription());
			productDTO.setPrice(product.getPrice());
			productDTO.setQuantity(product.getQuantity());
			productDTO.setCategory(category);
			productDTO.setSize(Arrays.asList(product.getSize().split(",")));
			
			productDtos.add(productDTO);
		}
		return productDtos;
	}

	@Override
	public ProductDTO getSpecificProductForCategory(String categoryId, String productId) {
			
		Category category = categoryRepository.getOne(categoryId);
		Product product = productRepository.findByCategoryAndProductId(category, productId);
		
		ProductDTO productDTO;
		if(product == null) {
			throw new APIException("No product found for given category id and product id", HttpStatus.NOT_FOUND);
		} else {
			productDTO = productService.mapProductToDTO(product);
		}
		
		return productDTO;
	}

	@Override
	public void deleteCategory(String categoryId) {
		
		Category category = getCategoryById(categoryId);
		categoryRepository.delete(category);
	}

}
