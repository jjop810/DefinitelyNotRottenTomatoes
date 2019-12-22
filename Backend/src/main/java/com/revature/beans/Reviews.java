package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reviews")
	@SequenceGenerator(name="reviews", sequenceName="reviews_seq", allocationSize=1)
	private Integer id;
	private String review;
	@ManyToOne
	@JoinColumn(name="movieid")
	private Movies movie;
	
	
	@ManyToOne
	@JoinColumn(name="userid")
    private User user;
	
	
	
	
	
	public Reviews() {
		super();
		
	}
	

	public Reviews(Integer id) {
		this.id = id;
	}
	
	
	
	public Reviews(Integer id, String review, Movies movies, User users) {
		super();
		this.id = id;
		this.review = review;
		this.movie = movies;
		this.user = users;
	}




	public Movies getMovie() {
		return movie;
	}


	public void setMovie(Movies movie) {
		this.movie = movie;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Reviews other = (Reviews) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", review=" + review + ", movie=" + movie + "]";
	}
	
	
	
	
}
