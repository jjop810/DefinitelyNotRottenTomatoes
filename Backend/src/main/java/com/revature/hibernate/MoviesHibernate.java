package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class MoviesHibernate implements MoviesDAO {
	
	private static Logger log = Logger.getLogger(MoviesHibernate.class);
	
	@Autowired
	private HibernateUtil hu;
	
	
	

	@Override
	public int addMovie(Movies mov) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(mov);
			log.trace("adding movie through hibernate " + mov);
			
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, MoviesHibernate.class);
		} finally {
			s.close();
		}
		
		
		return mov.getId();
		
	}

	@Override
	public Movies getMovie(String title) {
		Session s = hu.getSession();
		String query = "from Movies m where m.title=:title";
		Query<Movies> q = s.createQuery(query, Movies.class);
		
		q.setParameter("title", title);
		Movies m = q.uniqueResult();
		s.close();
		return m;
	}

	@Override
	public Movies getMovie(Movies mov) {
		Session s = hu.getSession();
		Movies ret = s.get(Movies.class, mov.getId());
		if(ret==null) {
			String query = "from Movies mov where mov.title=:title";
			Query<Movies> q = s.createQuery(query, Movies.class);
			q.setParameter("username", mov.getTitle());
			ret = q.getSingleResult();
		}
		s.close();
		return ret;
	}

	@Override
	public Movies getMovieById(Integer id) {
		Session s = hu.getSession();
		Movies ret = s.get(Movies.class, id);
		s.close();
		return ret;
	}

	@Override
	public Movies updateMovie(Movies mov) {
		log.trace("Update using this object: "+mov.getId());
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(mov);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, MoviesHibernate.class);
		} finally {
			s.close();
		}
		return mov;
	}

	@Override
	public Set<Movies> getMovies() {
		log.trace("attempting to open session and get movies from: "+ MoviesHibernate.class);
		Session s = hu.getSession();
		String query = "from Movies";
		Query<Movies> q = s.createQuery(query, Movies.class);
		List<Movies> movies = q.list();
		s.close();
		return new HashSet<Movies>(movies);
	}

}
