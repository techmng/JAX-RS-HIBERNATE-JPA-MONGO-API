package com.app.dao.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
@NamedQueries({
@NamedQuery(
	name="byUserId", 
	query = " Select u FROM UserBO u WHERE u.userId = :userId AND u.userPassword = :userPassword"),
@NamedQuery(
		name="All", 
		query = " Select u FROM UserBO u ")

})
public class UserBO {
	public UserBO(){}
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id 
	private String id;
    
	@Column(name="userId")
	private String userId;

	@Column(name="userPassword")
    private String userPassword;
	
	@Column(name="createdDateTime")
    Timestamp createdDateTime;
	
	@Column(name="createdBy")
	String createdBy;
	
	@Column(name="updateDateTime")
    Timestamp updateDateTime;
	
	@Column(name="updatedBy")
	String updatedBy;
	
	@Column(name="validEmailFlag")
	boolean validEmailFlag;
	
	
	@Column(name="firstName")
	String firstName;
	
	@Column(name="lastName")
	String lastName;

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

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isValidEmailFlag() {
		return validEmailFlag;
	}

	public void setValidEmailFlag(boolean validEmailFlag) {
		this.validEmailFlag = validEmailFlag;
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

	

}
