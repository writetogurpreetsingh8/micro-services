package com.sunhome.recommandation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunhome.recommandation.model.RecommandationResponse;

@Service
public class RecommandationServiceImpl implements RecommandationService {

	@Value("#{'${product.catelogue.service}'.trim()}")
	private String productCatelogueService;
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public RecommandationResponse recommendedProducts() {
	    return restTemplate.getForEntity(UriComponentsBuilder.fromHttpUrl(productCatelogueService+"recommandedProducts").build().toUri(), RecommandationResponse.class).getBody();
	}
   
	
}
