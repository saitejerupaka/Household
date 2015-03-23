package com.householdreminder.tests;

import static org.junit.Assert.*;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.householdreminder.businesslogic.UserLogic;
import com.householdreminder.dal.HibernateUtilities;
import com.householdreminder.mappings.User;
import com.householdreminder.model.UserDTO;

public class UserLogicTest {
	UserLogic userLogic;
	static Session session;
	
	@BeforeClass
	public static  void setUpSession()
	{
		session = HibernateUtilities.getSessionFactory().openSession();
	}
	
	@Before
	public void setUp()
	{
		userLogic = new UserLogic(session);
		
	}
	
	@AfterClass
	public static void releaseSession()
	{
		session.close();
	}
	
	@Test
	public void testCanary() 
	{
		assertTrue(true);
	}
	
	@Test
	public void testDuplicateUser_True()
	{
		UserDTO user = new UserDTO();
		user.setEmail("sai@gmail.com");
		int actual = (Integer)userLogic.registerUser(user);
		int expected = -1;
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testRegisterUser_NewUser1()
	{
		UserDTO user = new UserDTO();
		Transaction tx;
		user.setEmail("sai1@gmail.com");
		user.setPassword("Password");
		user.setUserFirstName("Test");
		user.setUserLastName("User");
		tx = session.beginTransaction();
		try
		{
			tx.setTimeout(5);
			User actualUser = (User) session.load(User.class, userLogic.registerUser(user) );
			assertEquals(user.getEmail(), actualUser.getEmail());
			tx.rollback();
		}
		catch(RuntimeException e)
		{
			try
			{
				tx.rollback();
			}
			catch(RuntimeException rbe){
				System.out.println("Couldn't rollback" + rbe.getMessage());
		}
		throw e;
	}

	
	
}
}
