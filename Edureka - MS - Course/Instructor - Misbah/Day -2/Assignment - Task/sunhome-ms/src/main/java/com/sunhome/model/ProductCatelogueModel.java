package com.sunhome.model;

import java.util.List;

public class ProductCatelogueModel {
	
	private int productCatelogueId;
	private String name;
	private List<ProductModel> products;
	private String itemType;
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getProductCatelogueId() {
		return productCatelogueId;
	}
	public void setProductCatelogueId(int productCatelogueId) {
		this.productCatelogueId = productCatelogueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	} 

	
	
}
