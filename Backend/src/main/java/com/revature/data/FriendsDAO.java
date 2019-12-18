package com.revature.data;

import java.util.Set;


import com.revature.beans.User;

public interface FriendsDAO {
	
	public void addFriend(User user); //change void to integer
	public User getFriend(User user); //change(Friends to Integer)
	public Set<User> getFriends();
	public void deleteFriend(User user);
	public void updateFriend(User user);
	User getUser (Integer i);
	//public Friends updateFriend(Friends friend);
}
