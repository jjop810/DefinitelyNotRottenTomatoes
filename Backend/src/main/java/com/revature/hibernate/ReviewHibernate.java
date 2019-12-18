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
import com.revature.beans.Reviews;
import com.revature.data.ReviewDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class ReviewHibernate implements ReviewDAO {
	
	@Autowired
	private HibernateUtil hu;

	private static Logger log = Logger.getLogger(MoviesHibernate.class);

	@Override
	public int addReview(Reviews rev) {
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
			LogUtil.logException(e, ReviewHibernate.class);
		} finally {
			s.close();
		}
		
		
		return rev.getId();
	}

	@Override
	public Set<Reviews> getReviews() {
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
		String query = "from reviews";
		Query<Reviews> q = s.createQuery(query, Reviews.class);
		//q.setFirstResult((page - 1) * pageSize);
		//q.setMaxResults(pageSize);
		List<Reviews> revs = q.list();
		s.close();
		return new HashSet<Reviews>(revs);
	}

	@Override
	public Reviews getReview(Integer userid, Integer movieid) {
		Session s = hu.getSession();
		String query = "from reviews r where r.userid=:userid AND r.movieid=:movieid";
		Query<Reviews> q = s.createQuery(query, Reviews.class);
		
		q.setParameter("userid", userid);
		q.setParameter("movieid", movieid);
		Reviews r = q.uniqueResult();
		s.close();
		return r;
	}
	
	@Override
	public Reviews getReview(Reviews rev) {
		Session s = hu.getSession();
		Reviews ret = s.get(Reviews.class, rev.getId());
		if(ret==null) {
			String query = "from Reviews rev where rev.review=:review";
			Query<Reviews> q = s.createQuery(query, Reviews.class);
			q.setParameter("username", rev.getReview());
			ret = q.getSingleResult();
		}
		s.close();
		return ret;
	}

	@Override
	public Reviews updateReview(Reviews rev) {
		log.trace("Update using this object: "+rev.getId());
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(rev);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, ReviewHibernate.class);
		} finally {
			s.close();
		}
		return rev;
	}

	

}
