package com.householdreminder.businesslogic;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.householdreminder.mappings.User;
import com.householdreminder.model.UserDTO;

public class UserLogic {

	Session hibernateSession ;
	
	public UserLogic(Session session)
	{
		hibernateSession = session;
	}
	
	public String registerUser(UserDTO user)
	{
		try
		{
			if(isDuplicateUser(user))
			{
				return "User already exists.";
			}
			User newUser = new User();
			newUser.setEmail(user.getEmail());
			newUser.setUserPassword(user.getPassword());
			newUser.setFirstName(user.getUserFirstName());
			newUser.setLastName(user.getUserLastName());
			newUser.setUpdatedOn( new Date());
			hibernateSession.beginTransaction();
			hibernateSession.save(newUser);
			hibernateSession.getTransaction().commit();
			return "Registed Successfully";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return ex.getMessage();
		}
		
		
	}
	
	private Boolean isDuplicateUser(UserDTO user)
	{
		//Criteria criteria = hibernateSession.createCriteria(User.class);
		
		//User originalUsers = (User) criteria.add(Restrictions.eq("email", user.getEmail())).uniqueResult();
		
		List originalUsers =  hibernateSession.createSQLQuery("select * from User where email = '"+ user.getEmail() + "'").list();
		if(originalUsers != null && originalUsers.size() > 0)
		{
			return true;
		}
		return false;
	}
}
