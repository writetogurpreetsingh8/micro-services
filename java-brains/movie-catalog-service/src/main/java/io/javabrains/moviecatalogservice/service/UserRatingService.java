package io.javabrains.moviecatalogservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;

@Service
public class UserRatingService {

	@Value("${rating.data.service.url}")
	private String ratingDataServiceUrl;

	  @Autowired
	   private RestTemplate restTemplate;

	 @HystrixCommand(fallbackMethod = "fallBackUserRating")
	public UserRating userRating(String userId) {
		  System.out.println(this);
		  UserRating userRating = null;
		  try {
			  System.out.println("ratingDataServiceUrl "+ratingDataServiceUrl);
			  userRating =  restTemplate.getForObject(ratingDataServiceUrl + userId, UserRating.class); 
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return userRating;
	  }
	@SuppressWarnings("unused")
	private UserRating fallBackUserRating(String userId) {
		  UserRating userRating = new UserRating();
	        userRating.setUserId(userId);
	        userRating.setRatings(Arrays.asList(new Rating("0",0)));
	        return userRating;
	  }
	
}
