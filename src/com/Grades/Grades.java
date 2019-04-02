
package com.Grades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class Grades {

	//for displaying table
	private String grade; 
	private String subject; 
	
	private int math;
	private int english;
	private int irish;
	private int business;
	private int science;
	private int pe;
	// attributes for Grades

	public Grades(String subject, String grade){
		super(); 
		this.subject = subject; 
		this.grade = grade; 
		
	}
	public Grades(int math, int english, int irish, int business, int science, int pe) {
		super();
		this.math = math;
		this.english = english;
		this.irish = irish;
		this.business = business;
		this.science = science;
		this.pe = pe;
		System.out.println("math: " + math + "english: " + english + "irish: " + irish + "business: " + business
				+ "science: " + science + "pe: " + pe);
	} // object contructer with inputs

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getIrish() {
		return irish;
	}

	public void setIrish(int irish) {
		this.irish = irish;
	}

	public int getBusiness() {
		return business;
	}

	public void setBusiness(int business) {
		this.business = business;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getPe() {
		return pe;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
