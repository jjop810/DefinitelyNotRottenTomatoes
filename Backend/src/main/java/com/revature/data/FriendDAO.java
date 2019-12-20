package com.revature.data;

import java.util.Set;

import com.revature.beans.User;

public interface FriendDAO {
	
	public void addFriend(User user);
	public User getFriend(User user);
	public Set<User> getFriends();
	public void deleteFriend(User user);

}