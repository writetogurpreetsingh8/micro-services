package io.javabrains.movieinfoservice.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${movie.info}")
	private String url;
	
	@Autowired
	private RestTemplate rest;
	
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) throws JsonParseException, JsonMappingException, IOException {
		
    	System.out.println("url is "+url);
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.TEXT_PLAIN); HttpEntity<String> entity = new
		  HttpEntity<String>(headers); ResponseEntity<String> movieJson =
		  rest.exchange(url,
		  HttpMethod.GET, entity,String.class); String data = movieJson.getBody();
		  ObjectMapper mapper = new ObjectMapper(); Movie movie =
		  mapper.readValue(data, Movie.class); return movie;
		 
    	//return rest.getForObject("http://localhost:8082/external-url-moive-info/movie-info",Movie.class);
        
    }

}
