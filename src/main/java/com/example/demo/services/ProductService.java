package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ProductDTO;
import com.example.demo.models.Category;
import com.example.demo.models.Product;

public interface ProductService {

	public List<ProductDTO> getAllProducts();

	public ProductDTO mapProductToDTO(Product product);

	public ProductDTO createNewProduct(ProductDTO productDTO);

	public ProductDTO getProductByProductId(String productId);

	public ProductDTO updateProductByProductId(String productId, ProductDTO productDTO);

	public Category getCategoryForProduct(String productId);

	public void deleteProductById(String productId);

	public ProductDTO removeProductCategoryAssociation(String productId);

}
