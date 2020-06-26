package com.example.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyexchangeservice.entities.ExchangeValue;

public interface CurrencyExchangeRepository  extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findByFromAndTo(String from , String to);
}
