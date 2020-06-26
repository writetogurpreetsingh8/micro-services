package com.in28minutes.microservices.concurrenyconversionservice;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableJms
public class ConcurrenyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrenyConversionServiceApplication.class, args);
	}
	
	@Bean
	public Sampler getSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@Bean
	@Qualifier("currency-exchange-queue")
	public Queue currencyExchangeQueue() {
		return new ActiveMQQueue("currency-exchange-queue");
	}
	
	@Bean
	@Qualifier("currency-conversion-queue")
	public Queue concurrenyConversionQueue() {
		return new ActiveMQQueue("currency-conversion-queue");
	}


}
