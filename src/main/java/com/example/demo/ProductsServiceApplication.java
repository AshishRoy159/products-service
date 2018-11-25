package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@SpringBootApplication
public class ProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadCategoriesAndProducts(CategoryRepository categoryRepository, ProductRepository productRepository) {
		
		return args -> {
			Category category1 = categoryRepository.save(new Category("C1", "Category 1", "Description 1"));
			Category category2 = categoryRepository.save(new Category("C2", "Category 2", "Description 2"));
			Category category3 = categoryRepository.save(new Category("C3", "Category 3", "Description 3"));
			
			productRepository.save(new Product("P1", "Product 1", "Description 1", 100, 100.00d, category1, "S,M,L"));
			productRepository.save(new Product("P2", "Product 2", "Description 2", 120, 120.00d, category1, "S,M,XL"));
			productRepository.save(new Product("P3", "Product 3", "Description 3", 130, 130.00d, category2, "S,L,XL"));
			productRepository.save(new Product("P4", "Product 4", "Description 4", 140, 140.00d, category2, "S,M"));
			productRepository.save(new Product("P5", "Product 5", "Description 5", 150, 150.00d, category3, "M,L,XL"));
			productRepository.save(new Product("P6", "Product 6", "Description 6", 160, 160.00d, category3, "M,L"));
			productRepository.save(new Product("P7", "Product 7", "Description 7", 170, 170.00d, category3, "S,L"));
		};
	}
}
