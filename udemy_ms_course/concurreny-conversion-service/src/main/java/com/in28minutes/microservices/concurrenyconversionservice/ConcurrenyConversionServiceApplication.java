package com.in28minutes.microservices.concurrenyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.in28minutes.microservices.concurrenyconversionservice")
@EnableEurekaClient
public class ConcurrenyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrenyConversionServiceApplication.class, args);
	}
	
	@Bean
	public Sampler getSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}