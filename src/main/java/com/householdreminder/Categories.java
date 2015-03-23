package com.householdreminder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.hibernate.Session;

import com.householdreminder.businesslogic.CategoryLogic;
import com.householdreminder.dal.HibernateUtilities;
import com.householdreminder.model.CategoryDTO;
@Path("categories")
public class Categories 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryDTO> getCategories(){
		List<CategoryDTO> categories = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();
		categories = new CategoryLogic(session).getCategoriesForUser(1);
		session.flush();
		session.close();
		return categories;
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Integer createCategory(CategoryDTO category)
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		Serializable id = new CategoryLogic(session).createCategory(category);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return (Integer)id;
		
		
		
	}
	

}
