package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="moviereviews")
public class MovieReview {
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="movies",
		joinColumns=@JoinColumn(name="userid"),
		inverseJoinColumns=@JoinColumn(name="movieid"))
	private Set<Object> moviereviews;
	
	String review;
	
}
