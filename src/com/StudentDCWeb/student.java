package com.StudentDCWeb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class student {

	private String sid;
	private String cID;
	private String name;
	private String address; // attributes for student

	public student() {

	}// empty constructer

	public student(String sid, String cID, String name, String address) {
		super();
		this.sid = sid;
		this.cID = cID;
		this.name = name;
		this.address = address;
		System.out.println("ProdID: " + sid + "Desc: " + cID + "Name: " + name + "Address: " + address);
	} // object contructer with inputs

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	} // setters and getters
}
