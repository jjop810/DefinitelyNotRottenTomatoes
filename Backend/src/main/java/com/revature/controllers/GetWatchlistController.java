package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.data.WatchlistDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/getwatchlist")
public class GetWatchlistController {
	@Autowired
	private WatchlistDAO wd;
	
	@PostMapping
	public ResponseEntity<Set<Movies>> getWatchlist(@RequestBody User userWatchlist) {
		
		System.out.println("\n\n\n\n" + userWatchlist.toString() + "\n\n\n\n");
		return ResponseEntity.ok(wd.getWatchlist(userWatchlist));
	}
}
