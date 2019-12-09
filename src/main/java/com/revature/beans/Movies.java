package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table

public class Movies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movies")
	@SequenceGenerator(name="movies", sequenceName="movies_seq", allocationSize=1)
	Integer id;
	String title;
	Integer movieLength;
	Integer genreId;
	Integer rating;
	String imgUrl;
	
	
	public Movies(Integer id, String title, Integer movieLength, Integer genreId, Integer rating, String imgUrl) {
		super();
		this.id = id;
		this.title = title;
		this.movieLength = movieLength;
		this.genreId = genreId;
		this.rating = rating;
		this.imgUrl = imgUrl;
	}
	public Movies() {
		super();
		
	}
	
	
	
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", movieLength=" + movieLength + ", genreId=" + genreId
				+ ", rating=" + rating + ", imgUrl=" + imgUrl + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((movieLength == null) ? 0 : movieLength.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movies other = (Movies) obj;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (movieLength == null) {
			if (other.movieLength != null)
				return false;
		} else if (!movieLength.equals(other.movieLength))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	

}
