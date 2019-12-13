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

import com.revature.beans.Movies;
import com.revature.data.MoviesDAO;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/movies")
public class MoviesController {
	private static Logger log = Logger.getLogger(MoviesController.class);
	@Autowired
	private MoviesDAO rd;
	
	@GetMapping
	public ResponseEntity<Set<Movies>> getMovies() {
		log.trace("getMovies called from controller.");
		return ResponseEntity.ok(rd.getMovies());
	}
	
	@GetMapping(value="{title}")
	public ResponseEntity<Movies> getMovie(@PathVariable String title) {
		log.trace("getMovie called from controller.  (1 movie) with this title: "+ title);
		Movies r = rd.getMovie(title);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
	@PostMapping
	public ResponseEntity<Movies> addMovie(@RequestBody Movies r) {
		log.trace("adding movie through controller");
		rd.addMovie(r);
		return ResponseEntity.status(201).body(r);
	}
	@PutMapping(value="{id}")
	public ResponseEntity<Movies> updateMovies(@PathVariable Integer id, @RequestBody Movies r) {
		if(rd.getMovieById(id) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(rd.updateMovie(r));
	}
	
	
}
