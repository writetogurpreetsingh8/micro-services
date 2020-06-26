package com.sunhome.product.catelogue.service;

import java.nio.charset.Charset;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunhome.product.catelogue.model.ProductCatelogue;
import com.sunhome.product.catelogue.model.ProductCatelogueResponse;
import com.sunhome.product.catelogue.model.Products;

@Service
@RefreshScope
public class ProductCatelogueServiceImpl implements ProductCatelogueService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatelogueServiceImpl.class);

	
	@Value("#{'${stock.serivce.url}'.trim()}")
	private String stockServiceURL;
	

	@Autowired
    private RestTemplate restTemplate;

	@Value("${prod.test.value}")
	private String applicationName;
	
	
	/**
	 * fetching all the catelogues 
	 */
	
	@Override
	public ProductCatelogueResponse getProductCatelogues() {

		LOGGER.info("prod.test.value is.......................................................{}",applicationName);
		
		LOGGER.info("invoking getProduct-catelogue.............");
		
		ProductCatelogueResponse response =  restTemplate.getForObject(stockServiceURL+"catelogues",ProductCatelogueResponse.class);
		parseProductCatelogue(response);
		return response;
	}

	private ProductCatelogue parseProductCatelogue(ProductCatelogueResponse response) {
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProductCatelogue pc = null;
		
		try {
			String rs  = mapper.writeValueAsString(response.getResponse());
			response.setResponse(mapper.readValue(rs, new TypeReference<List<ProductCatelogue>>(){}));
		} catch (JsonProcessingException e) {
			LOGGER.error("exception occurred,,,,,,, {} ",e);
		}
		return pc;
	}
	
	/**
	 * fetching catelogue by it's id 
	 */
	
	@Override
	public ProductCatelogueResponse getProductCatelogue(int catelogueId) {
	
		ProductCatelogueResponse response =  restTemplate.getForEntity(UriComponentsBuilder.fromHttpUrl(stockServiceURL+"/catelogues/{catelogueId}").buildAndExpand(catelogueId).encode(Charset.defaultCharset()).toUri(),ProductCatelogueResponse.class).getBody();
		parseProductCatelogue0(response);
		return response;
	}
	
	private ProductCatelogue parseProductCatelogue0(ProductCatelogueResponse response) {
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProductCatelogue pc = null;
		
		try {
			String rs  = mapper.writeValueAsString(response.getResponse());
			response.setResponse(mapper.readValue(rs, ProductCatelogue.class));
		} catch (JsonProcessingException e) {
			//e.printStackTrace();
		}
		return pc;
	}

	/**
	 * fetching particular product under particular catelogue
	 */
	
	@Override
	public ProductCatelogueResponse getProduct(int catelogueId, int productId) {
	
		ProductCatelogueResponse response =  restTemplate.getForEntity(UriComponentsBuilder.fromHttpUrl(stockServiceURL+"/catelogues/{catelogueId}/products/{productId}").buildAndExpand(catelogueId,productId).encode(Charset.defaultCharset()).toUri(),ProductCatelogueResponse.class).getBody();
		parseProductCatelogue0(response);
		return response;
	}

	@Override
	public ProductCatelogueResponse addProductIntoCart(int productId) {
		return restTemplate.postForObject(UriComponentsBuilder.fromHttpUrl(stockServiceURL+"cartproduct/{productId}").buildAndExpand(productId).encode(Charset.defaultCharset()).toUri(),null,ProductCatelogueResponse.class);
	}

	@Override
	public ProductCatelogueResponse recommandedProducts() {
		ProductCatelogueResponse response = restTemplate.getForEntity(UriComponentsBuilder.fromHttpUrl(stockServiceURL+"recommandedProducts").build().toUri(), ProductCatelogueResponse.class).getBody();
		parseProduct(response);
		return response;
	}
	
	private ProductCatelogue parseProduct(ProductCatelogueResponse response) {
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProductCatelogue pc = null;
		
		try {
			String rs  = mapper.writeValueAsString(response.getResponse());
			response.setResponse(mapper.readValue(rs, new TypeReference<List<Products>>(){}));
		} catch (JsonProcessingException e) {
			//e.printStackTrace();
		}
		return pc;
	}
}
