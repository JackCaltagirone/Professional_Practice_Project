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
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class LogInDAO {

	public static  DataSource mysqlDS;

	public LogInDAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/school_db";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public static void validate(User u) throws SQLException {
		Connection conn = mysqlDS.getConnection();

			PreparedStatement myStat = conn
					.prepareStatement("Select username, password from users where username = ? and password = ?");
			myStat.setString(1, u.getUserName());
			myStat.setString(1, u.getPassword());


			ResultSet rs = myStat.executeQuery();

			if (rs.next()) {
				// result found, means valid inputs
			}
			else 
			{
				System.out.println("INVALID INPUT");
			}
			myStat.close();
			conn.close();

		
	}

}
