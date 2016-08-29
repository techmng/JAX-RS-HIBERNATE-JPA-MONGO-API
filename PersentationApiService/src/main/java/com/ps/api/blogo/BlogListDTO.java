/**
 * 
 */
package com.ps.api.blogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author manojpandey
 *
 */
@XmlRootElement(name="blogs")
@XmlAccessorType(XmlAccessType.FIELD)
public class BlogListDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BlogListDTO() {
	}
	
	@XmlElement(name="blogList" , required=false)
	private List<BlogDTO> blogList = new ArrayList<BlogDTO>();

	public List<BlogDTO> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<BlogDTO> blogList) {
		this.blogList = blogList;
	}
}
