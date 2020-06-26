package com.sunhome.product.catelogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductCatelogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatelogueApplication.class, args);
	}

}
