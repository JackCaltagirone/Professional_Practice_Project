package com.Grades;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.Student.student;

@ManagedBean
@SessionScoped

public class GradesController {

	private GradesDAO gradesDAO;
	ArrayList<student> ps; // creates array list

	public GradesController() throws Exception {
		super();
		gradesDAO = new GradesDAO(); // creates the object of the gradesDAO
	}

	public void loadStudents() throws SQLException {

		System.out.println("In LoadStudents()");

		ps = gradesDAO.getAllStudents();

	}

	public ArrayList<student> getPs() {
		return ps;
	}

	public void setPs(ArrayList<student> ps) {
		this.ps = ps;
	}

	public String addStudent(student s) throws SQLException {

		try {
			gradesDAO.insertStudent(s); // calls the insert course with "s"
		}
		// try
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: Did not make it to insert Student");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} // catch

		return "index.xhtml";

	}// method for calling the methods that adds to database

	public String deleteStudent(student s) {
		try {
			gradesDAO.deleteStudent(s); // calls delete course with the parameter s
		} catch (Exception e) {
			e.printStackTrace();
		} // method for calling the methods that adds to database
		return "course";
	}

}
