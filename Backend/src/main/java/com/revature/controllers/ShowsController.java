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

import com.revature.beans.Shows;
import com.revature.data.ShowsDAO;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/shows")
public class ShowsController {

	@Autowired
	private ShowsDAO rd;
	
	@GetMapping
	public ResponseEntity<Set<Shows>> getShow() {
		return ResponseEntity.ok(rd.getShows());
	}
	
	@GetMapping(value="{title}")
	public ResponseEntity<Shows> getShows(@PathVariable String title) {
		Shows r = rd.getShow(title);
		if(r==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(r);
	}
	@PostMapping
	public ResponseEntity<Shows> addShow(@RequestBody Shows r) {
		rd.addShow(r);
		return ResponseEntity.status(201).body(r);
	}
	@PutMapping(value="{title}")
	public ResponseEntity<Shows> updateShows(@PathVariable String title, @RequestBody Shows r) {
		if(rd.getShow(title) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(rd.updateShow(r));
	}
}
