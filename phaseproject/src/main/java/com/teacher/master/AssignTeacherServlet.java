package com.teacher.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignteacherServlet")
public class AssignTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private PreparedStatement ps;
       
	public void init(ServletConfig sc) {
		System.out.println("initializing addservlet...");
		ServletContext context = sc.getServletContext();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("UPDATE assignclass SET teachername=? WHERE classname=? AND subjectname=?");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classname= request.getParameter("classes");
		String subjectname= request.getParameter("subjects");
		String teachername= request.getParameter("teachers");
	
			try {
				ps.setString(1, teachername);
				ps.setString(2, classname);
				ps.setString(3, subjectname);
				ps.executeUpdate();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<b>" +teachername+ " has been assigned to "+classname+" for "+subjectname+"</b>");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
		
	}

}
