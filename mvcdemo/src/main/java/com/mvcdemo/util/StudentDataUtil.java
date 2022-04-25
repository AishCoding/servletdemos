package com.mvcdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvcdemo.model.Student;

public class StudentDataUtil {

	public static List<Student> getStudents() {
		
		List<Student> students = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");				
		) {

			while (rs.next()) {
				Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3));
				students.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
				
//		students.add(new Student("John", "Wilson", "jwil@example.com"));
//		students.add(new Student("Alex", "Johnson", "aj@example.com"));
//		students.add(new Student("William", "Ray", "rwil@example.com"));
//		students.add(new Student("Max", "Jackson", "maxjack@example.com"));
		
		return students;
	}
	
}
