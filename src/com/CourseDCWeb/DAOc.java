package com.CourseDCWeb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.CourseDCWeb.course;
import java.sql.PreparedStatement;

@ManagedBean
@SessionScoped
public class DAOc {

	private DataSource mysqlDS;

	public DAOc() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/school_db";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<course> getAllCourses() throws SQLException {
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		String query = "select * from course"; // sql query
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<course> courses = new ArrayList<course>();

		while (rs.next()) {

			String cID = rs.getString("cID");
			String cName = rs.getString("cName");
			int duration = rs.getInt("duration"); // these take in the strings
													// from the input on the
													// addcourse.xhtml
			course p = new course(cID, cName, duration);

			courses.add(p); // adds each each person to database
		} // while

		return courses;
	}

	public void insertCourse(course c) throws SQLException {

		String cID = c.getcID();
		String cName = c.getcName();
		int duration = c.getDuration();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn.prepareStatement("INSERT INTO course (cID, cName, duration) VALUES (?, ?, ?)"); // method
																														// to
																														// insert
																														// sql
																														// course

		myStat.setString(1, cID);
		myStat.setString(2, cName);
		myStat.setInt(3, duration); // each one of these is for each attribute
									// of the course

		myStat.executeUpdate();

		myStat.close();
		conn.close(); // closes connections
	}

	public void deleteCourse(course c) throws SQLException {
		try {
			Connection conn;
			PreparedStatement myStat;
			ResultSet rs;

			conn = mysqlDS.getConnection();

			myStat = conn.prepareStatement("delete from course where cID = ?"); // finds
																				// the
																				// cid
																				// and
																				// deletes
																				// the
																				// row
																				// with
																				// that
																				// cid
			myStat.setString(1, c.getcID());

			myStat.executeUpdate();

			myStat.close();
			conn.close(); // closes connections

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}