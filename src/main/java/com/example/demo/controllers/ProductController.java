package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.models.Category;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/products")
	public ProductDTO createNewProduct(@RequestBody ProductDTO productDTO) {
		return productService.createNewProduct(productDTO);
	}
	
	@GetMapping("/products/{productId}")
	public ProductDTO getProductByProductId(@PathVariable String productId) {
		return productService.getProductByProductId(productId);
	}
	
	@PutMapping("/products/{productId}")
	public ProductDTO updateProductByProductId(@PathVariable String productId, @RequestBody ProductDTO productDTO) {
		return productService.updateProductByProductId(productId, productDTO);
	}
	
	@GetMapping("/products/{productId}/categories")
	public Category getCategoryForProduct(@PathVariable String productId) {
		return productService.getCategoryForProduct(productId);
	}
	
	@DeleteMapping("/products/{productId}")
	public void deleteProductById(@PathVariable String productId) {
		productService.deleteProductById(productId);
	}
	
	@PutMapping("/products/{productId}/categories")
	public ProductDTO removeProductCategoryAssociation(@PathVariable String productId) {
		return productService.removeProductCategoryAssociation(productId);
	}
}
