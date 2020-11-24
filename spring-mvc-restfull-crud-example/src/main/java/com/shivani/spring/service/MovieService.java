package com.shivani.spring.service;

import java.util.List;

import com.shivani.spring.model.Movie;


public interface MovieService {
	
	long save(Movie movie);
	   Movie get(long id);
	   List<Movie> list();
	   void update( Movie movie);
	   void delete(long id);
	   List<Movie> moviebyGenre(String genre);
	
	
	

}
