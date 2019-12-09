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
public class WatchList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watchlist")
	@SequenceGenerator(name = "watchlist", sequenceName = "watchlist_seq", allocationSize = 1)
	
	private Integer id;
	private User u;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private Shows s;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "showId")
	private Movie m;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId")
	public WatchList() {
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

	public Shows getS() {
		return s;
	}

	public void setS(Shows s) {
		this.s = s;
	}

	public Movie getM() {
		return m;
	}

	public void setM(Movie m) {
		this.m = m;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		WatchList other = (WatchList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WatchList [id=" + id + "]";
	}
	
	
	
	

}
