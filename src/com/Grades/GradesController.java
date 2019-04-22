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


	public String addGrade(Grades g) throws SQLException {

		try {
			GradesDAO.insertGrade(g); // calls the insert course with "g"
		}
		// try
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: Did not make it to insert Student");
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
		} // catch

		return "Grades.xhtml";

	}// method for calling the methods that adds to database
	
	public String deleteGrade(Grades g) {
		try {
			GradesDAO.deleteGrade(g); // calls delete course with the parameter s
		} catch (Exception e) {
			e.printStackTrace();
		} // method for calling the methods that adds to database
		return "Grades.xhtml";
	}


}
