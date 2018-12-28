package com.example.demo.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.dto.ProductDTO;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.impl.ProductServiceImpl;

public class ProductControllerTest {

	@Mock
	private ProductServiceImpl productService;

	@Mock
	private ProductRepository productRepository;

	private ProductController productController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		productController = new ProductController(productService);
	}

	@Test
	public void testGetAllProducts() {
		List<ProductDTO> products = productController.getAllProducts();

		assertEquals(0, products.size());
		verify(productService, times(1)).getAllProducts();
	}

	@Test
	public void testMockMVC() {

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		try {
			mockMvc.perform(get("/api/products")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCreateNewProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductByProductId() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProductByProductId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategoryForProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProductById() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveProductCategoryAssociation() {
		fail("Not yet implemented");
	}

}
