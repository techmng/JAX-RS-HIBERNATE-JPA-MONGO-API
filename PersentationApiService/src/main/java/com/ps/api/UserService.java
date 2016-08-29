/**
 * This class is having all APIs related to user.
 * 
 */

package com.ps.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.dbservice.UserDAO;
import com.app.dao.dbservice.impl.UserDAOImpl;
import com.app.dao.domain.UserBO;

@Path("/user")
public class UserService {

	static final Logger logger = LogManager.getLogger();

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/JsonTest")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getJson() {
		logger.trace("Start JsonTest");
		System.out.println("Start JsonTest");
		UserDTO dto = new UserDTO();
		dto.setId("212024");
		dto.setCreatedBy("manoj");
		dto.setUserId("mkp");
		// dto.setCreatedDateTime("12-12-2017");
		// dto.setUpdateDateTime("13-12-2017");
		// dto.setUpdatedBy("manoj");
		dto.setUserPassword("passp");
		return dto;

	}
	
	@GET
	@Path("/Json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserDTO getJsonResponse( String requestData) {
		
		logger.trace("Start JsonTest");
		System.out.println("Start JsonTest");
		UserDTO dto = new UserDTO();
		dto.setId("212024");
		dto.setCreatedBy("manoj");
		dto.setUserId("mkp");
		// dto.setCreatedDateTime("12-12-2017");
		// dto.setUpdateDateTime("13-12-2017");
		// dto.setUpdatedBy("manoj");
		dto.setUserPassword("passp");
		return dto;

	}

	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name, @FormParam("age") int age) {
		return Response.status(200).entity("addUser is called, name : " + name + ", age : " + age).build();

	}

	/**
	 * Returns Users details by searching with user id and password
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	@POST
	@Path("/findUser")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response findUser(@FormParam("email") String id, @FormParam("pwd") String password) {
		
		
		logger.trace("Start findUser");
		System.out.println("findUser id: " + id + "pass " + password);
		UserDAO obj = new UserDAOImpl();
		UserDTO userDTO = new UserDTO();

		try {
			UserBO userBO = obj.findUser(id, password);
			logger.trace("userBO " + userBO);
			if (userBO != null && userBO.getUserId() != null) {
				logger.trace("userBO.userId " + userBO.getUserId());
				userDTO.setId(userBO.getId());
				userDTO.setCreatedBy(userBO.getCreatedBy());
				userDTO.setUpdateDateTime(userBO.getUpdatedBy());
				userDTO.setUserId(userBO.getUserId());
				userDTO.setUserPassword(userBO.getUserPassword());
				userDTO.setValidEmailFlag(userBO.isValidEmailFlag()+"");
				userDTO.setFirstName(userBO.getFirstName());
				userDTO.setLastName(userBO.getLastName());
			}

		} catch (Exception e) {
			System.out.println("findUser Exception caught in UserService");
            userDTO.setErrorCode(e.getMessage());
            e.printStackTrace();
		}
		
		return Response.status(200).entity(userDTO)
				.header("Access-Control-Allow-Origin", "http://localhost:3000")
				.header("Access-Control-Allow-Methods","GET, POST, PATCH, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token")
				.build();
		
		//return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
		//.entity(userDTO).build();// ok(userDTO).build();
		//return Response.ok( Response.status(200).entity(userDTO).build()).header("Access-Control-Allow-Origin", "*").build();
		

	}

	
	
	/**
	 * Returns Users details by searching with user id and password
	 * 
	 * @return
	 */
	@GET
	@Path("/findAllUsers")
	@Produces(MediaType.APPLICATION_JSON )
	public Response findAllUser() {
		logger.trace("Start findAllUsers");
		UserDAO obj = new UserDAOImpl();
		UserListDTO usersList = new UserListDTO();
		List<UserDTO> users = new ArrayList<UserDTO>();
		try {
			List<UserBO> userList = obj.findAllUsers();
			logger.trace("userList size " + userList.size());
			for(UserBO userBO : userList){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(userBO.getId());
				userDTO.setCreatedBy(userBO.getCreatedBy());
				userDTO.setUpdateDateTime(userBO.getUpdatedBy());
				userDTO.setUserId(userBO.getUserId());
				userDTO.setUserPassword(userBO.getUserPassword());
				userDTO.setValidEmailFlag(userBO.isValidEmailFlag()+"");
				userDTO.setFirstName(userBO.getFirstName());
				userDTO.setLastName(userBO.getLastName());
				users.add(userDTO);
			}
			usersList.setUsersList(users);
		} catch (Exception e) {
			System.out.println("findUser Exception caught in UserService");
            e.printStackTrace();
		}
		
		return Response.status(200).entity(usersList)
				.header("Access-Control-Allow-Origin", "http://localhost:3000")
				.header("Access-Control-Allow-Methods","GET, POST, PATCH, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token")
				.build();
		
		//return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
		//.entity(userDTO).build();// ok(userDTO).build();
		//return Response.ok( Response.status(200).entity(userDTO).build()).header("Access-Control-Allow-Origin", "*").build();
		

	}
	
	
	
	/**
	 * Find User by searching login id
	 * 
	 * @param id
	 * @return
	 */
	@POST
	@Path("/findUserById/{loginId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserById(@PathParam("loginId") String id) {
		logger.trace("Start findUserId");
		UserDAO obj = new UserDAOImpl();
		UserDTO userDTO = new UserDTO();
		try {
			UserBO userBO = obj.findUser(id, "p@ssword");
			logger.trace("userBO " + userBO);
			if (userBO != null) {
				logger.trace("userBO.userId " + userBO.getUserId());
				userDTO.setId(userBO.getId());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(userDTO).build();
	}

}