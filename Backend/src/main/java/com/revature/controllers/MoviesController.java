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
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;

//@RestController
//@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(value="/movies")
public class MoviesController {

	//@Autowired
	private MoviesDAO rd;
	
	@GetMapping
	public ResponseEntity<Set<Movies>> getMovies() {
		return ResponseEntity.ok(rd.getMovies());
	}
	
	@GetMapping(value="{title}")
	public ResponseEntity<Movies> getMovie(@PathVariable String title) {
		Movies r = rd.getMovie(title);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
	@PostMapping
	public ResponseEntity<Movies> addMovie(@RequestBody Movies r) {
		rd.addMovie(r);
		return ResponseEntity.status(201).body(r);
	}
	@PutMapping(value="{title}")
	public ResponseEntity<Movies> updateMovies(@PathVariable String title, @RequestBody Movies r) {
		if(rd.getMovie(title) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(rd.updateMovie(r));
	}
	
	
}
