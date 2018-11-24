package com.example.demo.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.exceptions.APIException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapProductToDTO).collect(Collectors.toList());
	}

	@Override
	public ProductDTO mapProductToDTO(Product product) {

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		productDTO.setCategory(product.getCategory());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setSize(Arrays.asList(product.getSize().split(",")));

		return productDTO;
	}

	@Override
	public ProductDTO createNewProduct(ProductDTO productDTO) {

		Product product = new Product();

		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setCategory(productDTO.getCategory());
		product.setQuantity(productDTO.getQuantity());
		product.setSize(StringUtils.join(productDTO.getSize(), ','));

		return mapProductToDTO(productRepository.save(product));
	}

	@Override
	public ProductDTO getProductByProductId(String productId) {

		Product product = validateProduct(productId);
		return mapProductToDTO(product);
	}

	@Override
	public ProductDTO updateProductByProductId(String productId, ProductDTO productDTO) {

		Product product = validateProduct(productId);
		
		product.setProductName(productDTO.getProductName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setCategory(productDTO.getCategory());
		product.setSize(StringUtils.join(productDTO.getSize(), ','));
		product = productRepository.save(product);
		
		return mapProductToDTO(product);
	}

	@Override
	public Category getCategoryForProduct(String productId) {

		Product product = validateProduct(productId);
		return product.getCategory();
	}

	@Override
	public void deleteProductById(String productId) {

		Product product = validateProduct(productId);
		productRepository.delete(product);
	}

	@Override
	public ProductDTO removeProductCategoryAssociation(String productId) {

		Product updatedProduct = validateProduct(productId);
		updatedProduct.setCategory(null);
		return mapProductToDTO(productRepository.save(updatedProduct));
	}

	private Product validateProduct(String productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (!product.isPresent()) {
			throw new APIException("No product exists with the given id", HttpStatus.NOT_FOUND);
		}
		return product.get();
	}
}
