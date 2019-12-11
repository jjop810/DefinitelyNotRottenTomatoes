package com.revature.services.hibernate;

import com.revature.data.UserDAO;
import com.revature.hibernate.UserHibernate;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserServiceHibernate implements UserService
{
	private static UserDAO ud = new UserHibernate();
	
	@Override
	public void addBook(User user) {
		ud.addUser(user);
	}

}
