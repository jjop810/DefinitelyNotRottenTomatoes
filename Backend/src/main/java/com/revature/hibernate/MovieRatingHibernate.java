package com.revature.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.revature.beans.MovieRating;
import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.data.MovieRatingDAO;
import com.revature.utils.HibernateUtil;

import oracle.net.aso.s;




@Component
public class MovieRatingHibernate implements MovieRatingDAO{
	

	private static Logger log= Logger.getLogger(MovieRatingHibernate.class);
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Set<MovieRating> getMovieRatings() {

		Session s = hu.getSession();
		String query = "FROM MovieRating";
		Query<MovieRating> q = s.createQuery(query, MovieRating.class);
		List<MovieRating> ratingList = q.getResultList();
		Set<MovieRating> ratingSet = new HashSet<MovieRating>();
		ratingSet.addAll(ratingList);
		for(MovieRating mr : ratingSet) {
			setFriendsFriends(mr.getUser().getFriends());
		}
		s.close();
		
		return ratingSet;
	}

	@Override
	public Set<MovieRating> getMovieRatingByUserId(int i) {

		Session session = hu.getSession();
		User u = session.get(User.class,i);
		String queryString ="FROM MovieRating where user=:user";
		Query<MovieRating> q = session.createQuery(queryString, MovieRating.class);
		q.setParameter("user", u);
		List<MovieRating>movieRatings = q.list();
		for(MovieRating mr : movieRatings) {
			setFriendsFriends(mr.getUser().getFriends());
		}
		session.close();

		return new HashSet<MovieRating>(movieRatings);
	}

	@Override
	public Set<MovieRating> getMovieRatingByMovieId(int i) {
		
		Session s = hu.getSession();
		Movies m = s.get(Movies.class, i);
		String qString = "FROM MovieRating where movie=:movie";
		Query<MovieRating> q = s.createQuery(qString, MovieRating.class);
		q.setParameter("movie", m);
		List<MovieRating>mList = q.list();
		for(MovieRating mr : mList) {
			setFriendsFriends(mr.getUser().getFriends());
		}
		s.close();
		return new HashSet<MovieRating>(mList);
	}

	@Override
	public MovieRating getMovieRating(User u, Movies m) {

		Session s = hu.getSession();
		String query = "FROM MovieRating mr where mr.user=:user and mr.movie=:movie";
		Query<MovieRating> q = s.createQuery(query,MovieRating.class);
		q.setParameter("user", u);
		q.setParameter("movie", m);

		MovieRating movieRating= q.uniqueResult();
		setFriendsFriends(movieRating.getUser().getFriends());
		return movieRating;
	}
	

	@Override
	public Integer getMRByIDs(int i, int j) {
		Session session = hu.getSession();
		User u = session.get(User.class,i );
		log.trace("this is user "+u);
		Movies m = session.get(Movies.class, j);
		String query = "FROM MovieRating mr where mr.user=:u and mr.movie=:m";
		Query<MovieRating> q = session.createQuery(query,MovieRating.class);
		q.setParameter("user", u);
		q.setParameter("movie", m);
		
		MovieRating movieRating=q.uniqueResult();
		setFriendsFriends(movieRating.getUser().getFriends());
		return movieRating.getId();
	}

	

	
	@Override
	public MovieRating getMRById(int i) {
		Session s = hu.getSession();
		MovieRating mRating = s.get(MovieRating.class, i);
		setFriendsFriends(mRating.getUser().getFriends());
		return mRating;
	}

	@Override
	public Integer addMovieRating(MovieRating m) {
		Integer i = null;
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx= s.beginTransaction();
			i = (Integer) s.save(m);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return i;
	}

	@Override
	public MovieRating updateMovieRating(MovieRating m) {
		Session s= hu.getSession();
		Transaction tx = null;
		try {
			tx= s.beginTransaction();
			s.update(m);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return m;
	}

	@Override
	public void deleteMovieRating(MovieRating m) {

		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(m);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			e.printStackTrace();
			}
		}finally {
			session.close();
		}
		
	}
	
	public void setFriendsFriends(Collection<User> users) {
		users.forEach((friend) -> {
			friend.getId();
			friend.setFriends(new ArrayList<User>());
		});
	}
	

	
	

	
}
