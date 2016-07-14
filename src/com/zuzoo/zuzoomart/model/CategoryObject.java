package com.zuzoo.zuzoomart.model;

import java.util.List;

public class CategoryObject {

	private String catename;
	private List<Product> products;

	public CategoryObject(String catename, List<Product> products) {
		super();
		this.catename = catename;
		this.products = products;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
