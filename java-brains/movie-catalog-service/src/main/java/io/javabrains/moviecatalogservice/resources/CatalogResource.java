package io.javabrains.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.service.MovieInfoService;
import io.javabrains.moviecatalogservice.service.UserRatingService;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private UserRatingService userRatingService;
    
    
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    
    	System.out.println("this. is  ................"+this);
        UserRating userRating = userRatingService.userRating(userId);
		 
        return userRating.getRatings().stream() .map(rating -> {return
		  movieInfoService.getMovieInfo(rating);}) .collect(Collectors.toList());
		 
    }
}
