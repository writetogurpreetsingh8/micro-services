package com.in28minutes.microservices.concurrenyconversionservice.controllers;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.concurrenyconversionservice.beans.ConcurrenyConversionBean;
import com.in28minutes.microservices.concurrenyconversionservice.feign.service.CurrencyExchangeFeignSerivce;

@RestController
public class ConcurrenyConversionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrenyConversionController.class);
	
	@Value("${server.port}")
	private int port;
	
	@Autowired
	private CurrencyExchangeFeignSerivce feignService;
	
	
	@GetMapping(value="/concurrenyConversion/from/{from}/to/{to}/quantity/{quantity}")
	private ResponseEntity<ConcurrenyConversionBean> convertConcurreny(@PathVariable("from") String from,@PathVariable("to") String to,@PathVariable("quantity") BigDecimal quantity) {
	
		return ResponseEntity.ok(new ConcurrenyConversionBean(10009L, from, to, 
				BigDecimal.valueOf(78.90), quantity, (quantity.multiply(BigDecimal.valueOf(78.90))), port));
		
	}
	
	@GetMapping(value="/concurrenyConversionFeign/from/{from}/to/{to}/quantity/{quantity}")
	private ResponseEntity<ConcurrenyConversionBean> convertConcurrenyFeign(@PathVariable("from") String from,@PathVariable("to") String to,@PathVariable("quantity") BigDecimal quantity) {
	
		LOGGER.info("concurrency conversion controller ............. before invoking feign............. the request is ...........{} ",this.feignService);
		ResponseEntity<ConcurrenyConversionBean> responseEntity = feignService.retrieveValue(from, to);
	//	LOGGER.info("request -> {} and request url -> {} ",request,request.getRequestURI());
		LOGGER.info(" concurrency conversion controller .............  response is ...........................................{} ",responseEntity.getBody());
		ConcurrenyConversionBean response = responseEntity.getBody();
		
		ConcurrenyConversionBean newBean = new ConcurrenyConversionBean(response.getId(),from,to,
				response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
		
		return ResponseEntity.ok(newBean);
	}
	
}
