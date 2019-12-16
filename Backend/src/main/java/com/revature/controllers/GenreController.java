package com.revature.controllers;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Genre;
import com.revature.data.GenreDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/genre")
public class GenreController {

	
	private static Logger log = Logger.getLogger(GenreController.class);
	@Autowired
	private GenreDAO rd;
	
	@GetMapping
	public ResponseEntity<Set<Genre>> getGenres() {
		log.trace("getGenres called from controller.");
		return ResponseEntity.ok(rd.getGenres());
	}
	
	@GetMapping(value="{genreName}")
	public ResponseEntity<Genre> getGenre(@PathVariable String genreName) {
		log.trace("getGenre called from controller.  (1 genre) with this genreName: "+ genreName);
		Genre r = rd.getGenre(genreName);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
}
