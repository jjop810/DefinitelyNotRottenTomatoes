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
import com.revature.data.UserDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/friends")
public class FriendController {
	
	@Autowired
	private UserDAO ud;
	
	@GetMapping(value = "{name}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String name) {
		User u = ud.getUserByUsername(name);
		if(u ==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(u);
	}

}