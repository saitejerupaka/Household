package com.householdreminder.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO {
	private int UserId;
	private String UserFirstName;
	private String UserLastName;
	private String Email;
	private String Password;
	
	@XmlElement(name="UserId")
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	@XmlElement(name="UserFirstName")
	public String getUserFirstName() {
		return UserFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		UserFirstName = userFirstName;
	}
	
	@XmlElement(name="UserLastName")
	public String getUserLastName() {
		return UserLastName;
	}
	public void setUserLastName(String userLastName) {
		UserLastName = userLastName;
	}
	
	@XmlElement(name="Email")
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@XmlElement(name="Password")
	public String getPassword() {
		return Password;
	}
	
	

}
