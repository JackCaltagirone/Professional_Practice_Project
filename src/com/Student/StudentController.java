package com.Student;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.Student.student;

@ManagedBean
@SessionScoped

public class StudentController {

	private DAO dao;
	ArrayList<student> ps; // creates array list

	public StudentController() throws Exception {
		super();
		dao = new DAO(); // creates the object of the dao
	}

	public void loadStudents() throws SQLException {

		System.out.println("In LoadStudents()");

		ps = dao.getAllStudents();

	}

	public ArrayList<student> getPs() {
		return ps;
	}

	public void setPs(ArrayList<student> ps) {
		this.ps = ps;
	}

	public String addStudent(student s) throws SQLException {

		try {
			dao.insertStudent(s); // calls the insert course with "s"
		}
		// try
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: Did not make it to insert Student");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} // catch

		return "Student.xhtml";

	}// method for calling the methods that adds to database

	public String deleteStudent(student s) {
		try {
			dao.deleteStudent(s); // calls delete course with the parameter s
		} catch (Exception e) {
			e.printStackTrace();
		} // method for calling the methods that adds to database
		return "course";
	}

}
