package com.revature.data;

import java.util.Set;

import com.revature.beans.MovieRating;
import com.revature.beans.Movies;
import com.revature.beans.User;

public interface MovieRatingDAO {
	//working
	public Set<MovieRating>getMovieRatings();
	public MovieRating getMovieRating(User u, Movies m);
	public Set<MovieRating>getMovieRatingByUserId(int i);
	public Set<MovieRating>getMovieRatingByMovieId(int i);
	public Integer addMovieRating(MovieRating m);
	public MovieRating updateMovieRating(MovieRating m);
	public void deleteMovieRating(MovieRating m);
	
	//checking
	//change the rating value into double and restrict it to <=10
	public Double getAverageRating(Movies m);
	
	//not using
	public MovieRating getMRById(int i);
	public Integer getMRByIDs(int i, int j);
	

}
