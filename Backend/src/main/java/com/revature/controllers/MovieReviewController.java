package com.revature.controllers;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.MovieReview;

import com.revature.data.MovieReviewDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/review")
public class MovieReviewController {

	
	private static Logger log = Logger.getLogger(MovieReviewController.class);
	@Autowired
	private MovieReviewDAO mr;
	
	@GetMapping
	public ResponseEntity<Set<MovieReview>> getMovies() {
		return ResponseEntity.ok(mr.getReviews());
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<MovieReview> addMovie(@RequestBody MovieReview r) {
		mr.addReview(r);
		return ResponseEntity.status(201).body(r);
	}
	

	@PutMapping(value="{id}")
	public ResponseEntity<MovieReview> updateMovies(@PathVariable Integer userid,@PathVariable Integer movieid, @RequestBody MovieReview r) {
		if(mr.getReview(r.getReview()) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(mr.updateReview(r));
	}
	
}
