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

		String query = "SELECT  grades.sid , grades.math ,   "
				+ "grades.english ,   grades.irish ,   grades.business ,   " + "grades.science ,   grades.pe FROM grades "
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

	public static void insertGrade(Grades g) throws SQLException {

		String sid = g.getSid();
		int math = g.getMath();
		String math1 = Integer.toString(math); 
		int english = g.getEnglish();
		String english1 = Integer.toString(english); 
		int irish = g.getIrish();
		String irish1 = Integer.toString(irish); 
		int business = g.getBusiness();
		String business1 = Integer.toString(business); 
		int science = g.getScience();
		String science1 = Integer.toString(science); 
		int pe = g.getPe();
		String pe1 = Integer.toString(pe); 

		/*int grade = rs.getInt("grade");
		String gr = Integer.toString(grade); */
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStat = conn.prepareStatement(
				"INSERT INTO `grades` (`sid`, `english`, `irish`, `math`, `business`, `science`, `pe`) VALUES (?, ?, ?, ?, ?, ?, ?)");
		//System.out.println("INSERT INTO Grades (sid, math, english, irish, business, science,pe) VALUES (?,?, ?, ?, ?,?,?)");
		myStat.setString(1, sid);
		myStat.setString(2, english1);
		myStat.setString(3, irish1);
		myStat.setString(4, math1);
		myStat.setString(5, business1);
		myStat.setString(6, science1);
		myStat.setString(7, pe1);

		myStat.executeUpdate();

		myStat.close();
		conn.close();
	}

}
