package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.HibernateUtil;

@Component
public class UserHibernate implements UserDAO{
	
	@Autowired
	private HibernateUtil hu;

	@Override
	public User getUser(String username, String password) {
		Session s = hu.getSession();
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = q.uniqueResult();
		s.close();
		return u;

	}

	@Override
	public User getUser(User u) {

		Session s = hu.getSession();
		User ret = s.get(User.class,u.getId());
		if(ret==null) {
			String query = "from User u where u.username=:username and u.password=:password";
			Query<User> q = s.createQuery(query, User.class);
			q.setParameter("username", u.getUsername());
			q.setParameter("password", u.getPassword());
			ret = q.uniqueResult();
		}
		s.close();
		return ret;


	}

	@Override
	public User getUserById(Integer i) {
		Session s = hu.getSession();
		User u = s.get(User.class, i);
		s.close();
		return u;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public Integer addUser(User u) {
		Integer i = null;
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			i = (Integer) s.save(u);
			tx.commit();
		}catch(Exception e) {
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return i;
	}

	@Override
	public Set<User> getUsers() {
		Session s = hu.getSession();
		String query = "FROM User";
		Query<User> q = s.createQuery(query, User.class);
		List<User> list = q.getResultList();
		Set<User> users = new HashSet<User>();
		users.addAll(list);
		for(User u : users) {
			u.getFriends().forEach( (friend) -> {
				friend.getId();
			});
		}
		s.close();
		return users;
	}

}
