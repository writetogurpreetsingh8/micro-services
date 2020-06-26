package com.sunhome.cart.service;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunhome.cart.model.CartResponse;

@Service
public class CardServiceImpl implements CardService {
  
    
	@Value("#{'${product.catelogue.serivce.url}'.trim()}")
	private String productCatelogueServiceURL;
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public CartResponse addToCard(int productId) {
		
		String url = UriComponentsBuilder.fromHttpUrl(productCatelogueServiceURL+"cartproduct/{productId}").buildAndExpand(productId).encode(Charset.defaultCharset()).toUriString();
		return restTemplate.postForObject(url,null,CartResponse.class);
	}
}
