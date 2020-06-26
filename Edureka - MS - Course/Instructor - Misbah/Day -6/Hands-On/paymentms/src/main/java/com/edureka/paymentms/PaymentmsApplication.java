package com.edureka.paymentms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class PaymentmsApplication extends ResourceServerConfigurerAdapter {

	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}

	@GetMapping("/secure/hello")
	public String getSecureHello() {
		return "Get Secure Hello World";
	}

	@PostMapping("/secure/hello")
	public String postSecureHello() {
		return "Post Secure Hello World";
	}

	@DeleteMapping("/secure/hello")
	public String deleteSecureHello() {
		return "Delete Secure Hello World";
	}


	/*@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		super.configure(resources);
	}*/

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.requestMatchers()
				.antMatchers("/secure/**")
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/secure/**").access("#oauth2.hasScope('read')")
				.antMatchers(HttpMethod.POST, "/secure/**").access("#oauth2.hasScope('write')")
				.antMatchers(HttpMethod.DELETE, "/secure/**").access("#oauth2.hasScope('admin')");

	 	http.authorizeRequests().antMatchers("/h2-console").permitAll();
		http.requestMatchers().antMatchers("/**")
				.and()
				.authorizeRequests()
				.anyRequest().permitAll();
		/*http.requestMatchers().antMatchers("/**")
				.and()
				.authorizeRequests()
				.anyRequest().denyAll();*/
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);

		return defaultTokenServices;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}


	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey("123");
		return jwtAccessTokenConverter;
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentmsApplication.class, args);
	}

}
