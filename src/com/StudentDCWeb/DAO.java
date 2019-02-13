package com.StudentDCWeb;

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
public class DAO {

	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/studentdb";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<student> getAllStudents() throws SQLException {
		System.out.println("In DAO Load Students");
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		String query = "select * from student";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<student> students = new ArrayList<student>();

		while (rs.next()) {
			String sid = rs.getString("sid");
			String cID = rs.getString("cID");
			String name = rs.getString("name");
			String address = rs.getString("address");
			student p = new student(sid, cID, name, address);

			students.add(p);
		}

		return students;

	}

	public void insertStudent(student s) throws SQLException {

		String sid = s.getSid();
		String cID = s.getcID();
		String name = s.getName();
		String address = s.getAddress();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn
				.prepareStatement("INSERT INTO student (sid, cID, name, address) VALUES (?, ?, ?, ?)");

		myStat.setString(1, sid);
		myStat.setString(2, cID);
		myStat.setString(3, name);
		myStat.setString(4, address);

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

			myStat = conn.prepareStatement("delete from student where sid = ?");
			myStat.setString(1, s.getSid());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
