package com.shivani.spring.dao;

import java.util.List;

import com.shivani.spring.model.Movie;

public interface MovieDao {

   long save(Movie movie);

   Movie get(long id);

   List<Movie> list();

   void update( Movie movie);

   void delete(long id);

   List<Movie> moviebyGenre(String genre);

}
