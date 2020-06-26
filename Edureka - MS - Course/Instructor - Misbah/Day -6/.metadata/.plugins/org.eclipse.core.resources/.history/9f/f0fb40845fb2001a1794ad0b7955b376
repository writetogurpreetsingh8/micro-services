package com.edureka.userms.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class PaymentmsConfig {

    @Bean
    @LoadBalanced
    @Qualifier("oauth2RestTemplate")
    public OAuth2RestTemplate getOAuth2RestTemplate(final OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(resourceDetails(), clientContext);
    }

    @Bean
    public OAuth2ProtectedResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setId("1");
        details.setClientId("candy");
        details.setClientSecret("123");
        details.setAccessTokenUri("http://localhost:9000/oauth/token");
        details.setScope(Arrays.asList("read", "write"));
        details.setGrantType("client_credentials");

        return details;
    }
}
