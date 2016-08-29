import java.util.Date;

import com.app.dao.dbservice.BlogDAO;
import com.app.dao.dbservice.UserDAO;
import com.app.dao.dbservice.impl.BlogDAOImpl;
import com.app.dao.dbservice.impl.UserDAOImpl;
import com.app.dao.domain.BlogBO;
import com.app.dao.domain.UserBO;

public class TestMongo {

	public static void main(String[] args) {
		
		BlogBO blogBO = new BlogBO();
		
		blogBO.setTopic("Self Actualization");
		blogBO.setBodyContent("Hola Hola Hola la la");
		blogBO.setWriterId("mkpus@yopmail.com");
		blogBO.setWriterName("Pandey MK");
		blogBO.setPostedDate(new Date());
		blogBO.setCreatedDate(new Date());
		
		//insert values to database
		insertData();
		//findList();
		
		//findUser("mkp@yahoo.com","p@ssword");
		
		//findAllUser();
		

	}
	
	public static void findList(){
		try{
			
			BlogBO blogBO = new BlogBO();

			BlogDAO obj = new BlogDAOImpl();
			

			Date  startDate = new Date( java.lang.System.currentTimeMillis()-(24*60*60*1000));
			Date endDate = new Date();
			System.out.println("current time  " + startDate + "  End Date  "+ endDate);
			
			obj.findBlogByPublishedDateRange(blogBO, startDate, endDate);
			
		}catch(Exception e){ e.printStackTrace();}
	}
	
	public static void insertData(){
		try {
			System.out.println("Start Test");
			
			/*UserBO usrBO =  new UserBO();
			usrBO.setUserId("mkp@yahoo.com");
			usrBO.setUserPassword("password");
			usrBO.setFirstName("Manoj");
			usrBO.setLastName("Pandey");
			usrBO.setValidEmailFlag(true);

			UserDAO usrDAO =  new UserDAOImpl();
			usrDAO.addUser(usrBO);*/
			
			BlogBO blogBO = new BlogBO();
			blogBO.setId("0593ccf1-b4f6-4578-b393-cf9e01b568c0");
			//blogBO.setTopic("Global Warming");
			/*blogBO.setBodyContent("It is knowing yourself, your weekness strength and knowing about who am I?"
					+ "It is knowing yourself, your weekness strength and knowing about who am I?"
					+ "It is knowing yourself, your weekness strength and knowing about who am I?"
					+ "It is knowing yourself, your weekness strength and knowing about who am I?"
					+ "It is knowing yourself, your weekness strength and knowing about who am I?");*/
			//blogBO.setWriterId("mkp@yahoo.com");
			//blogBO.setWriterName("Pandey MK");
			blogBO.setPostedDate(new Date());
			blogBO.setCreatedDate(new Date());
			//blogBO.setImage(null);
			BlogDAO obj = new BlogDAOImpl();
			obj.updateBlog(blogBO);
			
		} catch (Exception e) {
			System.out.println("Error" + e);

			e.printStackTrace();
		}	
	}
	public static void findUser( String userid, String pass){
		UserDAO obj = new UserDAOImpl();
		try {
			obj.findUser(userid, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void findAllUser(){
		UserDAO obj = new UserDAOImpl();
		try {
			obj.findAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
