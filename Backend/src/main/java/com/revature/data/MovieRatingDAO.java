package com.revature.data;

import java.util.Set;

import com.revature.beans.MovieRating;
import com.revature.beans.Movies;
import com.revature.beans.User;

public interface MovieRatingDAO {
	//working
	public Set<MovieRating>getMovieRatings();
	public MovieRating getMRById(int i);
	public Integer addMovieRating(MovieRating m);
	public MovieRating updateMovieRating(MovieRating m);
	public void deleteMovieRating(MovieRating m);
	//not working
	public Set<MovieRating>getMovieRatingByUserId(int i);
	public Set<MovieRating>getMovieRatingByMovieId(int i);
	public MovieRating getMovieRating(User u, Movies m);
	public Integer getMRByIDs(int i, int j);
	

}
