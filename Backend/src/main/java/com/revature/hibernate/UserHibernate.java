package com.revature.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.HibernateUtil;

public class UserHibernate implements UserDAO
{
	private HibernateUtil hu;

	@Override
	public int addUser(User user) 
	{
		Integer id = null;
		Session s = hu.getSession();
		Transaction tx = null;
		try 
		{
			tx = s.beginTransaction();
			id = (Integer) s.save(user);
			tx.commit();
		} 
		catch(Exception e) 
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		} 
		finally 
		{
			s.close();
		}
		return id;
	}

}
