package com.in28minutes.microservices.concurrenyconversionservice.feign.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.concurrenyconversionservice.beans.ConcurrenyConversionBean;

//@FeignClient(name = "curreny-exchange-service",url = "localhost:8000/currency-exchange-service")
//@FeignClient(name = "currency-exchange-service/currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeFeignSerivce {

	@GetMapping("/currency-exchange-service/currency-exchange-service/currentExchange/from/{from}/to/{to}")
	ResponseEntity<ConcurrenyConversionBean> retrieveValue(@PathVariable ("from") String from,@PathVariable("to") String to);
	
	
}
