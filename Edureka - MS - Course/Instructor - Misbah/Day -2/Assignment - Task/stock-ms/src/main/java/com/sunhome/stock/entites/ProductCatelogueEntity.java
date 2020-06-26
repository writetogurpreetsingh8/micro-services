package com.sunhome.stock.entites;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_catelogue")
public class ProductCatelogueEntity {
	
	@Id
	@Column(name = "product_catelogue_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "is_active")
	private boolean active;
	

	@Column(name = "created_on")
	private Timestamp createdOn;
	
	@Column(name = "item_type")
	private String itemType;

	@Column(name = "udated_on")
	private Timestamp udatedOn;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_catelogue_id_fk")
	private List<ProductsEntity> products;

	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
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

	public Timestamp getUdatedOn() {
		return udatedOn;
	}

	public void setUdatedOn(Timestamp udatedOn) {
		this.udatedOn = udatedOn;
	}

	public List<ProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsEntity> products) {
		this.products = products;
	}
	
	

}
