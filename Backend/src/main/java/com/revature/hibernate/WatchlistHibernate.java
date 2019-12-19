package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Movies;
import com.revature.beans.User;
import com.revature.beans.Watchlist;
import com.revature.data.WatchlistDAO;
import com.revature.utils.HibernateUtil;

@Component
public class WatchlistHibernate implements WatchlistDAO{
	@Autowired
	private HibernateUtil hu;

	@Override
	public Set<Movies> getWatchlist(User userId) {
		System.out.println("\n\n\n\n" + userId + "\n\n\n\n");
		Session s = hu.getSession();
		String query = "from Watchlist wl where wl.userId=:watch";
		Query<Watchlist> q = s.createQuery(query, Watchlist.class);
		
		q.setParameter("watch", userId);
		List<Watchlist> wl = q.list();
		Set<Movies> userWatchlist = new HashSet<Movies>();
		for(int x = 0; x < wl.size(); x++)
		{
			System.out.println("\n\n" + wl.get(x).getMovieId() + "\n\n"); 
			Movies ret = s.get(Movies.class, wl.get(x).getMovieId());
			System.out.println("\n\n" + ret + "\n\n");
			userWatchlist.add(ret);
		}
		s.close();
		return userWatchlist;
	}
	
	@Override
	public Integer addMovie(Watchlist watch) {
		System.out.println("In watchlist hibernate" + watch.toString());
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
