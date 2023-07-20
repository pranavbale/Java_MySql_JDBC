package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDao {

	// create a method to add a student to the database;
	public static boolean insertStudentToDb(Student st) {
		boolean f = false;

		try {
			// jdbc code....
			Connection con = CP.createC();

			String q = "insert into students (sname, sphone,scity) values(?, ?, ?);";

			// PreparedStatement

			PreparedStatement pstmt = con.prepareStatement(q);

			// set the value of parameter

			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			// execute...

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// deleteing the student form the database
	public static boolean deleteStudent(int sid) {
		boolean f = false;

		try {
			// jdbc code....
			Connection con = CP.createC();

			String q = "delete from students where sid = ?;";

			// PreparedStatement

			PreparedStatement pstmt = con.prepareStatement(q);

			// set the value of parameter

			pstmt.setInt(1, sid);

			// execute...

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	
	// display all the students from the table 
	public static void showAllStudent() {

		try {
			// jdbc code....
			Connection con = CP.createC();

			// query
			String q = "select * from students;";

			Statement stmt = con.createStatement();
			
			// executing the query and gatting the data form the user in the form of ResultSet
			ResultSet set = stmt.executeQuery(q);
			
			
			// display all the student information from the students
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID : " + id);
				System.out.println("Name : " + name);
				System.out.println("City : " + city);
				System.out.println("..........................................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
