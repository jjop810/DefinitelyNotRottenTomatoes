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

import com.revature.beans.Reviews;
import com.revature.beans.User;
import com.revature.data.ReviewDAO;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/review")
public class ReviewController {

	
	private static Logger log = Logger.getLogger(ReviewController.class);
	@Autowired
	private ReviewDAO rd;
	
	
	@PostMapping
	public ResponseEntity<Reviews> addReview(@RequestBody Reviews r) {
		rd.addReview(r);
		return ResponseEntity.status(201).body(r);
	}
	
	@GetMapping
	public ResponseEntity<Set<Reviews>> getReviews() {
		log.trace("getReviews called from controller.");
		return ResponseEntity.ok(rd.getReviews());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Set<Reviews>> getReviews(@PathVariable Integer id){
		return ResponseEntity.ok(rd.getUserReviews(id));
	}
	
	
	@GetMapping(value="/movies/review/{m}")
	public ResponseEntity<Set<Reviews>> getMovieRatingByUM(@PathVariable Integer m) {
		return ResponseEntity.ok(rd.getMovieReviews(m));
		
	}
	/*
	@GetMapping(value="{id}")
	public ResponseEntity<Reviews> getMovieReviewByID(@PathVariable Integer id) {
		Reviews r = rd.getReviewById(id);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
	
	*/
	@PostMapping(value = "/moviereview")
	public ResponseEntity<Reviews> getReviewId(@RequestBody Reviews r){
		log.trace(r);
		Reviews rev = rd.getReview(r.getUser(), r.getMovie());
		
		if(rev == null) {
			rd.addReview(r);
		}else {
			rev.setReview(r.getReview());
			rd.updateReview(rev);
		}
		return ResponseEntity.status(200).body(r);
	}
	
	
	@PutMapping(value="{id}")
	public ResponseEntity<Reviews> updateReview(@PathVariable Integer id, @RequestBody Reviews r) {
		Set<Reviews> rs = rd.getReviews();
		Integer idr = -1;
		for(Reviews rev : rs) {
			if(rev.getId()==id) {
				idr = id;
				break;
			}
		}
		
		if(idr < 1)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(rd.updateReview(r));
	}
}
