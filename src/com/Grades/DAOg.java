package com.Grades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.StudentDCWeb.student;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class DAOg {
	private DataSource mysqlDS;

	public DAOg() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/school_db";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<Grades> getAllGrades() throws SQLException {
		System.out.println("In DAOg Load Grades");
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		String query = "select * from grades";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<Grades> grades = new ArrayList<Grades>();

		while (rs.next()) {

			String subject = rs.getString("subject");
			int grade = rs.getInt("grade");
			Grades g = new Grades(subject, grade);

			grades.add(g);

		}

		return grades;

	}

	public void insertMathsGrade(Grades g) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStat = conn.prepareStatement("UPDATE grades SET grade = ? where subject = 'MATHS' ");
			myStat.setInt(1, g.getGrade());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void insertEnglishGrade(Grades g) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStat = conn.prepareStatement("UPDATE grades SET grade = ? where subject = 'English' ");
			myStat.setInt(1, g.getGrade());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void insertIrishGrade(Grades g) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStat = conn.prepareStatement("UPDATE grades SET grade = ? where subject = 'Irish' ");
			myStat.setInt(1, g.getGrade());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void insertBusinessGrade(Grades g) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStat = conn.prepareStatement("UPDATE grades SET grade = ? where subject = 'Business' ");
			myStat.setInt(1, g.getGrade());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void insertScienceGrade(Grades g) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStat = conn.prepareStatement("UPDATE grades SET grade = ? where subject = 'Science' ");
			myStat.setInt(1, g.getGrade());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void insertPEGrade(Grades g) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStat = conn.prepareStatement("UPDATE grades SET grade = ? where subject = 'PE' ");
			myStat.setInt(1, g.getGrade());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
