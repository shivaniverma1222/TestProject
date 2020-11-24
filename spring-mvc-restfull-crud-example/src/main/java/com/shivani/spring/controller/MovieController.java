package com.shivani.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.spring.model.Movie;
import com.shivani.spring.service.MovieService;

@RestController
public class MovieController {

   @Autowired
   private MovieService movieService;

   /*---Add new Movie---*/
   @PostMapping("/savemovie")
   public ResponseEntity<?> save(@RequestBody Movie movie) {
      long id = movieService.save(movie);
      return ResponseEntity.ok().body("New Movie has been added with ID:" + id);
   }
   
   @PostMapping("/moviebygenre")
   public ResponseEntity<List<Movie>> moviebyGenre(@RequestBody Movie movie) {
	   List<Movie> mov= movieService.moviebyGenre(movie.getGenre());
      return ResponseEntity.ok().body(mov);
   }

   /*---Get a movie by id---*/
   @GetMapping("/getmovie/{id}")
   public ResponseEntity<Movie> get(@PathVariable("id") long id) {
      Movie movie = movieService.get(id);
      return ResponseEntity.ok().body(movie);
   }

   /*---get all movies---*/
   @GetMapping("/allmovie")
   public ResponseEntity<List<Movie>> list() {
      List<Movie> movies = movieService.list();
      return ResponseEntity.ok().body(movies);
   }

   /*---Update a movie by id---*/
   @PutMapping("/updatemovie")
   public ResponseEntity<?> update( @RequestBody Movie movie) {
      movieService.update(movie);
      return ResponseEntity.ok().body("Movie has been updated successfully.");
   }

   /*---Delete a movie by id---*/
   @DeleteMapping("/deletemovie/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      movieService.delete(id);
      return ResponseEntity.ok().body("Movie has been deleted successfully.");
   }
}