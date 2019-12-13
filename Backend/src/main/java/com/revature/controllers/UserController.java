package com.revature.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class UserController {

	@Autowired
	private UserDAO ud;
	
	@GetMapping
	public ResponseEntity<Set<User>> getUsers() {
		
		return ResponseEntity.ok(ud.getUsers());
		
	}
	
//	@GetMapping
//	public ResponseEntity<User> login(HttpSession session) {
//		User u = (User) session.getAttribute("loggedUser");
//		if(u == null)
//			return ResponseEntity.status(401).build();
//		return ResponseEntity.ok(u);
//	}

	
//	@PostMapping
//	public ResponseEntity<User> login(@RequestParam String username,@RequestParam String password, HttpSession session) {
//		User u = ud.getUser(username, password);
//		if(u==null) {
//			return ResponseEntity.status(401).build();
//		}
//		session.setAttribute("loggedUser", u);
//		return ResponseEntity.ok(u);
//
//	}
//	
//	@DeleteMapping
//	public ResponseEntity<Void> logout(HttpSession session) {
//		session.invalidate();
//		return ResponseEntity.noContent().build();
//	}

	
	@GetMapping(value = "{id}")
	public ResponseEntity<User> getRanger(@PathVariable Integer id) {
		User u = ud.getUserById(id);
		if(u ==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(u);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User u) {
		ud.addUser(u);
		return ResponseEntity.status(201).body(u);
	}
	@PutMapping(value="{id}")
	public ResponseEntity<User> updateRanger(@PathVariable Integer id, @RequestBody User u) {
		if(ud.getUserById(id) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(ud.updateUser(u));
	}
	
	

}
