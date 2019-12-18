package com.revature.controllers;

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
@RequestMapping(value="/movies/edit")
public class EditMovieController {
	@Autowired
	private MoviesDAO md;
	
	@GetMapping(value="{id}")
	public ResponseEntity<Movies> getMovieByid(@PathVariable Integer id) {
		Movies m = md.getMovieById(id);
		if(m==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(m);
	}

}
