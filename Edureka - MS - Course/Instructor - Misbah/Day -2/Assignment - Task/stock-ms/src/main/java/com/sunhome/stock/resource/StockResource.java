package com.sunhome.stock.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.stock.entites.ProductCatelogueEntity;
import com.sunhome.stock.entites.ProductsEntity;
import com.sunhome.stock.model.StockResponse;
import com.sunhome.stock.service.StockService;

@RestController
public class StockResource {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockResource.class);

	
	@Autowired
	private StockService  stockService;
	
	@GetMapping(value = "/catelogues")
	private ResponseEntity<StockResponse> getProductCatelogues(){
	
		LOGGER.info("invoking get-product categlogue,,,,,,,,");
		StockResponse stockResponse = new StockResponse();
		
		List<ProductCatelogueEntity> list = stockService.getProductCatelogues();
		
		if(list.isEmpty()) {
			stockResponse.setMessage("ERROR - Product Catelogues are not available!");
			stockResponse.setResponse(list);
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StockResponse>(stockResponse, HttpStatus.OK);

		}else {
			stockResponse.setMessage("SUCCESS");
			stockResponse.setResponse(list);
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
		}

	}
	
	
	@GetMapping(value = "/catelogues/{catelogueId}")
	private ResponseEntity<StockResponse> getProductCatelogue(@PathVariable("catelogueId") int catelogueId){
		
		
		StockResponse stockResponse = new StockResponse();
		
		Optional<ProductCatelogueEntity> list = stockService.getProductCatelogue(catelogueId);
		
		if(!list.isPresent()) {
			stockResponse.setMessage("ERROR - Product Catelogues are not available!");
			stockResponse.setResponse(list.orElse(null));
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StockResponse>(stockResponse, HttpStatus.OK);

		}else {
			stockResponse.setMessage("SUCCESS");
			stockResponse.setResponse(list.get());
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
		}
	}
	
	@GetMapping(value = "/catelogues/{catelogueId}/products/{productId}")
	private ResponseEntity<StockResponse> getProducts(@PathVariable("catelogueId") int catelogueId, @PathVariable("productId") int productId){
		
		
		StockResponse stockResponse = new StockResponse();
		Optional<ProductCatelogueEntity> list  = stockService.getProduct(catelogueId, productId);
		
		if(!list.isPresent()) {
					
			stockResponse.setMessage("ERROR - Product Catelogues are not available!");
			stockResponse.setResponse(list.orElse(null));
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StockResponse>(stockResponse, HttpStatus.OK);
		}else {
			stockResponse.setMessage("SUCCESS");
			stockResponse.setResponse(list.get());
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
			
		}
	}
	
	/*@DeleteMapping(value = "/catelogues")
	private ResponseEntity<StockResponse> deleteCatelogues(){
		

			StockResponse stockResponse = new StockResponse();
			stockService.deleteCatelogue();
			stockResponse.setMessage("SUCCESS - Catelogues are deleted successfully!");
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
		
	}
	

	@DeleteMapping(value = "/catelogues/{catelogueId}")
	private ResponseEntity<StockResponse> deleteProductCatelogue(@PathVariable("catelogueId") int catelogueId){
	
		StockResponse stockResponse = new StockResponse();
		try {
			stockService.deleteCatelogue(catelogueId);
			stockResponse.setMessage("SUCCESS - Catelogue is deleted successfully!");
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
		}catch(EmptyResultDataAccessException e) {
			stockResponse.setMessage("ERROR - Product Catelogue not found or already deleted!");
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StockResponse>(stockResponse, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/catelogues/{catelogueId}/products/{productId}")
	private ResponseEntity<StockResponse> deleteProduct(@PathVariable("catelogueId") int catelogueId, @PathVariable("productId") int productId){
	
		
		StockResponse stockResponse = new StockResponse();
		try {
			stockService.deleteProduct(catelogueId, productId);
			stockResponse.setMessage("SUCCESS - Product is deleted successfully!");
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
			
		}catch(EmptyResultDataAccessException e) {
			stockResponse.setMessage("ERROR - Product not found or already deleted!");
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StockResponse>(stockResponse, HttpStatus.NOT_FOUND);
		}
	}*/

	@PostMapping(value = "/cartproduct/{productId}")
	private ResponseEntity<StockResponse> addProductIntoCart(@PathVariable("productId") int productId){
		
		boolean flag = stockService.addToCart(productId);
		StockResponse stockResponse = new StockResponse();
		
		if(flag) {
			
			stockResponse.setMessage("SUCCESS - Product has been added into cart successfully!");
			stockResponse.setResponse(true);
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(stockResponse);
		}
		else {
			stockResponse.setResponse(false);
			stockResponse.setMessage("ERROR - Product isn't in the stock!");
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StockResponse>(stockResponse, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/recommandedProducts")
    private ResponseEntity<StockResponse> recommandedProducts(){
		
		StockResponse stockResponse = new StockResponse();
		
		List<ProductsEntity> proList = stockService.recommandedProducts();
		stockResponse.setResponse(proList);
		
		if(!proList.isEmpty()) {
			stockResponse.setResponseStatus(HttpStatus.OK.value());
			stockResponse.setMessage("SUCCESS - Recommandation has been found!");
			return ResponseEntity.ok(stockResponse);
		}else {
			stockResponse.setResponseStatus(HttpStatus.NOT_FOUND.value());
			stockResponse.setMessage("ERROR - Recommandation not found!");
			return new ResponseEntity<StockResponse>(stockResponse,HttpStatus.OK);
		}
	}
    
}
