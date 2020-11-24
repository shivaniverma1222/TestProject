package com.shivani.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivani.spring.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Movie movie) {
      sessionFactory.getCurrentSession().save(movie);
      return movie.getId();
   }

   @Override
   public Movie get(long id) {
	 
      return sessionFactory.getCurrentSession().get(Movie.class, id);
   }

   @Override
   public List<Movie> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
      Root<Movie> root = cq.from(Movie.class);
      cq.select(root);
      Query<Movie> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update( Movie movie) {
      Session session = sessionFactory.getCurrentSession();
      session.update(movie);
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Movie movie = session.byId(Movie.class).load(id);
      session.delete(movie);
   }

@Override
public List<Movie> moviebyGenre(String genre) {
	Session session = sessionFactory.getCurrentSession();
	  javax.persistence.Query query=session.createQuery("select a from Movie a where a.genre=:genre",Movie.class);
	  query.setParameter("genre", genre);
	  List<Movie> movieList=query.getResultList();
	return movieList;
}

}
