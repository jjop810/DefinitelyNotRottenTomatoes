package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Shows;
import com.revature.data.ShowsDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class ShowsHibernate implements ShowsDAO  {
	
	private static Logger log = Logger.getLogger(ShowsHibernate.class);
	
	@Autowired
	private HibernateUtil hu;

	@Override
	public int addShow(Shows mov) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(mov);
			log.trace("adding show through hibernate " + mov);
			
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, MoviesHibernate.class);
		} finally {
			s.close();
		}
		
		
		return mov.getId();
	}

	@Override
	public Shows getShow(String title) {
		Session s = hu.getSession();
		String query = "from Shows s where s.title=:title";
		Query<Shows> q = s.createQuery(query, Shows.class);
		
		q.setParameter("title", title);
		Shows m = q.uniqueResult();
		s.close();
		return m;
	}

	@Override
	public Shows getShow(Shows mov) {
		Session s = hu.getSession();
		Shows ret = s.get(Shows.class, mov.getId());
		if(ret==null) {
			String query = "from Shows s where s.title=:title";
			Query<Shows> q = s.createQuery(query, Shows.class);
			q.setParameter("username", mov.getTitle());
			ret = q.getSingleResult();
		}
		s.close();
		return ret;
	}
	
	@Override
	public Set<Shows> getShows(){
		Session s = hu.getSession();
		String query = "from Shows";
		Query<Shows> q = s.createQuery(query, Shows.class);
		List<Shows> ls = q.list();
		s.close();
		return new HashSet<Shows>(ls);
	}

	@Override
	public Shows getShowById(Integer id) {
		Session s = hu.getSession();
		Shows ret = s.get(Shows.class, id);
		s.close();
		return ret;
	}

	@Override
	public Shows updateShow(Shows mov) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(mov);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, ShowsHibernate.class);
		} finally {
			s.close();
		}
		return mov;
	}

}
