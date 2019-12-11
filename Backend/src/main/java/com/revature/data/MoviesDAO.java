package com.revature.data;

import com.revature.beans.Movies;

public interface MoviesDAO {
	
	/**
	 * Returns the id of a movie object inserted into the database.
	 * 
	 * @param mov the movie object to be inserted
	 * @return the id of the movie object inserted
	 */
public int addMovie(Movies mov);
	
	/**
	 * returns a movie object
	 * 
	 * @param name the name of the movie
	 * @return the movie from the database.
	 */	
	public Movies getMovie(String name);
	/**
	 * returns a movie object from the database
	 * 
	 * @param movie previously created movie object
	 * @return the movie from the database that matches the name, and id
	 */
	public Movies getMovie(Movies mov);
	/**
	 * returns a movie object from the database
	 * 
	 * @param u previously created movie object for updating with movie information
	 * @return the movie from the database that matches the name, director, and year
	 */
	public Movies getMovieById(Movies mov);
	
	
	/**
	 * updates a Movie in the database
	 * 
	 * @param movies the Movies to be updated
	 */
	public void updateMovie(Movies mov);
}