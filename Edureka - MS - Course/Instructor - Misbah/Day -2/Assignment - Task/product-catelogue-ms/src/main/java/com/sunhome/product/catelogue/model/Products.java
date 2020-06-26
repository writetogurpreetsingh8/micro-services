package com.sunhome.product.catelogue.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Products {
	
	@JsonProperty(value = "id")
	private int productId;
	private String name;
	private int price;
	private String itemType;

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	

}
