package com.app.dao.dbservice.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.dbservice.BlogDAO;
import com.app.dao.domain.BlogBO;
import com.app.dao.utils.GetEntityManagerFactory;

public class BlogDAOImpl implements BlogDAO {
	
	
	static final Logger logger = LogManager.getLogger();


	/**
	 * Add records to database.
	 */
	public void addBlog(BlogBO bbo) throws Exception {
		logger.trace("Start addBlog");
		try {
			EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			logger.trace("Get Transaction Object");
			
			tx.begin();
			em.persist(bbo);
			em.flush();
			tx.commit();
			em.close();

		} catch (Exception e) {
			logger.trace(" Exception in addBlog " + e);
			//e.printStackTrace();
		}
	}	
		
		
		/**
		 * Add records to database.
		 */
		public void updateBlog(BlogBO bbo) throws Exception {
			logger.trace("Start updateBlog");
			try {
				EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				logger.trace("Get Transaction Object");
				BlogBO objbb = em.find(BlogBO.class, bbo.getId());
				
				tx.begin();

					if(objbb != null){
						
						if(bbo.getBodyContent() != null &&  bbo.getBodyContent() != "")
							objbb.setBodyContent(bbo.getBodyContent());
						
						if(bbo.getCreatedDate() != null)
							objbb.setCreatedDate(bbo.getCreatedDate());
						
						if(bbo.getPostedDate() != null)
							objbb.setPostedDate(bbo.getPostedDate());
						
						if(bbo.getTopic() != null &&  bbo.getTopic() != "")
							objbb.setTopic(bbo.getTopic());
						
						if(bbo.getWriterId() != null &&  bbo.getWriterId() != "")
							objbb.setWriterId(bbo.getWriterId());
						
						if(bbo.getWriterName() != null &&  bbo.getWriterName() != "")
							objbb.setWriterName(bbo.getWriterName());
	
					}
					em.flush();
				tx.commit();
				em.close();

			} catch (Exception e) {
				logger.trace(" Exception in updateBlog " + e);
				//e.printStackTrace();
			}
		

	}

	/**
	 * This method will pull all blogs posted between given dates. bbo object of
	 * type BlogBO startDate date of type java.util.date 
	 * Returns list of BlogBO object
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<BlogBO> findBlogByPublishedDateRange(BlogBO bbo, Date startDate, Date endDate){
		logger.trace("Start findBlogByPublishedDateRange ");
		List<BlogBO> resultList = new ArrayList<BlogBO>();
		try {
			EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			logger.trace("Get Trans");
			
			tx.begin();
			Query query = em.createNamedQuery("allBlogsBetweenDates", BlogBO.class);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			resultList = (List<BlogBO>) query.getResultList();
			
			logger.trace("End BlogDAOImpl.findBlogByPublishedDateRange " + resultList.size() + " ");

			em.flush();
			tx.commit();
			em.close();

		} catch (Exception e) {
			logger.trace(" Exception in findBlogByPublishedDateRange " + e);
			e.printStackTrace();
		}
		return resultList;
	}

	/**
	 * Find all blogs till date
	 */
    public List<BlogBO> findAllBlogs(BlogBO bbo) {
    	

		logger.trace("Start findAllBlogs ");
		List<BlogBO> resultList = new ArrayList<BlogBO>();
		try {
						
			EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();

			EntityTransaction tx = em.getTransaction();
			
			logger.trace("Get Trans findAllBlogs");
			
			tx.begin();
			Query query = em.createNamedQuery("allBlogs", BlogBO.class);
			resultList = (List<BlogBO>) query.getResultList();
			
			logger.trace("End BlogDAOImpl.findBlogByPublishedDateRange " + resultList.size() + " ");

			em.flush();
			tx.commit();
			em.close();

		} catch (Exception e) {
			logger.trace(" Exception in findBlogByPublishedDateRange " + e);
			e.printStackTrace();
		}
		return resultList;
	
    	
    }

	

}
