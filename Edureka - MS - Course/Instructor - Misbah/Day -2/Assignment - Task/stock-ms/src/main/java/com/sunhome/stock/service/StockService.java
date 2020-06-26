package com.sunhome.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.sunhome.stock.entites.ProductCatelogueEntity;
import com.sunhome.stock.entites.ProductsEntity;
import com.sunhome.stock.model.StockResponse;

public interface StockService {
	
	
	/**
	 * fetching all the catelogues 
	 */
	List<ProductCatelogueEntity> getProductCatelogues();
	
	/**
	 * fetching catelogue by it's id 
	 */
	Optional<ProductCatelogueEntity> getProductCatelogue(int catelogueId);

	/**
	 * fetching particular product under particular catelogue
	 */
	Optional<ProductCatelogueEntity> getProduct(int catelogueId,int productId);

	void deleteCatelogue();
	void deleteCatelogue(int catelogueId);
	void deleteProduct(int catelogueId,int productId);
	boolean addToCart(int productId);
	
	  List<ProductsEntity> recommandedProducts();
}
