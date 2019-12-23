package com.revature.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Admin;
import com.revature.beans.User;
import com.revature.data.AdminDAO;
import com.revature.utils.HibernateUtil;

@Component
public class AdminHibernate implements AdminDAO {
	
	@Autowired
	private HibernateUtil hu; 
	

	@Override
	public Admin getAdmin(Admin ad) {
		Session s = hu.getSession();
		Admin a;
		if(ad.getId()!=null && ad.getId()!=0) {
			a = s.get(Admin.class, ad.getId());
		}else {
			String query = "from Admin a where a.username=:username and a.password=:password";
			Query<Admin> q = s.createQuery(query, Admin.class);
			q.setParameter("username", ad.getUsername());
			q.setParameter("password", ad.getPassword());
			a = q.uniqueResult();

		}
		setFriendsFriends(a.getFriends());
		s.close();
		return a;
	}


	@Override
	public Admin getAdmin(String u, String p) {
		Session s = hu.getSession();
		String query = "from Admin a where a.username=:username and a.password=:password";
		Query<Admin> q = s.createQuery(query, Admin.class);
		q.setParameter("username", u);
		q.setParameter("password", p);
		Admin admin = q.uniqueResult();
		setFriendsFriends(admin.getFriends());
		s.close();
		return admin;
	}
	
	@Override
	public Admin getAdminById(Integer userId) {
		Session s = hu.getSession();
		String query = "from Admin a where a.id=:userid";
		Query<Admin> q = s.createQuery(query, Admin.class);
		q.setParameter("userid", userId);
		Admin admin = q.uniqueResult();
		setFriendsFriends(admin.getFriends());
		s.close();
		return admin;
	}
	
	public void setFriendsFriends(Collection<User> users) {
		users.forEach((friend) -> {
			friend.getId();
			friend.setFriends(new ArrayList<User>());
		});
	}

}
