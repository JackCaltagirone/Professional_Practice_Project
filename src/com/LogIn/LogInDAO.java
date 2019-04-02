package com.LogIn;

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
public class LogInDAO {

	public static DataSource mysqlDS;
	String message; 

	public LogInDAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/school_db";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<User> getAllUsers() throws SQLException {
		System.out.println("In User DAO Load Users");
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		String query = "select * from Users";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<User> user = new ArrayList<User>();

		while (rs.next()) {
			String userName = rs.getString("userName");
			String password = rs.getString("password");

			User u = new User(userName, password);

			user.add(u);
		}

		return user;

	}

	public boolean validateUser(User u) throws SQLException {

		Connection conn = null;
		PreparedStatement myStat = null;

		String userName = u.getUserName();
		String password = u.getPassword();
		conn = mysqlDS.getConnection();
		myStat = conn.prepareStatement("Select username, password from users where username = ? and password = ?");

		myStat.setString(1, userName);
		myStat.setString(2, password);

		ResultSet rs = myStat.executeQuery();
		if (rs.next()) {
			// result found, means valid inputs
			return true;
		} else {
			return false; 
		}

	}

}
