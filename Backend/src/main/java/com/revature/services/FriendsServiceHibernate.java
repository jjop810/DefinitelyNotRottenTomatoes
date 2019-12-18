//package com.revature.services;
//
//import java.util.Set;
//
//import org.apache.log4j.Logger;
//import com.revature.beans.Friends;
//import com.revature.data.FriendsDAO;
//import com.revature.hibernate.FriendsHibernate;
//
//
//public class FriendsServiceHibernate implements FriendsService {
//	
//	private Logger log = Logger.getLogger(FriendsServiceHibernate.class);
//	private FriendsDAO ed = new FriendsHibernate();
//	
//	@Override
//	public Friends getFriend(int id, String friendname) {
//		Friends friend = new Friends(null, friendname); // check # of params
//		friend = ed.getFriend(friend);	
//		return friend;
//	}
//
//	@Override
//	public Friends getFriendById(int i) {
//		log.trace("retrieving friend by id: "+i);
//		Friends friend = new Friends(i, null);
//		friend = ed.getFriend(friend);
//		return friend;
//	}
//
//	@Override
//	public Set<Friends> getFriends() {
//		Set<Friends> friendList = ed.getFriends();	
//		return friendList;
//	}
//
//	@Override
//	public void deleteFriend(Friends friend) {
//		ed.deleteFriend(friend);
//	}
//
//	@Override
//	public void updateFriend(Friends friend) {
//		ed.updateFriend(friend);
//
//	}
//
//	@Override
//	public void addFriend(Friends friend) {
//		ed.addFriend(friend);
//	}
//
//}
