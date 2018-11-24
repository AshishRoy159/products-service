package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	public Product findByCategoryAndProductId(Category category, String productId);
}
