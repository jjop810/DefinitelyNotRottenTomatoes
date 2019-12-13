package com.revature.services;

import java.util.Set;

import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;
import com.revature.hibernate.MoviesHibernate;


public class MoviesServiceHibernate implements MoviesService{
	private static MoviesDAO md = new MoviesHibernate();
	@Override
	public Set<Movies> getMovies() {
		return md.getMovies();
	}

}
