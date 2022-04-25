package com.login.master;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username.equals("admin") && password.equals("admin")) {
			// successfull login
			RequestDispatcher rd = request.getRequestDispatcher("options.html");
			request.setAttribute("greeting", "Welcome to the Learner" + "'" + "s Academy");
			rd.forward(request, response);
		} else {
			// unsuccessful login - incorrect email or incorrect password
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<p>Login failed</p>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}	
	}

}

