package com.sunhome.recommandation.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.recommandation.model.RecommandationResponse;
import com.sunhome.recommandation.service.RecommandationService;

@RestController
public class RecommandationResource {
    
	@Autowired
	private RecommandationService recommandationService;

	@GetMapping(value = "/recommendedProducts")
	private ResponseEntity<RecommandationResponse> recommendedProducts(){
		
		RecommandationResponse recommandationResponse = recommandationService.recommendedProducts();
		return ResponseEntity.ok(recommandationResponse);
    	
	}
    
}
