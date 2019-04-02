package com.LogIn;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.Student.student;

@ManagedBean
@SessionScoped

public class LogInController {

	private LogInDAO dao;
	ArrayList<User> userList; // creates array list

	public LogInController() throws Exception {
		super();
		dao = new LogInDAO(); // creates the object of the dao
	}

	public void loadUsers() throws SQLException {

		System.out.println("In Load users");

		userList = dao.getAllUsers();

	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public String userLogin(User u) throws SQLException {

		if (dao.validateUser(u) == true) {
			return "Student.xhtml";

		}

		else
			return "LogIn.xhtml"; //reloads the page

	}//

}
