package com.revature.data;

import java.util.Set;

import com.revature.beans.Genre;

public interface GenreDAO {

	
	
	public Genre getGenre(String name);
	
	public Set<Genre> getGenres();
}
