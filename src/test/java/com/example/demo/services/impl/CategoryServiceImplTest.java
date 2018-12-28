package com.example.demo.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

public class CategoryServiceImplTest {

	private CategoryServiceImpl categoryService;

	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private ProductServiceImpl productService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		categoryService = new CategoryServiceImpl(categoryRepository, productRepository, productService);
	}

	@Test
	public void testGetAllCategories() throws Exception {

		Category category = new Category();
		List<Category> categoryData = new ArrayList<>();
		categoryData.add(category);

		when(categoryService.getAllCategories()).thenReturn(categoryData);

		List<Category> categories = categoryService.getAllCategories();

		assertEquals(1, categories.size());
		verify(categoryRepository, times(1)).findAll();
	}

	@Test
	public void testCreateNewCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategoryById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCategoryById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListOfProductsForCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpecificProductForCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCategory() {
		fail("Not yet implemented");
	}

}
