package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.revature.beans.User;
import com.revature.data.FriendsDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class FriendsHibernate implements FriendsDAO{
	
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public void addFriend(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t =s.beginTransaction();
			s.save(user);
			t.commit();
		} catch (HibernateException e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, FriendsHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public User getFriend(User user) {
		Session s = hu.getSession();
		User f;
		if (user.getId()!=null && user.getId() != 0) {
			// this means we're going to retrieve by id
			f = s.get(User.class, user.getId());
		} else {
			// this means we're getting by user/pass
			String query = "from USERFRIENDS uf where uf.ID=:ID and uf.FRIENDNAME=:FRIENDNAME";
			Query<User> q = s.createQuery(query, User.class);
			q.setParameter("ID", user.getId());
			q.setParameter("FRIENDNAME", user.getUsername());
			f = q.uniqueResult();
		}
		s.close();
		return f;
	}

	@Override
	public Set<User> getFriends() {
		Session s = hu.getSession();
		String query = "FROM USERFRIENDS";
		Query<User> q = s.createQuery(query, User.class);
		List<User> friendList = q.getResultList();
		Set<User> friendSet = new HashSet<User>();
		friendSet.addAll(friendList);
		s.close();
		return friendSet;
	}

	@Override
	public User getUser(Integer i) {
		Session s = hu.getSession();
		User u = s.get(User.class, i);
		s.close();
		return u;
	}

	@Override
	public void deleteFriend(User friend){
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.delete(friend);
			t.commit();
		} catch (HibernateException e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, FriendsHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void updateFriend(User friend) {
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.update(friend);
			t.commit();
		} catch (HibernateException e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, FriendsHibernate.class);
		} finally {
			s.close();
		}
	}

}
