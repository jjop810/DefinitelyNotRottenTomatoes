package com.revature.data;

import java.util.Set;

import com.revature.beans.Watchlist;

public interface WatchlistDAO {
	
	Set<Watchlist> getWatchlist(Integer userId);
	public Integer addMovie(Watchlist watch);

}
