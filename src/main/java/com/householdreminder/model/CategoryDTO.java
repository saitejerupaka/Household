package com.householdreminder.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CategoryDTO {

	
	private int CategoryId;
	private int UserID;
	private String CategoryName;
	
	@XmlElement(name="CategoryId")
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	
	@XmlElement(name="CategoryName")
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	@XmlElement(name="UserId")
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	
}
