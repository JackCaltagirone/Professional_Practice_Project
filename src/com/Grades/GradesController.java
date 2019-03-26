package com.Grades;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class GradesController {
	private DAOg dao;
	ArrayList<Grades> gs; // creates array list

	public GradesController() throws Exception {
		super();
		dao = new DAOg(); // creates the object of the dao
	}

	public ArrayList<Grades> getGs() {
		return gs;
	}

	public void setGs(ArrayList<Grades> gs) {
		this.gs = gs;
	}
	

	public void loadGrades() throws SQLException {

		//System.out.println("In loadGrades()");

		gs = dao.getAllGrades();
	}
	
	public String addMaths(Grades g) throws SQLException{
		
		dao.insertMathsGrade(g);
		
		return "Grades.xhtml";
	}
	public String addIrish(Grades g) throws SQLException{
		
		dao.insertIrishGrade(g);
		
		return "Grades.xhtml";
	}
	public String addEnglish(Grades g) throws SQLException{
		
		dao.insertEnglishGrade(g);
		
		return "Grades.xhtml";
	}
	public String addBusiness(Grades g) throws SQLException{
		
		dao.insertBusinessGrade(g);
		
		return "Grades.xhtml";
	}
	public String addScience(Grades g) throws SQLException{
		
		dao.insertScienceGrade(g);
		
		return "Grades.xhtml";
	}
	public String addPE(Grades g) throws SQLException{
		
		dao.insertPEGrade(g);
		
		return "Grades.xhtml";
	}
	
}
