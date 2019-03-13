package com.Grades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Grades {
	private String subject;
	private int grade;

	public Grades(String subject, int grade) {
		super();
		this.subject = subject;
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Grades() {

	}

}
