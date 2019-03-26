package com.CourseDCWeb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class course {

	private String cID;
	private String cName;
	private int duration; // variables for course

	public course() {

	}// empty constructer

	public course(String cID, String cName, int duration) {
		super();
		this.cID = cID;
		this.cName = cName;
		this.duration = duration;
		System.out.println("cID: " + cID + "cName: " + cName + "Duration: " + duration); //
	} // creates course object

	// setters and getters
	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
