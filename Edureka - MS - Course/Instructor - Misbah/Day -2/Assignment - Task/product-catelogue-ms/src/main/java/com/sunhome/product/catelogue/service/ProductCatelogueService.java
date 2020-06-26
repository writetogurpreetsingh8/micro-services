package com.sunhome.product.catelogue.service;

import com.sunhome.product.catelogue.model.ProductCatelogue;
import com.sunhome.product.catelogue.model.ProductCatelogueResponse;

public interface ProductCatelogueService {
	
	/**
	 * fetching all the catelogues 
	 */
	ProductCatelogueResponse getProductCatelogues();
	
	/**
	 * fetching catelogue by it's id 
	 */
	ProductCatelogueResponse getProductCatelogue(int catelogueId);

	/**
	 * fetching particular product under particular catelogue
	 */
	ProductCatelogueResponse getProduct(int catelogueId,int productId);
	
	ProductCatelogueResponse addProductIntoCart(int productId);
	
	ProductCatelogueResponse recommandedProducts();
}
