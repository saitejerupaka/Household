package com.householdreminder.businesslogic;

import java.io.Serializable;
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
	
	public Serializable registerUser(UserDTO user)
	{
		if(isDuplicateUser(user))
		{
			return -1;
		}
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setUserPassword(user.getPassword());
		newUser.setFirstName(user.getUserFirstName());
		newUser.setLastName(user.getUserLastName());
		newUser.setUpdatedOn( new Date());
		//hibernateSession.beginTransaction();
		Serializable id = hibernateSession.save(newUser);
		//hibernateSession.getTransaction().commit();
		return id;
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
