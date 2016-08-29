package com.app.dao.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetEntityManagerFactory {

	private static EntityManagerFactory _instanceEmFactory;
	private GetEntityManagerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static EntityManagerFactory getInstance(){
	    if(_instanceEmFactory == null){
	    	 //System.out.println("EntityManagerFactory _instance is null. Creating new object");
	    	_instanceEmFactory = Persistence.createEntityManagerFactory("mkpMongo");
	    }
	    return _instanceEmFactory;
	
	}
	
}
