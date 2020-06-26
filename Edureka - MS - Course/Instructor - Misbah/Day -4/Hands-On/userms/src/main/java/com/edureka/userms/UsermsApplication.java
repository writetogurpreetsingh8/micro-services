package com.edureka.userms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@RestController
public class UsermsApplication {

	@Value("${my-property}")
	private String myProperty;
	@Value("${your-property}")
	private String yourProperty;

	@GetMapping("/properties")
	public List<String> getProperty() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add(myProperty);
		strings.add(yourProperty);
		return strings;
	}

	public static void main(String[] args) {
		SpringApplication.run(UsermsApplication.class, args);
	}

}
