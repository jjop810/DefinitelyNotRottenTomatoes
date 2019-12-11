package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Movies;


import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class MoviesHibernate implements MoviesDAO {
	
	@Autowired
	private HibernateUtil hu;

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
	public void updateMovie(Movies mov) {
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
	}

}
