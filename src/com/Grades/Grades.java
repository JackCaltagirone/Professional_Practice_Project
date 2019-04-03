
package com.Grades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class Grades {

	// for displaying table
	private String grade;
	private String subject;

	private String sid;
	private int english;
	private int irish;
	private int math;
	private int business;
	private int science;
	private int pe;
	
	private String english1;
	private String irish1;
	private String math1;
	private String business1;
	private String science1;
	private String pe1;
	

	// empty constructor
	public Grades() {

	}
	

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

	//Grades with STRINGS

	public Grades(String sid, String english1, String irish1, String math1, String business1, String science1,
			String pe1) {
		super();
		this.sid = sid;
		this.english1 = english1;
		this.irish1 = irish1;
		this.math1 = math1;
		this.business1 = business1;
		this.science1 = science1;
		this.pe1 = pe1;
	}
	/*
	 * public Grades(String sid, int math, int english, int irish, int business,
	 * int science, int pe) { super(); this.sid = sid; this.math = math;
	 * this.english = english; this.irish = irish; this.business = business;
	 * this.science = science; this.pe = pe; System.out.println("sid: " + sid +
	 * " math: " + math + " english: " + english + " irish: " + irish +
	 * "  business: " + business + " science: " + science + " pe: " + pe); } //
	 * object contructer with inputs
	 */

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
