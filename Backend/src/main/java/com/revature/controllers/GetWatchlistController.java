package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value="{userWatchlist}")
	public ResponseEntity<List<Movies>> getWatchlist(@PathVariable String userWatchlist) {
		User watchlist = new User();
		String delims = "[,]";
		String[] tokens = userWatchlist.split(delims);
		System.out.println(tokens.toString());
		for(int i=0; i < tokens.length; i++)
			System.out.println(tokens[i]);
		watchlist.setId(Integer.parseInt(tokens[0]));
		watchlist.setUsername(tokens[1]);
		int page = Integer.parseInt(tokens[2]);
		System.out.println(watchlist.toString());
		return ResponseEntity.ok(wd.getWatchlist(watchlist, page));
	}
	
	@GetMapping
	public ResponseEntity<Integer> getLastPage() {
		return ResponseEntity.ok(wd.getLastPage());
	}
}
