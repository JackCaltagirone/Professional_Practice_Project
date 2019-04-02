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
		System.out.println("In Grade DAO Load grades");
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();

		// this query will only show results where the sid is matching from both
		// the grades table and the student table

		String query = "SELECT  grades.sid , grades.english ,   "
				+ "grades.irish ,   grades.math ,   grades.business ,   " + "grades.science ,   grades.pe FROM grades "
				+ "INNER JOIN student ON grades.sid = student.sid; ";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<Grades> grades = new ArrayList<Grades>();

		while (rs.next()) {
			String sid = rs.getString("sid");
			int math = rs.getInt("math");
			int english = rs.getInt("english");
			int irish = rs.getInt("irish");
			int pe = rs.getInt("pe");
			int business = rs.getInt("business");
			int science = rs.getInt("science");
			Grades g = new Grades(sid, math, english, irish, pe, business, science);

			grades.add(g);
		}

		return grades;

	}

	public void insertGrade(Grades g) throws SQLException {

		String sid = g.getSid();
		int math = g.getMath();
		int english = g.getEnglish();
		int irish = g.getIrish();
		int business = g.getBusiness();
		int science = g.getScience();
		int pe = g.getPe();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn.prepareStatement(
				"INSERT INTO Grades (sid, math, english, irish, business, science,pe) VALUES (?,?, ?, ?, ?,?,?)");

		myStat.setString(1, sid);
		myStat.setInt(2, math);
		myStat.setInt(3, english);
		myStat.setInt(5, irish);
		myStat.setInt(5, business);
		myStat.setInt(6, science);
		myStat.setInt(7, pe);

		myStat.executeUpdate();

		myStat.close();
		conn.close();
	}

}
