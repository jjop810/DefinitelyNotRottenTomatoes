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
	
	@GetMapping
	public ResponseEntity<Set<MovieRating>> getMovieRatings(){
		return ResponseEntity.ok(mrd.getMovieRatings());
	}
	
//	@GetMapping(value="{m}")
//	public ResponseEntity<MovieRating> getMovieRatingByUM(@PathVariable Integer u,@PathVariable Integer m) {
//		MovieRating r = mrd.getMRByIDs(u, m);
//		if(r==null)
//			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok(r);
//	}
//
//	@GetMapping(value="{u}")
//	public ResponseEntity<Set<MovieRating>> getMovieRatingByUM(@PathVariable Integer u) {
//		return ResponseEntity.ok(mrd.getMovieRatingByUserId(u));
//		
//	}
	@GetMapping(value="{id}")
	public ResponseEntity<MovieRating> getMovieRatingByID(@PathVariable Integer id) {
		MovieRating r = mrd.getMRById(id);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<MovieRating>getRatingId(@RequestBody MovieRating m ){
		
//		User u = ud.getUserById(uid);
//		Movies m = md.getMovieById(mid);
//		MovieRating movierate = mrd.getMovieRating(u, m);
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
	
	
	@PostMapping
	public ResponseEntity<MovieRating> addMovieRating(@RequestBody MovieRating m) {
		mrd.addMovieRating(m);
		return ResponseEntity.status(201).body(m);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<MovieRating> updateMovieRating(@PathVariable Integer id, @RequestBody MovieRating m) {
		if(mrd.getMRById(id) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(mrd.updateMovieRating(m));
	}

	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteMovieRating(@PathVariable Integer id) {
		if(mrd.getMRById(id) == null)
			return ResponseEntity.status(405).build();
		mrd.deleteMovieRating(mrd.getMRById(id));
		return ResponseEntity.noContent().build();
	}


	
	
}
