package com.sunhome.product.catelogue.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductCatelogue {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateRestTemplate(RestTemplateBuilder rtb) {
        return rtb.build();
    }
}