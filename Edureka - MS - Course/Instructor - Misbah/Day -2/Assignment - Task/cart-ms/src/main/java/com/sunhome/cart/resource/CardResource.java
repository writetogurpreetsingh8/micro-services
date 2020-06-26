package com.sunhome.cart.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.cart.model.CartResponse;
import com.sunhome.cart.service.CardService;

@RestController
public class CardResource {
	
	@Autowired
    private  CardService cardService;

    @PostMapping(value = "cartproduct/{productId}")
    private ResponseEntity<CartResponse> addToCard(@PathVariable("productId") int productId) {
    
    	CartResponse cartResponse = cardService.addToCard(productId);
		return ResponseEntity.ok(cartResponse);
    }
}
