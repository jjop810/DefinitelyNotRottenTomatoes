package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.beans.Watchlist;

public interface WatchlistDAO {
	
	List<Movies> getWatchlist(User userId, Integer page);
	Integer getLastPage();
	public Integer addMovie(Watchlist watch);
	Set<Movies> getMovieSerarch(String title, Integer page, Integer userId);
}
