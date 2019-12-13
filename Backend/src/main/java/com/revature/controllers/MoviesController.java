package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
