package com.revature.controllers;

import java.util.Set;

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

import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/movies")
public class MoviesController {
	@Autowired
	private MoviesDAO md;
	
	@GetMapping(value="{page}")
	public ResponseEntity<Set<Movies>> getMovies(@PathVariable Integer page) {
		return ResponseEntity.ok(md.getMovies(page));
	}
	
	@GetMapping
	public ResponseEntity<Integer> getLastPage() {
		return ResponseEntity.ok(md.getLastPage());
	}
	/*
	@GetMapping(value="{title}")
	public ResponseEntity<Movies> getMovie(@PathVariable String title) {
		Movies r = md.getMovie(title);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}*/
	
	@PostMapping
	public ResponseEntity<Movies> addMovie(@RequestBody Movies r) {
		md.addMovie(r);
		return ResponseEntity.status(201).body(r);
	}
	
	@PutMapping(value="{title}")
	public ResponseEntity<Movies> updateMovies(@PathVariable String title, @RequestBody Movies r) {
		if(md.getMovie(title) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(md.updateMovie(r));
	}
}
