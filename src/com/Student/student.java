
package com.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class student {

	private String sid;
	private String name;
	private String Address;
	private String Date_of_Birth;
	private String year_or_class;
	private String Special_Needs;
	// attributes for student

	public student() {

	}// empty constructer

	public student(String sid, String dob, String name, String address, String yearOrClass, String SN) {
		super();
		this.sid = sid;
		this.Date_of_Birth = dob;
		this.name = name;
		this.Address = address;
		this.year_or_class = yearOrClass;
		this.Special_Needs = SN;
		System.out.println("ProdID: " + sid + "Desc: " + dob + "Name: " + name + "Address: " + address + "Year: " + yearOrClass + "Special Needs: " + SN);
	} // object contructer with inputs
	

	public String getDate_of_Birth() {
		return Date_of_Birth;
	}

	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}

	public String getYear_or_class() {
		return year_or_class;
	}

	public void setYear_or_class(String year_or_class) {
		this.year_or_class = year_or_class;
	}

	public String getSpecial_Needs() {
		return Special_Needs;
	}

	public void setSpecial_Needs(String special_Needs) {
		Special_Needs = special_Needs;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	} // setters and getters
}
