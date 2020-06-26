package com.sunhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SunhomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunhomeApplication.class, args);
	}

}
