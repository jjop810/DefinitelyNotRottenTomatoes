package com.revature.data;

import java.util.Set;

import com.revature.beans.Movies;


public interface MoviesDAO {
	Set<Movies> getMovies(Integer page);
	
	Integer getLastPage();
}
