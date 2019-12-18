package com.revature.data;

import java.util.Set;

import com.revature.beans.Movies;
import com.revature.beans.Reviews;
import com.revature.beans.User;

public interface ReviewDAO {
	
	public int addReview(Reviews rev);
	
	public Set<Reviews> getReviews();
	
	public Reviews getReview(Integer uid, Integer movid);
	
	public Reviews getReview(Reviews rev);
	
	public Reviews updateReview(Reviews rev);

}
