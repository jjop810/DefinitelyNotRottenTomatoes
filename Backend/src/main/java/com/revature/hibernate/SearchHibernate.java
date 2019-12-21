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
	private Integer lastPageNumber = 0;
	@Override
	public Set<Movies> getMovieSerarch(String title, Integer page) {
		Session s = hu.getSession();
		int pageSize = 50;	
		String count = "Select count (m.id) from Movies m";
		Query<Long> countQuery = s.createQuery(count, Long.class);
		Long countResults = countQuery.uniqueResult();
		lastPageNumber = (int) (Math.ceil(countResults / (float)pageSize));
		if(page > lastPageNumber)
		{
			page = lastPageNumber;
		}
		else if(page < 1)
		{
			page = 1;
		}
		String query = "from Movies where upper(title) like '%"+title.toUpperCase()+"%' order by title asc";
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
