package com.sunhome.product.catelogue.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCatelogue {
	
	@JsonProperty(value = "id")
	private int productCatelogueId;
	private String name;
	private List<Products> products;
	private String itemType;
	
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
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	} 

	
	
}
