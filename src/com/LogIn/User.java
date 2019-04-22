
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
	// attributes for Users

	private String userName;
	private String password;

	public User() {

	}// empty constructor

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		System.out.println();
	} // object constructor with inputs
	
	//setters and getters

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

}
