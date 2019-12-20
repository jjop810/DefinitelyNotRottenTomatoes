package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.data.FriendDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class FriendHibernate implements FriendDAO {

	@Autowired
	private HibernateUtil hu;

	@Override
	public void addFriend(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getFriend(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getFriends() {
		Session s = hu.getSession();
		String query = "FROM User";
		Query<User> q = s.createQuery(query, User.class);
		List<User> friendList = q.getResultList();
		Set<User> friendSet = new HashSet<User>();
		friendSet.addAll(friendList);
		s.close();
		return friendSet;
	}


	@Override
	public void deleteFriend(User user) {
		// TODO Auto-generated method stub
		
	}

	

}