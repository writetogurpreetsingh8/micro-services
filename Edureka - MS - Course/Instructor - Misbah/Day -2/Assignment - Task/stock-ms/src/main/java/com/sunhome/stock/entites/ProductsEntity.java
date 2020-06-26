package com.sunhome.stock.entites;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductsEntity {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	@Column(name = "item_type")
	private String itemType;

	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "price")
	private int price;
	
	
	@Column(name = "product_category")
	private String productCategory;
	
	
	@Column(name = "is_added_into_cart")
	private boolean addedIntoCart;
	

	@Column(name = "is_in_the_stock")
	private boolean inTheStock;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "is_active")
	private boolean active;
	

	@Column(name = "created_on")
	private Timestamp createdOn;
	
	
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;


	public Timestamp getUpdatedOn() {
		return updatedOn;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public boolean isAddedIntoCart() {
		return addedIntoCart;
	}


	public void setAddedIntoCart(boolean addedIntoCart) {
		this.addedIntoCart = addedIntoCart;
	}


	public boolean isInTheStock() {
		return inTheStock;
	}


	public void setInTheStock(boolean inTheStock) {
		this.inTheStock = inTheStock;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Timestamp getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}


	
	
}
