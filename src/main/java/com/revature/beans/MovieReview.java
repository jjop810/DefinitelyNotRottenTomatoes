package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class MovieReview {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieReview")
	@SequenceGenerator(name = "movieReview", sequenceName = "movieReview_seq", allocationSize = 1)
	
	private Integer id;
	private User u;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private Movie m;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId")
	private String review;
	
	public MovieReview() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Movie getM() {
		return m;
	}

	public void setM(Movie m) {
		this.m = m;
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
		MovieReview other = (MovieReview) obj;
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
		return "MovieReview [id=" + id + ", review=" + review + "]";
	}
		
	
}
