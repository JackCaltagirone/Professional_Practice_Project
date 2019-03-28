package com.Grades;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class GradesController {

	private GradesDAO gradesDAO;
	ArrayList<Grades> gs; // creates array list

	public GradesController() throws Exception {
		super();
		gradesDAO = new GradesDAO(); // creates the object of the gradesDAO
	}

	public void loadGrade() throws SQLException {

		System.out.println("In Loadgrades()");

		gs = gradesDAO.getAllGrades();

	}//method that calls the dao to get list out the grades

	public ArrayList<Grades> getgs() {
		return gs;
	}

	public void setgs(ArrayList<Grades> gs) {
		this.gs = gs;
	}//array setter and and getter

	public String addGrade(Grades s) throws SQLException {

		try {
			gradesDAO.insertGrade(s); // calls the insert course with "s"
		}
		// try
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: Did not make it to insert grade");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} // catch

		return "index.xhtml";

	}// method for calling the methods that adds to database


}
