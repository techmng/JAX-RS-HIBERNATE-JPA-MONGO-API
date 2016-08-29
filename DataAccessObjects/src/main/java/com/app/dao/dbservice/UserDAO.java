package com.app.dao.dbservice;

import java.util.List;

import com.app.dao.domain.UserBO;

public interface UserDAO {
	
	    public void addUser(UserBO ubo) throws Exception;
	    
	    public UserBO updateUser(UserBO ubo) throws Exception;

	    
	    public UserBO findUser(String userId, String userPassword) throws Exception;
	    
	    public List<UserBO> findAllUsers() throws Exception;

}
