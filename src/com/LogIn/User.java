
package com.LogIn;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped

public class User {

	private String userName;
	private String password;
	private String message;
	// attributes for Grades

	public User() {

	}// empty constructer

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		System.out.println();
	} // object contructer with inputs

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//validate login
	public String validateUsernamePassword() throws SQLException {
		return message;
	
	}

	//logout event, invalidate session
	public String logout() {
		return message; 
	}
}
