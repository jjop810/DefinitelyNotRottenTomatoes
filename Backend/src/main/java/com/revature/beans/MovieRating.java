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
@Table(name = "movierating")
public class MovieRating {

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movierating")
//	@SequenceGenerator(name = "movierating", sequenceName = "movierating_seq", allocationSize=1)
//	private Integer id;
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "userid")
//	private Integer user;
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "movieid")
//	private Integer movie;
//	@Column(name = "ratingvalue")
//	private Double ratingvalue;
//	
//	public MovieRating() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Integer getUser() {
//		return user;
//	}
//	public void setUser(Integer user) {
//		this.user = user;
//	}
//	public Integer getMovie() {
//		return movie;
//	}
//	public void setMovie(Integer movie) {
//		this.movie = movie;
//	}
//	public Double getRatingvalue() {
//		return ratingvalue;
//	}
//	public void setRatingvalue(Double ratingvalue) {
//		this.ratingvalue = ratingvalue;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
//		result = prime * result + ((ratingvalue == null) ? 0 : ratingvalue.hashCode());
//		result = prime * result + ((user == null) ? 0 : user.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		MovieRating other = (MovieRating) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (movie == null) {
//			if (other.movie != null)
//				return false;
//		} else if (!movie.equals(other.movie))
//			return false;
//		if (ratingvalue == null) {
//			if (other.ratingvalue != null)
//				return false;
//		} else if (!ratingvalue.equals(other.ratingvalue))
//			return false;
//		if (user == null) {
//			if (other.user != null)
//				return false;
//		} else if (!user.equals(other.user))
//			return false;
//		return true;
//	}
//	@Override
//	public String toString() {
//		return "MovieRating [id=" + id + ", user=" + user + ", movie=" + movie + ", ratingvalue=" + ratingvalue + "]";
//	}
//	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movierating")
	@SequenceGenerator(name = "movierating", sequenceName = "movierating_seq", allocationSize=1)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieid")
	private Movies movie;
	@Column(name = "ratingvalue")
	private Double ratingvalue;
	
	public MovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MovieRating(Integer id, User user, Movies movie, Double ratingvalue) {
		super();
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.ratingvalue = ratingvalue;
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
	public Double getRatingvalue() {
		return ratingvalue;
	}
	public void setRatingvalue(Double ratingvalue) {
		this.ratingvalue = ratingvalue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((ratingvalue == null) ? 0 : ratingvalue.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (ratingvalue == null) {
			if (other.ratingvalue != null)
				return false;
		} else if (!ratingvalue.equals(other.ratingvalue))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovieRating [id=" + id + ", user=" + user + ", movie=" + movie + ", ratingvalue=" + ratingvalue + "]";
	}
	
	
	
}
