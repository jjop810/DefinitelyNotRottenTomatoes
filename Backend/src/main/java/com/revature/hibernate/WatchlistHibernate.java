package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Watchlist;
import com.revature.data.WatchlistDAO;
import com.revature.utils.HibernateUtil;

public class WatchlistHibernate implements WatchlistDAO{
	@Autowired
	private HibernateUtil hu;

	@Override
	public Set<Watchlist> getWatchlist(Integer userId) {
		Session s = hu.getSession();
		String query = "from Watchlist wl where wl.userId=:user";
		Query<Watchlist> q = s.createQuery(query, Watchlist.class);
		
		q.setParameter("title", userId);
		List<Watchlist> wl = q.list();
		s.close();
		return new HashSet<Watchlist>(wl);
	}
	
	@Override
	public Integer addMovie(Watchlist watch) {
		Integer i = null;
		if(watch.getMovieId() != 0 || watch.getShowId() != 0)
		{
			//Adding a movie or show
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				i = (Integer) s.save(watch);
				tx.commit();
			}catch(Exception e) {
				if(tx !=null)
					tx.rollback();
				e.printStackTrace();
			}finally {
				s.close();
			}
		}
		else
		{
			System.out.println("Bad request on adding to watchlist");
		}
		return i;
	}

}
