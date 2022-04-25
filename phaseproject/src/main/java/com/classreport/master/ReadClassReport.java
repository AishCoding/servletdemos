package com.classreport.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readClassReport")
public class ReadClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
       
	public void init(ServletConfig sc) {
		System.out.println("initializing addservlet...");
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Statement statement1 = connection.createStatement();
			String classname=request.getParameter("classes");
			ResultSet rs = statement1.executeQuery("select * from assignclass where classname = "+'"'+classname+'"');
			PrintWriter out = response.getWriter();
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Class</th>");
			out.println("<th>Subject</th>");
			out.println("<th>Teacher</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("</tr>");
			}
			out.println("</table><br><br>");
			rs.close();
			
			Statement statement2 = connection.createStatement();
			ResultSet rs2 = statement2.executeQuery("select * from students where className = "+'"'+classname+'"');
			PrintWriter out2 = response.getWriter();
			out2.println("<table border=1>");
			out2.println("<tr>");
			out2.println("<th>Student Name</th>");
			out2.println("<th>Class</th>");
			out2.println("</tr>");
			while (rs2.next()) {
				out2.println("<tr>");
				out2.println("<td>" + rs2.getString(1) + "</td>");
				out2.println("<td>" + rs2.getString(2) + "</td>");
				out2.println("</tr>");
			}
			out2.println("</table>");
			rs2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}