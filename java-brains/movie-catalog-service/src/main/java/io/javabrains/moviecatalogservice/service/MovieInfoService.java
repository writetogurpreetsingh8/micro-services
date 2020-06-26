package io.javabrains.moviecatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;

@Service
public class MovieInfoService {
	
	@Value("${movie.info.service.url}")
	private String movieInfoSerivceUrl;
	  @Autowired
	   private RestTemplate restTemplate;
	  
	  @HystrixCommand(defaultFallback = "defaultMovieInfo",fallbackMethod = "fallbackMovieInfo")
	  public CatalogItem getMovieInfo(Rating rating) {
		  System.out.println(this);
		  Movie movie = null;
		  try {
			  System.out.println("movieInfoSerivceUrl "+movieInfoSerivceUrl);
			  movie = restTemplate.getForObject(movieInfoSerivceUrl + rating.getMovieId(), Movie.class);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
			return new CatalogItem(movie.getName(), "Description", rating.getRating());
	  }
	  
	  @SuppressWarnings("unused")
	private CatalogItem fallbackMovieInfo(Rating rating) {
		  System.out.println("triggered fallback mehtod() for movie ...............");
		  return new CatalogItem("movie not found from fallbackMovieInfo", "", rating.getRating());
	  }
	  
	  @SuppressWarnings("unused")
		private CatalogItem defaultMovieInfo() {
			  System.out.println("triggered defaultMovieInfo mehtod() for movie ...............");
			  return new CatalogItem("movie not found from defaultMovieInfo", "", 0);
		  }

}
