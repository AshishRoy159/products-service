package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {

	public Category() {
	}
	
	public Category(String id, String name, String description) {
		this.categoryId = id;
		this.categoryName = name;
		this.description = description;
	}

	@Id
	@Column(name = "id")
	private String categoryId;

	@Column(name = "name")
	private String categoryName;

	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	@JsonManagedReference
	private List<Product> products;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
