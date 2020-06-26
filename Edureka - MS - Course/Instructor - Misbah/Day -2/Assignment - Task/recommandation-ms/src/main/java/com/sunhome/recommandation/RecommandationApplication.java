package com.sunhome.recommandation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecommandationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommandationApplication.class, args);
	}

}
