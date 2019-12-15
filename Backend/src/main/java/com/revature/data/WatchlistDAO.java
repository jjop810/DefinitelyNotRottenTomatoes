package com.revature.data;

import java.util.Set;

import com.revature.beans.Watchlist;

public interface WatchlistDAO {
	Set<Watchlist> getWatchlist(Integer userId);
	
	/**
	 * Returns the id of a watchlist object inserted into the database.
	 * 
	 * @param watch the watchlist object to be inserted
	 * @return the id of the watchlist object inserted
	 */
	public Integer addMovie(Watchlist watch);

}
