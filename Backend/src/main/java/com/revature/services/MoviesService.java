package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;

@Service
public class MoviesService {

	@Autowired
	private MoviesDAO md;
	
	public Movies getMovie(String name) {
		return md.getMovie(name);
	}
	
	public Movies getMovie(Movies mov) {
		return md.getMovie(mov);
	}
	
	public Movies getMovieById(Movies mov) {
		return md.getMovieById(mov);
	}
	
	public int addMovie(Movies mov) {
		return md.addMovie(mov);
	}
	
	public void updateMovie(Movies mov) {
		md.updateMovie(mov);
	}
}
