package com.revature.data;

import java.util.Set;

import com.revature.beans.MovieReview;

public interface MovieReviewDAO {

	public Set<MovieReview> getReviews();
	
	public MovieReview getReview(String review);
	
	public MovieReview addReview(MovieReview rev);
	
	public MovieReview updateReview(MovieReview rev);
	
}
