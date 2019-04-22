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

	private static DataSource mysqlDS;

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

		// query is the query that the program will enter into the sql database. the
		// string is a legal sql entry that selects the grades table and creates a join
		String query = "SELECT  grades.sid , grades.english, grades.irish, grades.math , grades.business ,   "
				+ "grades.science ,   grades.pe FROM grades  INNER JOIN student ON grades.sid = student.sid; ";
		ResultSet rs = myStmt.executeQuery(query);

		ArrayList<Grades> grades = new ArrayList<Grades>();

		// while the result set (rs) has items to keep seraching, this will run.
		// note that they are in order of the query with side first then english etc.
		// this while assigns the "grades.sid" to the get sid method from the grades
		// constructer
		while (rs.next()) {
			String sid = rs.getString("sid");
			int english = rs.getInt("english");
			int irish = rs.getInt("irish");
			int math = rs.getInt("math");
			int business = rs.getInt("business");
			int science = rs.getInt("science");
			int pe = rs.getInt("pe");
			Grades g = new Grades(sid, english, irish, math, business, science, pe);

			grades.add(g);
		}

		return grades;

	}

	// method that is called when for inserting grades
	public static void insertGrade(Grades g) throws SQLException {

		// first the method will get each of the subject variables from the getters
		String sid = g.getSid();
		int math = g.getMath();
		int english = g.getEnglish();
		int irish = g.getIrish();
		int business = g.getBusiness();
		int science = g.getScience();
		int pe = g.getPe();

		// next will prepare a statement to be inserted into sql database
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn.prepareStatement(// the "?" mark when the user entered variables will be set.
															// with sid being first then english etc.
				"INSERT INTO `grades` (`sid`, `english`, `irish`, `math`, `business`, `science`, `pe`) VALUES (?, ?, ?, ?, ?, ?, ?)");

		// correspond to the ? above
		myStat.setString(1, sid);
		myStat.setInt(2, english);
		myStat.setInt(3, irish);
		myStat.setInt(4, math);
		myStat.setInt(5, business);
		myStat.setInt(6, science);
		myStat.setInt(7, pe);

		myStat.executeUpdate();

		myStat.close();
		conn.close();
	}

	// delete grades
	public static void deleteGrade(Grades g) throws SQLException {
		try {
			Connection conn;
			PreparedStatement myStat;

			conn = mysqlDS.getConnection();

			// prepares statment that tells the server to delete the row where "sids = ?"
			myStat = conn.prepareStatement("delete from Grades where sid = ?");
			// user will then enter sid.
			myStat.setString(1, g.getSid());

			myStat.executeUpdate();

			myStat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			// if it fails we have the catch
		}

	}

}
