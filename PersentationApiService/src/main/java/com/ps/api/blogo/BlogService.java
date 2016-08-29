package com.ps.api.blogo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.dbservice.BlogDAO;
import com.app.dao.dbservice.impl.BlogDAOImpl;
import com.app.dao.domain.BlogBO;

@Path("/blogs")
public class BlogService {
	static final Logger logger = LogManager.getLogger();

	public BlogService() {
		// TODO Auto-generated constructor stub
	}
	
	/** Returns blogs by date
	 * 
	 * @return
	 */
	@GET
	@Path("/findBlogsToday")
	@Produces(MediaType.APPLICATION_JSON )
	public Response findBlogsByDate() {
		logger.trace("Start findBlogsByDate");
		BlogDAO obj = new BlogDAOImpl();
		BlogListDTO blogList = new BlogListDTO();
		List<BlogDTO> blogs = new ArrayList<BlogDTO>();
		try {
			Date  startDate = new Date( java.lang.System.currentTimeMillis()-(24*60*60*1000));
			Date endDate = new Date();
			BlogBO bbo = new BlogBO();
			List<BlogBO> bList = obj.findBlogByPublishedDateRange(bbo, startDate, endDate);
			logger.trace("blogList size " + bList.size());
			for(BlogBO blogBO : bList){
				BlogDTO blogDTO = new BlogDTO();
				blogDTO.setId(blogBO.getId());
				blogDTO.setCreatedDate(blogBO.getCreatedDate());
				blogDTO.setBodyContent(blogBO.getBodyContent());
				blogDTO.setPostedDate(blogBO.getPostedDate());
				blogDTO.setTopic(blogBO.getTopic());
				blogDTO.setWriterId(blogBO.getWriterId());
				blogDTO.setWriterName(blogBO.getWriterName());
				blogs.add(blogDTO);
			}
			blogList.setBlogList(blogs);
		} catch (Exception e) {
			System.out.println("findBlogsByDate Exception caught in BlogService");
            e.printStackTrace();
		}
		
		return Response.status(200).entity(blogList)
				.header("Access-Control-Allow-Origin", "http://localhost:3000")
				.header("Access-Control-Allow-Methods","GET, POST, PATCH, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token")
				.build();
		
		//return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
		//.entity(userDTO).build();// ok(userDTO).build();
		//return Response.ok( Response.status(200).entity(userDTO).build()).header("Access-Control-Allow-Origin", "*").build();
		

	}
	
	
	/** Returns blogs by date
	 * 
	 * @return
	 */
	@GET
	@Path("/findAllBlogs")
	@Produces(MediaType.APPLICATION_JSON )
	public Response findAllBlogs() {
		logger.trace("Start findAllBlogs");
		BlogDAO obj = new BlogDAOImpl();
		BlogListDTO blogList = new BlogListDTO();
		List<BlogDTO> blogs = new ArrayList<BlogDTO>();
		try {
			//Date  startDate = new Date( java.lang.System.currentTimeMillis()-(24*60*60*1000));
			//Date endDate = new Date();
			BlogBO bbo = new BlogBO();
			List<BlogBO> bList = obj.findAllBlogs(bbo);
			logger.trace("AllblogList size " + bList.size());
			for(BlogBO blogBO : bList){
				BlogDTO blogDTO = new BlogDTO();
				blogDTO.setId(blogBO.getId());
				blogDTO.setCreatedDate(blogBO.getCreatedDate());
				blogDTO.setBodyContent(blogBO.getBodyContent());
				blogDTO.setPostedDate(blogBO.getPostedDate());
				blogDTO.setTopic(blogBO.getTopic());
				blogDTO.setWriterId(blogBO.getWriterId());
				blogDTO.setWriterName(blogBO.getWriterName());
				blogs.add(blogDTO);
			}
			blogList.setBlogList(blogs);
		} catch (Exception e) {
			System.out.println("findAllBlogs Exception caught in BlogService");
            e.printStackTrace();
		}
		
		return Response.status(200).entity(blogList)
				.header("Access-Control-Allow-Origin", "http://localhost:3000")
				.header("Access-Control-Allow-Methods","GET, POST, PATCH, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token")
				.build();

	}

}
