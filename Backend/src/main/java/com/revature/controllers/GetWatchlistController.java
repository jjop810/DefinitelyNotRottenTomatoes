package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<Movies>> getWatchlist(@RequestBody String userWatchlist) {
		userWatchlist = userWatchlist.substring(1, userWatchlist.length() - 1);
		User watchlist = new User();
		String delims = "[,]";
		String[] tokens = userWatchlist.split(delims);
		watchlist.setId(Integer.parseInt(tokens[0]));
		watchlist.setUsername(tokens[1]);
		watchlist.setPassword(tokens[2]);
		watchlist.setEmail(tokens[3]);
		int page = Integer.parseInt(tokens[4]);
		return ResponseEntity.ok(wd.getWatchlist(watchlist, page));
	}
	
	@GetMapping
	public ResponseEntity<Integer> getLastPage() {
		return ResponseEntity.ok(wd.getLastPage());
	}
}
