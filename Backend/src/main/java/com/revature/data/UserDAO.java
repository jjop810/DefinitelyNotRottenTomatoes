package com.revature.data;

import java.util.Set;

import com.revature.beans.User;

public interface UserDAO {

	public Integer addUser(User u);
	public User getUser(String username, String password);
	public User getUser(User u);
	public User getUserById(Integer i);
	Set<User>getUsers();
	public void deleteUser(User u);
	public User addFriend(User u);
	
}
