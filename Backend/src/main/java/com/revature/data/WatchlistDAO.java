package com.revature.data;

import java.util.Set;

import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.beans.Watchlist;

public interface WatchlistDAO {
	
	Set<Movies> getWatchlist(User userId);
	public Integer addMovie(Watchlist watch);

}
