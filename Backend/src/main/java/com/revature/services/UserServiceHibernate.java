package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.hibernate.UserHibernate;

public class UserServiceHibernate implements UserService{
	
	private Logger log = Logger.getLogger(UserServiceHibernate.class);
	private UserDAO ud = new UserHibernate();
	
	@Override
	public User getUser(String username, String password) {

		User u = new User(null,username,password,null);
		u = ud.getUser(u);
		return u;
	}

	@Override
	public User getUserById(int i) {

		log.trace("retreiving user by id");
		User u = new User(i,null,null,null);
		u = ud.getUser(u);

		return u;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmployee(User u) {
		// TODO Auto-generated method stub
		
	}

}
