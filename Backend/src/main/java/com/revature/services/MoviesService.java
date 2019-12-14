package com.revature.services;

import java.util.Set;
import com.revature.beans.Movies;

public interface MoviesService {
	public Set<Movies> getMovies(Integer page);
	public Integer getLastPage();}
