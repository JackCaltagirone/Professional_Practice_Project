
package com.LogIn;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class User {

	private String userName;
	private String password;
	// attributes for student

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
	

}
