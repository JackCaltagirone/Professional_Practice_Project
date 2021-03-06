
package com.Grades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class Grades {

	private String sid;
	private int english;
	private int irish;
	private int math;
	private int business;
	private int science;
	private int pe;
	private int score; 

	// empty constructor
	public Grades() {

	}

	// Constructor for Updating grades
	public Grades(String sid, int score) {
		this.sid = sid;
		this.score = score;
	}

	//full constructor
	public Grades(String sid, int english, int irish, int math, int business, int science, int pe) {
		super();

		this.sid = sid;
		this.english = english;
		this.irish = irish;
		this.math = math;
		this.business = business;
		this.science = science;
		this.pe = pe;
		System.out.println("sid: " + sid + " math: " + math + " english: " + english + " irish: " + irish
				+ "  business: " + business + " science: " + science + " pe: " + pe);
	}
	
	
	//setters ands getters

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

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

}
