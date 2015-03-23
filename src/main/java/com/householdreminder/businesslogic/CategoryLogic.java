package com.householdreminder.businesslogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.householdreminder.mappings.Category;
import com.householdreminder.mappings.User;
import com.householdreminder.model.CategoryDTO;

public class CategoryLogic {
	
	Session hibernateSession;
	public CategoryLogic(Session session) {
		hibernateSession = session;
		
	}

	public Serializable createCategory(CategoryDTO categoryDTO)
	{
		Category category = new Category();
		category.setCategoryName(categoryDTO.getCategoryName());
		Integer userId = new Integer(categoryDTO.getUserID());
		User user = (User) hibernateSession.load(User.class, userId);
		category.setUser(user);
		category.setUpdatedOn(new Date());
		Serializable id =  hibernateSession.save(category);
		return id;
		
	}

	public List<CategoryDTO> getCategoriesForUser(int i) {
		List<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();
		List categories = hibernateSession.createQuery("From Category where UserId = " + i).list();
		Category category;
		CategoryDTO categoryDTO;
		categoriesDTO.clear();
		for (Iterator iterator = 
                categories.iterator(); iterator.hasNext();)
		{
			
			category = (Category) iterator.next();
			categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			categoryDTO.setUserID(category.getUser().getUserId());
			categoriesDTO.add(categoryDTO);
  
		}
		return categoriesDTO;
	}

}
