package com.testparams.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingServlet
 */

public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String greeting;
    private String license;
    
	public void init() {
		greeting = getServletConfig().getInitParameter("greeting");
		license = getServletConfig().getInitParameter("license");
	}
	
	public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Inside Shopping Servlet Get method");
		PrintWriter out = response.getWriter();
		
		ServletContext sc=getServletContext();
		String projectName=sc.getInitParameter("project-name");
		String expirationSeconds=sc.getInitParameter("login-expiration-time-in-seconds");
		
		String greetingMessage = getInitParameter("greetings");
		String license = getInitParameter("license");
		
		out.println("Shopping Servlet");
		out.println("From the get method");
		out.println("Project Name: "+ projectName);
		out.println("expirationSeconds: "+ expirationSeconds);
		out.println("------------------------------------");
		out.println("Greetings Message: "+greeting);
		out.println("License: "+ license);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
