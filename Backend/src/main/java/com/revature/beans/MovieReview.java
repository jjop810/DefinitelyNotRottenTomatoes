package com.revature.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="moviereviews")
public class MovieReview {
	
	
	private String review;
	
	
	public MovieReview() {
		super();
		
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public MovieReview(String review) {
		super();
		this.review = review;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieReview other = (MovieReview) obj;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MovieReview [review=" + review + "]";
	}
	
	
	
	
}
