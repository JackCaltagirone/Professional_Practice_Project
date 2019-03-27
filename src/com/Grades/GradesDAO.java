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

	public ArrayList<Grades> getAllGrades() throws SQLException {
		System.out.println("In GradesDAO Load grades");
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		String query = "select * from grades";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<Grades> grades = new ArrayList<Grades>();

		while (rs.next()) {
			int math = rs.getInt("math");
			int english = rs.getInt("english");
			int irish = rs.getInt("irish");
			int business = rs.getInt("business");
			int science = rs.getInt("science");
			int pe = rs.getInt("pe");
			Grades g = new Grades(math, english, irish, business, science, pe);

			grades.add(g);
		}

		return grades;

	}

	public void insertGrade(Grades g) throws SQLException {

		int math = g.getMath();
		int english = g.getEnglish();
		int irish = g.getIrish();
		int business = g.getBusiness();
		int science = g.getScience();
		int pe = g.getPe();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn.prepareStatement(
				"INSERT INTO Grades (Maths, English, Irish, Business, Science, PE) VALUES (?, ?, ?, ?,?,?)");

		myStat.setInt(1, math);
		myStat.setInt(2, english);
		myStat.setInt(3, irish);
		myStat.setInt(4, business);
		myStat.setInt(5, science);
		myStat.setInt(6, pe);

		myStat.executeUpdate();

		myStat.close();
		conn.close();
	}

}
