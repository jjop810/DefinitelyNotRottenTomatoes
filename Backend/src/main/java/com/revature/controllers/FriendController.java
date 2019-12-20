package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.data.FriendDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/friends")
public class FriendController {
	
	@Autowired
	private FriendDAO fd;
	
	@GetMapping
	public ResponseEntity<Set<User>> getFriends() {
		return ResponseEntity.ok(fd.getFriends());
	}
	

}