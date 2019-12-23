package com.revature.data;

import java.util.Set;

import com.revature.beans.Movies;

public interface SearchDao {
	Set<Movies> getMovieSerarch(String title, Integer page);
	Integer getLastPage();
}
