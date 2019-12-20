package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.MovieRating;
import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.data.MovieRatingDAO;
import com.revature.data.MoviesDAO;
import com.revature.data.UserDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/movierating")

public class MovierRatingController {

	@Autowired
	private MovieRatingDAO mrd;
	@Autowired
	private UserDAO ud;
	@Autowired
	private MoviesDAO md;
	
	//Getting all the movie ratings
	@GetMapping
	public ResponseEntity<Set<MovieRating>> getMovieRatings(){
		return ResponseEntity.ok(mrd.getMovieRatings());
	}
	

	//Getting movie ratings by movie id
	@GetMapping(value="/movies/ratings/{m}")
	public ResponseEntity<Set<MovieRating>> getMovieRatingByUM(@PathVariable Integer m) {
		return ResponseEntity.ok(mrd.getMovieRatingByMovieId(m));
		
	}
	
	//Getting movie ratings by user id
	@GetMapping(value="{id}")
	public ResponseEntity<Set<MovieRating>> getMovieRatingByUserID(@PathVariable Integer id) {
		
		return ResponseEntity.ok( mrd.getMovieRatingByUserId(id));
	}
	
	//Adding or updating using movie rating sent from the front end
	@PostMapping(value = "/add")
	public ResponseEntity<MovieRating>getRatingId(@RequestBody MovieRating m ){
		
		MovieRating movrate = mrd.getMovieRating(m.getUser(), m.getMovie());
			
		if(movrate == null) {
			
			mrd.addMovieRating(m);
		}
		else
		{
			movrate.setRatingvalue(m.getRatingvalue());
			System.out.println("here: " + movrate);
			mrd.updateMovieRating(movrate);
		}
		return ResponseEntity.status(200).body(m);
	}
	
	//Adding using  the movie
	@PostMapping
	public ResponseEntity<MovieRating> addMovieRating(@RequestBody MovieRating m) {
		mrd.addMovieRating(m);
		return ResponseEntity.status(201).body(m);
	}

	//Updating using movie rating id
	@PutMapping(value = "{id}")
	public ResponseEntity<MovieRating> updateMovieRating(@PathVariable Integer id, @RequestBody MovieRating m) {
		if(mrd.getMRById(id) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(mrd.updateMovieRating(m));
	}

	//Deleting using movie rating id
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteMovieRating(@PathVariable Integer id) {
		if(mrd.getMRById(id) == null)
			return ResponseEntity.status(405).build();
		mrd.deleteMovieRating(mrd.getMRById(id));
		return ResponseEntity.noContent().build();
	}


	
	
}
