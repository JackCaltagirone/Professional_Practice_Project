package com.LogIn;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.StudentDCWeb.student;

@ManagedBean
@SessionScoped

public class LogInController {

	private LogInDAO dao;
	ArrayList<User> userList; // creates array list

	public LogInController() throws Exception {
		super();
		dao = new LogInDAO(); // creates the object of the dao
	}

	public ArrayList<User> getPs() {
		return userList;
	}

	public void setPs(ArrayList<User> userList) {
		this.userList = userList;
	}
}
