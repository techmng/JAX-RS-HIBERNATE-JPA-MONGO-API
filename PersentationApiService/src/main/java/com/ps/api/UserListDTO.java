package com.ps.api;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="usersList" , required=false)
	private List<UserDTO> usersList;

	public UserListDTO(){}

	public List<UserDTO> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserDTO> usersList) {
		this.usersList = usersList;
	}

}
