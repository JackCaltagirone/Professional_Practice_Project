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
		Statement myStmt = conn.createStatement();  //the creates the statement to be sent the sql server

		String query = "select * from grades"; //first query to open up the grades table
		ResultSet rs = myStmt.executeQuery(query); //rs is the result set. and the query is sent threw it

		ArrayList<Grades> Grade = new ArrayList<Grades>(); //creates new grade array Grade

		while (rs.next()) { //there are results
			
			System.out.println("before");
			int math = rs.getInt("math");  //breaking line. "Column math not found"
			System.out.println("after");
			
			
			int english = rs.getInt("english");
			int irish = rs.getInt("irish");
			int business = rs.getInt("business");
			int science = rs.getInt("science");
			int pe = rs.getInt("pe");

			//gets the subjects from the grades constructer 
			
			Grades g = new Grades(math, english, irish, business, science, pe);

			Grade.add(g); //adds to the grade array list
		}

		return Grade;

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
				"INSERT INTO Grades (math, english, irish, business, science,pe) VALUES (?, ?, ?, ?,?,?)");

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
