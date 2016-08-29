package com.ps.api.blogo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="blog")
@XmlAccessorType(XmlAccessType.FIELD)
public class BlogDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BlogDTO(){
		
	}
	
	
	@XmlElement(name="id", required=false)
	String id;
	
	@XmlElement(name="topic", required=false)
	String topic;
	
	@XmlElement(name="writerName", required=false)
    String writerName;
	
	@XmlElement(name="writerId", required=false)
    String writerId;
	
	@XmlElement(name="bodyContent", required=false)
    String bodyContent;
	
	@XmlElement(name="createdDate", required=false)
	Date createdDate;

	@XmlElement(name="postedDate", required=false)
	Date postedDate;

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
	
	@Override
	public String toString() {
		return " Id: "+ this.id 
			  +" topic: "+ this.topic 
			  + " createdDate: " + this.createdDate
			  + " bodyContent: " + this.bodyContent
		      + " writerId: " + this.writerId 
		      + " writerName: " + this.writerName
		      + " postedDate: " + this.postedDate;


	}
}
