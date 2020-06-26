package com.example.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.entities.ExchangeValue;
import com.example.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@RestController
//@RequestMapping(path = "/vi")
public class CurrenyExchangeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrenyExchangeController.class);

	@Value("${server.port}")
	private int serverPort;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	//	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
	@GetMapping("/currentExchange/from/{from}/to/{to}")
	private ResponseEntity<ExchangeValue> retrieveValue(@PathVariable ("from") String from,@PathVariable("to") String to) {
		
		LOGGER.info("current exchange.........controller ..................");
		ExchangeValue ev = currencyExchangeRepository.findByFromAndTo(from, to);
		ev.setPort(serverPort);
		LOGGER.info("current exchange .......... db data is .........{}",ev);
		return ResponseEntity.ok(ev);
		
		//return ResponseEntity.ok(new ExchangeValue(1000L,from,to,BigDecimal.valueOf(67.80),serverPort));
	}
}
