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
import com.revature.data.SearchDao;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/movies/search")
public class SerachController {
	
	@Autowired
	private SearchDao sd;
	
	@GetMapping(value="{parseTxt}")
	public ResponseEntity<Set<Movies>> getMovieSerarch(@PathVariable String parseTxt) {
		System.out.println(parseTxt);
		String delims = "[|]";
		String[] tokens = parseTxt.split(delims);
		
		return ResponseEntity.ok(sd.getMovieSerarch(tokens[0], Integer.parseInt(tokens[1])));
	}
}
