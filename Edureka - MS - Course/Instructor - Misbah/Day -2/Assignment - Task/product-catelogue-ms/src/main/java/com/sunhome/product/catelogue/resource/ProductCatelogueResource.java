package com.sunhome.product.catelogue.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.product.catelogue.model.ProductCatelogueResponse;
import com.sunhome.product.catelogue.service.ProductCatelogueService;

@RestController
public class ProductCatelogueResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatelogueResource.class);

	
	@Autowired
	private ProductCatelogueService productCatelogueService;
	
	/**
	 * fetching all the catelogues 
	 */
	@GetMapping(path = "/catelogues")
	private ResponseEntity<ProductCatelogueResponse> getProductCatelogues(){
		
		
		LOGGER.info("invoking.......... /catelogues-request ,,,, ");
		
		ProductCatelogueResponse productCatelogueResponse = productCatelogueService.getProductCatelogues();
		
		if(productCatelogueResponse.getResponseStatus() == 200) {
			return ResponseEntity.ok(productCatelogueResponse);
		}else {
			return new ResponseEntity<ProductCatelogueResponse>(productCatelogueResponse,HttpStatus.OK);
		}
	}
	
	/**
	 * fetching catelogue by it's id 
	 */
	@GetMapping(value = "catelogues/{catelogueId}")
	private ResponseEntity<ProductCatelogueResponse> getProductCatelogue(@PathVariable("catelogueId") int catelogueId){
		
		ProductCatelogueResponse productCatelogueResponse = productCatelogueService.getProductCatelogue(catelogueId);
		
				if(productCatelogueResponse.getResponseStatus() == 200) {
					return ResponseEntity.ok(productCatelogueResponse);
				}else {
					return new ResponseEntity<ProductCatelogueResponse>(productCatelogueResponse,HttpStatus.OK);
				}
	}
	
	/**
	 * fetching particular product under particular catelogue
	 */
	@GetMapping(value = "catelogues/{catelogueId}/prodcuts/{productId}")
	private ResponseEntity<ProductCatelogueResponse> getProducts(@PathVariable("catelogueId") int catelogueId, @PathVariable("productId") int productId){
		
		ProductCatelogueResponse productCatelogueResponse = productCatelogueService.getProduct(catelogueId, productId);
		
		if(productCatelogueResponse.getResponseStatus() == 200) {
			return ResponseEntity.ok(productCatelogueResponse);
		}else {
			return new ResponseEntity<ProductCatelogueResponse>(productCatelogueResponse,HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "cartproduct/{productId}")
	private ResponseEntity<ProductCatelogueResponse> addProductIntoCart(@PathVariable("productId") int productId){
		
		ProductCatelogueResponse productCatelogueResponse = productCatelogueService.addProductIntoCart(productId);
		return ResponseEntity.ok(productCatelogueResponse);
	}
	
	@GetMapping(value="/recommandedProducts")
    private ResponseEntity<ProductCatelogueResponse> recommandedProducts(){
		
		ProductCatelogueResponse productCatelogueResponse   = productCatelogueService.recommandedProducts();
			return ResponseEntity.ok(productCatelogueResponse);
		
	}
    
}
