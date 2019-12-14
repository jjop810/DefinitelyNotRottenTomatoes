package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;
import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;

@Component
public class MoviesHibernate implements MoviesDAO {
	@Autowired
	private HibernateUtil hu;
	
	private Integer lastPageNumber = 0;
	@Override
	public Set<Movies> getMovies(Integer page) {
		Session s = hu.getSession();
		int pageSize = 50;
		String count = "Select count (m.id) from Movies m";
		Query<Long> countQuery = s.createQuery(count, Long.class);
		Long countResults = countQuery.uniqueResult();
		lastPageNumber = (int) (Math.ceil(countResults / pageSize));
		if(page > lastPageNumber)
		{
			page = lastPageNumber;
		}
		else if(page < 1)
		{
			page = 1;
		}
		String query = "from Movies order by title asc";
		Query<Movies> q = s.createQuery(query, Movies.class);
		q.setFirstResult((page - 1) * pageSize);
		q.setMaxResults(pageSize);
		List<Movies> movies = q.list();
		s.close();
		return new HashSet<Movies>(movies);
	}
	@Override
	public Integer getLastPage() {
		System.out.println("test" + lastPageNumber);
		return lastPageNumber;
	}
	@Override
	public int addMovie(Movies mov) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(mov);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, MoviesHibernate.class);
		} finally {
			s.close();
		}
		return i;
		
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
	public Movies getMovieById(Movies mov) {
		Session s = hu.getSession();
		Movies ret = s.get(Movies.class, mov.getId());
		s.close();
		return ret;
	}

	@Override
	public Movies updateMovie(Movies mov) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(mov.getId());
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
		Session s = hu.getSession();
		String query = "from Movies";
		Query<Movies> q = s.createQuery(query, Movies.class);
		List<Movies> movies = q.list();
		s.close();
		return new HashSet<Movies>(movies);
	}
}
