package com.app.dao.dbservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.constants.MessageConstants;
import com.app.dao.dbservice.UserDAO;
import com.app.dao.domain.UserBO;
import com.app.dao.exception.DataNotFoundException;
import com.app.dao.utils.GetEntityManagerFactory;

public class UserDAOImpl implements UserDAO {
	
	static final Logger logger = LogManager.getLogger();
	
	/**
	 * This is used add users ins user table in database.
	 * UserBo ubo contains user details to insert in database. 
	 */
	public void addUser(UserBO ubo) throws Exception {
		logger.trace("Start addUser");
		try {
			EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			logger.trace("Get Transaction Object");
			
			tx.begin();
			em.persist(ubo);
			em.flush();
			tx.commit();

		} catch (Exception e) {
			logger.trace(" Exception in addUser " + e);
			//e.printStackTrace();
		}
		
	}
		
		/**
		 * Returns UserBO object if user present in user table and verified.
		 */
		public UserBO findUser(String userId, String userPassword) throws DataNotFoundException {
			
			logger.trace("Start findUser... ");
			UserBO userBO = new UserBO();
			try {
				EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				logger.trace("Get Trans findUser " + "userIdParam: " + userId + " " + " userPassParam: " +  userPassword);
				
				tx.begin();
				Query query = em.createNamedQuery("byUserId", UserBO.class);
				query.setParameter("userId", userId);
				query.setParameter("userPassword", userPassword);
				userBO = (UserBO) query.getSingleResult();
				
				logger.trace("End BlogDAOImpl.findUser " + " userId from DB "+ userBO.getUserId() + " ");

				em.flush();
				tx.commit();

			}catch (NoResultException nr) {
				logger.trace(" NoResultException in findUser " + nr);
				//e.printStackTrace();
				throw new DataNotFoundException(MessageConstants.DB_RECORD_NOT_FOUND,nr);
				
			}catch (PersistenceException pe) {
				logger.trace(" PersistenceException in findUser " + pe);
				//e.printStackTrace();
				throw new DataNotFoundException(MessageConstants.DB_CONNECTION_ERROR,pe);
				
			}catch (Exception e) {
				logger.trace(" Exception in findUser " + e);
				//e.printStackTrace();
				throw new DataNotFoundException();
				
			}
			return userBO;
		}

		/**
		 * 
		 */
		public List<UserBO> findAllUsers() throws Exception {
			
			logger.trace("Start findAllUser... ");
			List<UserBO> userList = new ArrayList<UserBO>();
			try {
				EntityManager em = GetEntityManagerFactory.getInstance().createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Query query = em.createNamedQuery("All");
				
				userList = (List) query.getResultList();
				
				logger.trace("End BlogDAOImpl.findAllUser " + " userListSize "+ userList.size());

				em.flush();
				tx.commit();

			}catch (NoResultException nr) {
				logger.trace(" NoResultException in findAllUser " + nr);
				//e.printStackTrace();
				throw new DataNotFoundException(MessageConstants.DB_RECORD_NOT_FOUND,nr);
				
			}catch (PersistenceException pe) {
				logger.trace(" PersistenceException in findAllUser " + pe);
				//e.printStackTrace();
				throw new DataNotFoundException(MessageConstants.DB_CONNECTION_ERROR,pe);
				
			}catch (Exception e) {
				logger.trace(" Exception in findAllUser " + e);
				//e.printStackTrace();
				throw new DataNotFoundException();
				
			}
			return userList;
		}
		
		
	    public UserBO updateUser(UserBO ubo) throws Exception{
	    	
	    	return null;
	    	
	    }



}
