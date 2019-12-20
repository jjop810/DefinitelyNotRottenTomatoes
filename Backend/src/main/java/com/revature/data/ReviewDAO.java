package com.revature.data;

import java.util.Set;

import com.revature.beans.Movies;
import com.revature.beans.Reviews;
import com.revature.beans.User;

public interface ReviewDAO {
	
	public int addReview(Reviews rev);
	
	public Set<Reviews> getReviews();
	
	public Set<Reviews>  getMovieReviews(Integer movid);
	
	public Set<Reviews> getUserReviews(Integer userid);
	
	public Reviews getReview(User u, Movies m);
	
	public Reviews getReviewById(Integer id);
	
	public Reviews getReviewSingle(Reviews rev);
	
	public Reviews updateReview(Reviews rev);
	
	public void deleteReview(Reviews rev);

}
