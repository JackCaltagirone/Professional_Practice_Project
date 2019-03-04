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

	private DataSource mysqlDS;

	public LogInDAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/school_db";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

}
