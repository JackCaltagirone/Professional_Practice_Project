package com.CourseDCWeb;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class CourseController {

	private DAOc daoc;
	ArrayList<course> ps; // creates array list

	public CourseController() throws Exception {
		super();
		daoc = new DAOc(); // creates the object of the daoc
	}

	public void loadCourses() throws SQLException {
		ps = daoc.getAllCourses();
	}

	public ArrayList<course> getPs() {
		return ps;
	}

	public void setPs(ArrayList<course> ps) {
		this.ps = ps;
	}

	public String addCourse(course c) throws SQLException {

		try {
			daoc.insertCourse(c);// calls the insert course with "c"
		}
		// try
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} // catch

		return "index.xhtml";

	} // method for calling the methods that adds to database

	public String deleteCourse(course c) {
		try {
			daoc.deleteCourse(c); // calls delete course with the parameter c
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "course";
	} // method for calling the methods that adds to database

}
