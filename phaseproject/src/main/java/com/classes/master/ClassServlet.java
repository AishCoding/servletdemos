package com.classes.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/classServlet")
public class ClassServlet extends HttpServlet {
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
			ps = connection.prepareStatement("insert into classes values(?)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String cname= request.getParameter("class");
			try {
				ps.setString(1, cname);
				int result = ps.executeUpdate();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<b>" + result + " New Class added. </b>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
