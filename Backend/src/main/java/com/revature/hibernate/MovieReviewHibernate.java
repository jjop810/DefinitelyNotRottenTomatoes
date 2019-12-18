package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.MovieReview;
import com.revature.data.MovieReviewDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class MovieReviewHibernate implements MovieReviewDAO{

	@Autowired
	private HibernateUtil hu;

	private static Logger log = Logger.getLogger(MovieReviewHibernate.class);
	private Integer lastPageNumber = 0;
	
	@Override
	public MovieReview addReview(MovieReview rev) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(rev);
			log.trace("adding review through hibernate " + rev);
			
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, MovieReviewHibernate.class);
		} finally {
			s.close();
		}
		
		
		return rev;
	}
	
	//Are we doing pages for reviews???
	@Override
	public Set<MovieReview> getReviews() {
		Session s = hu.getSession();
		/*int pageSize = 50;
		String count = "Select count (m.id) from Movies m";
		Query<Long> countQuery = s.createQuery(count, Long.class);
		Long countResults = countQuery.uniqueResult();
		lastPageNumber = (int) (Math.ceil(countResults / pageSize));
		if(page > lastPageNumber)
		{
			page = lastPageNumber;
		}
		else if(page < 1)
		{
			page = 1;
		}
		*/
		String query = "from moviereviews";
		Query<MovieReview> q = s.createQuery(query, MovieReview.class);
		/*
		 * q.setFirstResult((page - 1) * pageSize);
		 * q.setMaxResults(pageSize);

		*/
		List<MovieReview> reviews = q.list();
		s.close();
		return new HashSet<MovieReview>(reviews);
	}

	@Override
	public MovieReview getReview(String review) {
		Session s = hu.getSession();
		String query = "from moviereviews r where r.review=:review";
		Query<MovieReview> q = s.createQuery(query, MovieReview.class);
		
		q.setParameter("review", review);
		MovieReview m = q.uniqueResult();
		s.close();
		return m;
	}

	

	@Override
	public MovieReview updateReview(MovieReview rev) {
		log.trace("Update using this object: "+rev);
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(rev);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, MovieReviewHibernate.class);
		} finally {
			s.close();
		}
		return rev;
	}

}
