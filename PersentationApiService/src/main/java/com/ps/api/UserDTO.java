package com.ps.api;

import java.io.Serializable;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public UserDTO() {
	}
   
	@XmlElement(name="id", required=false)
	private String id;
   
    @XmlElement(name="userid", required=false)
	private String userId;
   
    @XmlElement(name="password" , required=false)
	private String userPassword;
    
    @XmlElement(name="creteddate", required=false)
	private String createdDateTime;
    
    @XmlElement(name="createdby" , required=false)
	private String createdBy;
    
    @XmlElement(name="updateddate", required=false)
	private String updateDateTime;
    
    @XmlElement(name="updatedby", required=false)
	private String updatedBy;
   
    @XmlElement(name="validEmailFlag", required=false)
    private String validEmailFlag;
    
    @XmlElement(name="firstName",required=false)
	String firstName;
	
    @XmlElement(name="lastName", required=false)
	String lastName;
    
    @XmlElement(name="errorCode", required=false)
	String errorCode;
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String isValidEmailFlag() {
		return validEmailFlag;
	}

	public void setValidEmailFlag(String validEmailFlag) {
		this.validEmailFlag = validEmailFlag;
	}
	
	@Override
	public String toString() {
		return " Id: "+ this.id 
			  +" userId: "+ this.userId 
			  + " createdBy: " + this.createdBy
			  + " updatedBy: " + this.updatedBy
		      + " updateDateTime: " + this.updateDateTime 
		      + " createdDateTime: " + this.createdDateTime
		      + " validEmailFlag: " + this.validEmailFlag;


	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getValidEmailFlag() {
		return validEmailFlag;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
