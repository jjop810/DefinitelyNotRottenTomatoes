package com.revature.controllers;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Reviews;
import com.revature.data.ReviewDAO;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/reviews")
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
	
	@GetMapping(value="{userid,movieid}")
	public ResponseEntity<Reviews> getReview(@PathVariable Integer userid, @PathVariable Integer movieid){
		Reviews r = rd.getReview(userid,movieid);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Reviews> getReview(@PathVariable Integer id, @RequestBody Reviews review) {
		log.trace("getReview called from controller.  (1 Review) with this Review: "+ review);
		Reviews r = rd.getReview(review);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
}
