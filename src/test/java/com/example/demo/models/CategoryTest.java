package com.example.demo.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetCategoryId() throws Exception {
		String idValue = "C2";
		category.setCategoryId(idValue);
		assertEquals(idValue, category.getCategoryId());
	}

	@Test
	public void testGetCategoryName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProducts() {
		fail("Not yet implemented");
	}

}
