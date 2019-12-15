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
@Table (name = "shows")
public class Shows {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shows")
	@SequenceGenerator(name="shows", sequenceName="shows_seq", allocationSize=1)
	Integer id;
	String title;
	Integer episodes;
	Integer rating;
	String imgUrl;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="showGenre",
		joinColumns=@JoinColumn(name="showid"),
		inverseJoinColumns=@JoinColumn(name="genreid"))
	private Set<Genre> genres;
	
	public Shows() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Shows(Integer id, String title, Integer episodes, Integer rating, String imgUrl, Set<Genre> genres) {
		super();
		this.id = id;
		this.title = title;
		this.episodes = episodes;
		this.rating = rating;
		this.imgUrl = imgUrl;
		this.genres = genres;
	}




	public Set<Genre> getGenres() {
		return genres;
	}




	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}




	public Integer getEpisodes() {
		return episodes;
	}


	public void setEpisodes(Integer episodes) {
		this.episodes = episodes;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((episodes == null) ? 0 : episodes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
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
		Shows other = (Shows) obj;
		if (episodes == null) {
			if (other.episodes != null)
				return false;
		} else if (!episodes.equals(other.episodes))
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
		return "Shows [id=" + id + ", title=" + title + ", episodes=" + episodes + ", rating=" + rating + ", imgUrl="
				+ imgUrl + ", genres=" + genres + "]";
	}
	
	
	
	

}
