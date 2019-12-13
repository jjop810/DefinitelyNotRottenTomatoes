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
}
