package com.sunhome.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.model.SunhomeResponse;
import com.sunhome.service.SunhomeService;

@RestController
public class SunhomeResource {
	
	
	@Autowired
	private SunhomeService  sunhomeService;
	
	@GetMapping(value = "/catelogues")
	private ResponseEntity<SunhomeResponse> getProductCatelogues(){
		
		 SunhomeResponse sunhomeResponse = sunhomeService.getProductCatelogues();
		
		if(sunhomeResponse.getResponseStatus() != 200) {
			sunhomeResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse, HttpStatus.NOT_FOUND);

		}else {
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
		}

	}
	
	
	@GetMapping(value = "/catelogues/{catelogueId}")
	private ResponseEntity<SunhomeResponse> getProductCatelogue(@PathVariable("catelogueId") int catelogueId){
		
		
		
		SunhomeResponse sunhomeResponse = sunhomeService.getProductCatelogue(catelogueId);
		
		if(sunhomeResponse.getResponseStatus() != 200) {
			sunhomeResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse, HttpStatus.NOT_FOUND);

		}else {
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
		}
	}
	
	@GetMapping(value = "/catelogues/{catelogueId}/products/{productId}")
	private ResponseEntity<SunhomeResponse> getProducts(@PathVariable("catelogueId") int catelogueId, @PathVariable("productId") int productId){
		
		SunhomeResponse sunhomeResponse =  sunhomeService.getProduct(catelogueId, productId);
		
		if(sunhomeResponse.getResponseStatus() != 200) {
			sunhomeResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse, HttpStatus.NOT_FOUND);
		}else {
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
			
		}
	}
	
	/*@DeleteMapping(value = "/catelogues")
	private ResponseEntity<SunhomeResponse> deleteCatelogues(){
		

			SunhomeResponse sunhomeResponse = new SunhomeResponse();
			sunhomeService.deleteCatelogue();
			sunhomeResponse.setMessage("SUCCESS - Catelogues are deleted successfully!");
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
		
	}
	

	@DeleteMapping(value = "/catelogues/{catelogueId}")
	private ResponseEntity<SunhomeResponse> deleteProductCatelogue(@PathVariable("catelogueId") int catelogueId){
	
		SunhomeResponse sunhomeResponse = new SunhomeResponse();
		try {
			sunhomeService.deleteCatelogue(catelogueId);
			sunhomeResponse.setMessage("SUCCESS - Catelogue is deleted successfully!");
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
		}catch(EmptyResultDataAccessException e) {
			sunhomeResponse.setMessage("ERROR - Product Catelogue not found or already deleted!");
			sunhomeResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/catelogues/{catelogueId}/products/{productId}")
	private ResponseEntity<SunhomeResponse> deleteProduct(@PathVariable("catelogueId") int catelogueId, @PathVariable("productId") int productId){
	
		
		SunhomeResponse sunhomeResponse = new SunhomeResponse();
		try {
			sunhomeService.deleteProduct(catelogueId, productId);
			sunhomeResponse.setMessage("SUCCESS - Product is deleted successfully!");
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
			
		}catch(EmptyResultDataAccessException e) {
			sunhomeResponse.setMessage("ERROR - Product not found or already deleted!");
			sunhomeResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse, HttpStatus.NOT_FOUND);
		}
	}*/

	@PostMapping(value = "/cartproduct/{productId}")
	private ResponseEntity<SunhomeResponse> addProductIntoCart(@PathVariable("productId") int productId){
		
		SunhomeResponse sunhomeResponse = sunhomeService.addToCart(productId);
		
		if((Boolean)sunhomeResponse.getResponse()) {
			sunhomeResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(sunhomeResponse);
		}
		else {
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/recommandedProducts")
    private ResponseEntity<SunhomeResponse> recommandedProducts(){
		
		SunhomeResponse sunhomeResponse = sunhomeService.recommandedProducts();

		if(sunhomeResponse.getResponseStatus() == 200) {
			return ResponseEntity.ok(sunhomeResponse);
		}else {
			return new ResponseEntity<SunhomeResponse>(sunhomeResponse,HttpStatus.NOT_FOUND);
		}
	}
    
}
