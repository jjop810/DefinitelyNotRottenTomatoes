package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.revature.utils.HibernateUtil;
import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;

@Component
public class MoviesHibernate implements MoviesDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Set<Movies> getMovies() {
		Session s = hu.getSession();
		
		int pageSize = 100;
		String count = "Select count (m.id) from Movies m";
		Query countQuery = s.createQuery(count);
		Long countResults = (Long) countQuery.uniqueResult();
		int lastPageNumber = (int) (Math.ceil(countResults / pageSize));
		System.out.println(count);
		String query = "from Movies";
		Query<Movies> q = s.createQuery(query, Movies.class);
		q.setFirstResult((lastPageNumber - 1) * pageSize);
		q.setMaxResults(pageSize);
		List<Movies> movies = q.list();
		s.close();
		return new HashSet<Movies>(movies);
	}
}
