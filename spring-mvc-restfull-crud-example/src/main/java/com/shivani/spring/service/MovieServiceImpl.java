package com.shivani.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivani.spring.dao.MovieDao;
import com.shivani.spring.model.Movie;

@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

   @Autowired
   private MovieDao movieDao;

   @Transactional
   @Override
   public long save(Movie movie) {
      return movieDao.save(movie);
   }

   @Override
   public Movie get(long id) {
      return movieDao.get(id);
   }

   @Override
   public List<Movie> list() {
      return movieDao.list();
   }

   @Transactional
   @Override
   public void update(Movie movie) {
      movieDao.update( movie);
   }

   @Transactional
   @Override
   public void delete(long id) {
      movieDao.delete(id);
   }

@Override
public List<Movie> moviebyGenre(String genre) {
	
	return movieDao.moviebyGenre(genre);
}

}
