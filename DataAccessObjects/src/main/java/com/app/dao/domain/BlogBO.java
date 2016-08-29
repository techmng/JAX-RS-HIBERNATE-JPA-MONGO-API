package com.app.dao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="blogs")
@Table(name="blog")
@NamedQueries({
@NamedQuery(
		name="allBlogsBetweenDates", 
		query = "Select b FROM blogs b where b.postedDate >=:startDate AND b.postedDate <=:endDate"),
@NamedQuery(
		name="allBlogs", 
		query = "Select b FROM blogs b")
})
public class BlogBO {
	
	public BlogBO(){}
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	@Id
	String id;
	
	@Column(name="topic")
	String topic;
	
	@Column(name="writerName")
    String writerName;
	
	@Column(name="writerId")
    String writerId;
	
	@Column(name="bodyContent")
    String bodyContent;
	
	@Column(name="createdDate")
	Date createdDate;
	
	@Column(name="postedDate")
	Date postedDate;
	
	//@Column(name="image")
	//Blob  image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getBodyContent() {
		return bodyContent;
	}

	public void setBodyContent(String bodyContent) {
		this.bodyContent = bodyContent;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	
	

}
