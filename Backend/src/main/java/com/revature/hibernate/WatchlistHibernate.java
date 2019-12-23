package com.revature.hibernate;

import java.util.ArrayList;
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
	private Integer lastPageNumber = 1;

	@Override
	public List<Movies> getWatchlist(User userId, Integer page) {
		Session s = hu.getSession();
		String query = "from Watchlist wl where wl.userId=:watch";
		Query<Watchlist> q = s.createQuery(query, Watchlist.class);
		q.setParameter("watch", userId);
		List<Watchlist> wl = q.list();
		
		
		if(wl.size() < 50)
		{
			int pageSize = wl.size();
			query = "from Watchlist wl where wl.userId=:watch order by title asc";
			q = s.createQuery(query, Watchlist.class);
			q.setParameter("watch", userId);
			q.setFirstResult((page - 1) * pageSize);
			q.setMaxResults(pageSize);
			wl = q.list();
		}
		else
		{
			int pageSize = 50;
			float pageCount = 50.0f;
			String count = "Select count (wl.id) from Watchlist wl";
			Query<Long> countQuery = s.createQuery(count, Long.class);
			Long countResults = countQuery.uniqueResult();
			lastPageNumber = (int) (Math.ceil(countResults / pageCount));
			if(page > lastPageNumber)
			{
				page = lastPageNumber;
			}
			else if(page < 1)
			{
				page = 1;
			}
			query = "from Watchlist order by title asc";
			q = s.createQuery(query, Watchlist.class);
			q.setFirstResult((page - 1) * pageSize);
			q.setMaxResults(pageSize);
			wl = q.list();
		}
		
		List<Movies> userWatchlist = new ArrayList<Movies>();
		for(int x = 0; x < wl.size(); x++)
		{
			Movies ret = s.get(Movies.class, wl.get(x).getMovieId());
			userWatchlist.add(ret);
		}
		s.close();
		return userWatchlist;
	}
	
	@Override
	public Integer addMovie(Watchlist watch) {
		System.out.println("In watchlist hibernate" + watch.getMovieId().toString());
		Integer i = null;
		if(watch.getMovieId() != 0 || watch.getShowId() != 0)
		{
			//Adding a movie or show
			Session s = hu.getSession();
			Transaction tx = null;
			try {
				tx = s.beginTransaction();
				System.out.println("Adding " + watch.toString() + " to watch list");
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

	@Override
	public Integer getLastPage() {
		System.out.println("test" + lastPageNumber);
		return lastPageNumber;
	}

	@Override
	public Set<Movies> getMovieSerarch(String title, Integer page, Integer userId) {
		Session s = hu.getSession();
		int pageSize = 200;	
		String query = "from Watchlist where userid = "+ userId +" and upper(title) like '%"+title.toUpperCase()+"%'";
		Query<Watchlist> q = s.createQuery(query, Watchlist.class);		
		q.setMaxResults(pageSize);
		List<Watchlist> wl = q.list();
		List<Movies> userWatchlist = new ArrayList<Movies>();
		for(int x = 0; x < wl.size(); x++)
		{
			Movies ret = s.get(Movies.class, wl.get(x).getMovieId());
			userWatchlist.add(ret);
		}
		s.close();
		return new HashSet<Movies>(userWatchlist);
	}

}
