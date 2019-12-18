package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Watchlist;
import com.revature.data.WatchlistDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/watchlist")
public class WatchlistController {
	@Autowired
	private WatchlistDAO wd;
	
	@PostMapping
	public ResponseEntity<Watchlist> addWatchlist(@RequestBody Watchlist wl) {
		System.out.println("In Controller");
		wd.addMovie(wl);
		return ResponseEntity.status(201).body(wl);
	}
	
	@GetMapping
	public ResponseEntity<Set<Watchlist>> getWatchlist() {
		return ResponseEntity.ok(wd.getWatchlist(0));
		//TODO: Get the current users ID then change the 0 above to be that
	}
}
