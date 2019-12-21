package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Admin;
import com.revature.beans.LoginInfo;
import com.revature.beans.User;
import com.revature.data.AdminDAO;
import com.revature.data.UserDAO;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping(value = "/logined")
public class LoginController {
	
	@Autowired
	private UserDAO ud;
	@Autowired
	private AdminDAO ad;
	
	@GetMapping
	public ResponseEntity<LoginInfo> login(HttpSession session) {
		LoginInfo l = (LoginInfo) session.getAttribute("loggedUser");
		System.out.println(l);
		if(l == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(l);
	}

	@PostMapping
	public ResponseEntity<LoginInfo> login(@RequestParam("user") String username, 
			@RequestParam("pass") String password, HttpSession session) {
			User u = ud.getUser(username, password);
			Admin a= null;
			if(u == null) {
			 a = ad.getAdmin(username, password);
			}
		
		if(u==null && a==null) {
			return ResponseEntity.status(401).build();
		}
		LoginInfo loggedUser = new LoginInfo(a,u);
		session.setAttribute("loggedUser", loggedUser);
		return ResponseEntity.ok(loggedUser);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}


}
