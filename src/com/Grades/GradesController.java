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
	ArrayList<Grades> ps; // creates array list

	public GradesController() throws Exception {
		super();
		gradesDAO = new GradesDAO(); // creates the object of the gradesDAO
	}

	public void loadGrades() throws SQLException {

		System.out.println("In loadGrades()");

		ps = gradesDAO.getAllGrades();

	}

	public ArrayList<Grades> getPs() {
		return ps;
	}

	public void setPs(ArrayList<Grades> ps) {
		this.ps = ps;
	}

	public String addGrade(Grades g) throws SQLException {

		try {
			gradesDAO.insertGrade(g); // calls the insert course with "s"
		}
		// try
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: Did not make it to insert Grade");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} // catch

		return "index.xhtml";

	}// method for calling the methods that adds to database

}
