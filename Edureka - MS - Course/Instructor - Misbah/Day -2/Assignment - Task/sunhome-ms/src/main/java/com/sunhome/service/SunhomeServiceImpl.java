
package com.sunhome.service;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunhome.model.SunhomeResponse;

@Service
public class SunhomeServiceImpl implements SunhomeService {


	@Value("#{'${product.catelogue.service}'.trim()}")
	private String productCatelogueService;
	
	@Value("#{'${cart.service}'.trim()}")
	private String cartService;
	
	@Value("#{'${recommandation.service}'.trim()}")
	private String recommandationService;
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public SunhomeResponse getProductCatelogues() {
		return restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(productCatelogueService+"catelogues").encode(Charset.defaultCharset()).toUriString(),SunhomeResponse.class);

	}

	@Override
	public SunhomeResponse getProductCatelogue(int catelogueId) {
		return restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(productCatelogueService+"catelogues/{catelogueId}").buildAndExpand(catelogueId).encode(Charset.defaultCharset()).toUriString(),SunhomeResponse.class);
	}

	@Override
	public SunhomeResponse getProduct(int catelogueId, int productId) {
		return restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(productCatelogueService+"catelogues/{catelogueId}/prodcuts/{productId}").buildAndExpand(catelogueId,productId).encode(Charset.defaultCharset()).toUriString(),SunhomeResponse.class);
	}

	@Override
	public SunhomeResponse addToCart(int productId) {
		return restTemplate.postForObject(UriComponentsBuilder.fromHttpUrl(cartService+"cartproduct/{productId}").buildAndExpand(productId).encode(Charset.defaultCharset()).toUriString(),null,SunhomeResponse.class);
	}

	@Override
	public SunhomeResponse recommandedProducts() {
		return restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(recommandationService+"recommendedProducts").encode(Charset.defaultCharset()).toUriString(),SunhomeResponse.class);
	} 
}
