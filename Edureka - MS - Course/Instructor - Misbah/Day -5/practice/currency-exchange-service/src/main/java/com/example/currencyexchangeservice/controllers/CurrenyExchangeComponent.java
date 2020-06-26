package com.example.currencyexchangeservice.controllers;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.currencyexchangeservice.entities.ExchangeValue;
import com.example.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@Component
public class CurrenyExchangeComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrenyExchangeComponent.class);

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue concurrenyConversionQueue;
	
	@JmsListener(destination = "currency-exchange-queue")
	public void retrieveValue(String fromAndTo) throws JMSException {
		
		LOGGER.info("current exchange.........client consuming the value... ..................{} ",fromAndTo);
		ExchangeValue ev = currencyExchangeRepository.findByFromAndTo(fromAndTo.split("#")[0],fromAndTo.split("#")[1]);
		LOGGER.info("current exchange .......... db data is .........{}",ev);
		
		LOGGER.info("passing the conversion-rate into queue......... {} ",ev.getConversionMultiple());
		jmsTemplate.convertAndSend(concurrenyConversionQueue, String.valueOf(ev.getConversionMultiple()));
		
		LOGGER.info("conversion rate has been passed into queue successfully!.....{},");
		
	}
}