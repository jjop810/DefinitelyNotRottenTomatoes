package com.revature.beans;

import javax.persistence.Column;
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
@Table(name="movierating")

public class MovieRating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movierating")
	@SequenceGenerator(name ="movierating",sequenceName = "movierating_seq", allocationSize = 1)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieid")
	private Movies movie;
	@Column(name="rating")
	private Integer ratingValue;
	
	
	public MovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MovieRating(Integer id, User user, Movies movie, Integer ratingValue) {
		super();
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.ratingValue = ratingValue;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	public Integer getRatingValue() {
		return ratingValue;
	}
	public void setRatingValue(Integer ratingValue) {
		this.ratingValue = ratingValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ratingValue == null) ? 0 : ratingValue.hashCode());
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
		MovieRating other = (MovieRating) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ratingValue == null) {
			if (other.ratingValue != null)
				return false;
		} else if (!ratingValue.equals(other.ratingValue))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovieRating [id=" + id + ", ratingValue=" + ratingValue + "]";
	}
	
}
