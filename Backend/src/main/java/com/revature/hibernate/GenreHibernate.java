package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Genre;
import com.revature.data.GenreDAO;
import com.revature.utils.HibernateUtil;


@Component
public class GenreHibernate implements GenreDAO{
	
	@Autowired
	private HibernateUtil hu;

	@Override
	public Genre getGenre(String genreName) {
		Session s = hu.getSession();
		String query = "from Genre g where g.genreName=:genreName";
		Query<Genre> q = s.createQuery(query, Genre.class);
		
		q.setParameter("genreName", genreName);
		Genre g = q.uniqueResult();
		s.close();
		return g;
	}

	@Override
	public Set<Genre> getGenres() {
		Session s = hu.getSession();
		String query = "from Genre";
		Query<Genre> q = s.createQuery(query, Genre.class);
		List<Genre> genres = q.list();
		s.close();
		return new HashSet<Genre>(genres);
	}

}
