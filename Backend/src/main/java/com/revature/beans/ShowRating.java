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
@Table(name="showrating")

public class ShowRating {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "showrating" )
	@SequenceGenerator(name = "showrating", sequenceName = "showrating_seq", allocationSize = 1)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userid")
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "showid")
	private Shows show;
	@Column(name = "rating")
	private Integer ratingvalue;
	
	
	public ShowRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShowRating(Integer id, User user, Shows show, Integer ratingvalue) {
		super();
		this.id = id;
		this.user = user;
		this.show = show;
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
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	public Integer getRatingvalue() {
		return ratingvalue;
	}
	public void setRatingvalue(Integer ratingvalue) {
		this.ratingvalue = ratingvalue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ratingvalue == null) ? 0 : ratingvalue.hashCode());
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
		ShowRating other = (ShowRating) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ratingvalue == null) {
			if (other.ratingvalue != null)
				return false;
		} else if (!ratingvalue.equals(other.ratingvalue))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowRating [id=" + id + ", ratingvalue=" + ratingvalue + "]";
	}
}
