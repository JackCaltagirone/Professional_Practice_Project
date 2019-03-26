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

import com.Student.student;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class GradesDAO {

	private DataSource mysqlDS;

	public GradesDAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/school_db";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<student> getAllStudents() throws SQLException {
		System.out.println("In GradesDAO Load Students");
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		String query = "select * from Grades";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<student> students = new ArrayList<student>();

		while (rs.next()) {
			String sid = rs.getString("sid");
			String name = rs.getString("name");
			String address = rs.getString("Address");
			String dob = rs.getString("Date_of_Birth");
			String yearOrClass = rs.getString("year_or_class");
			String special_Needs = rs.getString("Special_Needs");
			student p = new student(sid, dob, name, address, yearOrClass, special_Needs);

			students.add(p);
		}

		return students;

	}

	public void insertStudent(student s) throws SQLException {

		String sid = s.getSid();
		String name = s.getName();
		String address = s.getAddress();
		String date_of_Birth = s.getDate_of_Birth();
		String year_or_class = s.getYear_or_class();
		String Special_Needs = s.getSpecial_Needs();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn.prepareStatement(
				"INSERT INTO Grades (sid, name, address, date_of_Birth,year_or_class,Special_Needs) VALUES (?, ?, ?, ?,?,?)");

		myStat.setString(1, sid);
		myStat.setString(2, name);
		myStat.setString(3, address);
		myStat.setString(4, date_of_Birth);
		myStat.setString(5, year_or_class);
		myStat.setString(6, Special_Needs);

		myStat.executeUpdate();

		myStat.close();
		conn.close();
	}

	public void deleteStudent(student s) throws SQLException {
		try {
			Connection conn;
			PreparedStatement myStat;
			ResultSet rs;

			conn = mysqlDS.getConnection();

			myStat = conn.prepareStatement("delete from Grades where sid = ?");
			myStat.setString(1, s.getSid());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
