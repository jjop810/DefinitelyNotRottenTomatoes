//package com.revature.controllers;
//
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.beans.User;
//import com.revature.data.FriendsDAO;
//
//@RestController
//@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(value="/Friends")
//public class FriendsController {
//	
//	@Autowired
//	private FriendsDAO fd;
//	
//	@GetMapping
//	public ResponseEntity<Set<User>> getFriends() {
//		return ResponseEntity.ok(fd.getFriends());
//	}
//	
//	@GetMapping(value="{id}")
//	public ResponseEntity<User> getFriend(@PathVariable Integer id) {
//		User f = fd.getFriend(id);
//		if(f==null)
//			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok(f);
//	}
//	@PostMapping
//	public ResponseEntity<User> addFriend(@RequestBody User f) {
//		fd.addFriend(f);
//		return ResponseEntity.status(201).body(f);
//	}
//	@PutMapping(value="{id}")
//	public ResponseEntity<User> updateFriend(@PathVariable Integer id, @RequestBody User f) {
//		if(fd.getFriend(id) == null)
//			return ResponseEntity.status(405).body(null);
//		return ResponseEntity.ok(fd.updateFriend(f));
//	}
//	@DeleteMapping(value="{id}")
//	public ResponseEntity<Void> deleteFriend(@PathVariable Integer id) {
//		if(fd.getFriend(id) == null)
//			return ResponseEntity.status(405).build();
//		fd.deleteFriend(fd.getFriend(id));
//		return ResponseEntity.noContent().build();
//	}
//
//}
