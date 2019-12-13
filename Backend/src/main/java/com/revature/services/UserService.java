package com.revature.services;

import com.revature.beans.User;

public interface UserService {
	
	public User getUser(String username, String password);
	public User getUserById(int i);
	public void deleteUser(User u);
	public void updateUser(User u);
	public void addUser(User u);
}
