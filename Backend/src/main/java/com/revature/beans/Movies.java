package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "movies")
public class Movies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movies")
	@SequenceGenerator(name="movies", sequenceName="movies_seq", allocationSize=1)
	Integer id;
	String title;
	Integer movieLength;
	Integer rating;
	String imgUrl;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="movieGenre",
		joinColumns=@JoinColumn(name="movieid"),
		inverseJoinColumns=@JoinColumn(name="genreid"))
	private Set<Genre> genres;
	
	
	public Movies() {
		super();
	}
	public Movies(Integer id, String title, Integer movieLength, Integer rating, String imgUrl, Set<Genre> genres) {
		super();
		this.id = id;
		this.title = title;
		this.movieLength = movieLength;
		this.rating = rating;
		this.imgUrl = imgUrl;
		this.genres = genres;
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
	public Set<Genre> getGenres() {
		return genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
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
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
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
	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", movieLength=" + movieLength + ", rating=" + rating
				+ ", imgUrl=" + imgUrl + ", genres=" + genres + "]";

	}

	
}