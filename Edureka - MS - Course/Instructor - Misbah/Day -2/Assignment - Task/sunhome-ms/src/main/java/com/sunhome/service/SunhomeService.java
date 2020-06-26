package com.sunhome.service;

import com.sunhome.model.SunhomeResponse;

public interface SunhomeService {
	
	
	/**
	 * fetching all the catelogues 
	 */
	SunhomeResponse getProductCatelogues();
	
	/**
	 * fetching catelogue by it's id 
	 */
	SunhomeResponse getProductCatelogue(int catelogueId);

	/**
	 * fetching particular product under particular catelogue
	 */
	SunhomeResponse getProduct(int catelogueId,int productId);

	SunhomeResponse addToCart(int productId);
	
	SunhomeResponse recommandedProducts();
}
