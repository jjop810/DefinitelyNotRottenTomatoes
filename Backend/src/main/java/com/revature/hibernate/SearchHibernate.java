package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Movies;
import com.revature.data.SearchDao;
import com.revature.utils.HibernateUtil;

@Component
public class SearchHibernate implements SearchDao{
	@Autowired
	private HibernateUtil hu;
	@Override
	public Set<Movies> getMovieSerarch(String title, Integer page) {
		Session s = hu.getSession();
		int pageSize = 200;	
		String query = "from Movies where upper(title) like '%"+title.toUpperCase()+"%'";
		Query<Movies> q = s.createQuery(query, Movies.class);		
		q.setMaxResults(pageSize);
		List<Movies> movies = q.list();
		s.close();
		return new HashSet<Movies>(movies);
	}
	
}
