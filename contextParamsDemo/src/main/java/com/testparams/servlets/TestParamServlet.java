package com.testparams.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestParamServlet() {
        super();
    }

	
    private String greeting;
	private String license;
       
	public void init() {
		greeting = getServletConfig().getInitParameter("greeting");
		license = getServletConfig().getInitParameter("license");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside TestPramServlet.Get Method");
		PrintWriter out = response.getWriter();
		
		ServletContext sc = getServletContext();
		String projectName = sc.getInitParameter("project-name");
		String expirationSeconds = sc.getInitParameter("login-expiration-time-in-seconds");
		
		out.println("TestParamServlet");
		out.println("From get method");
		out.println("--------------context params---------------");
		out.println("Project Name: " + projectName);
		out.println("Expiration Seconds: " + expirationSeconds);
		out.println("--------------init params-------------------");
		out.println("Greeting Message: " + greeting);
		out.println("license: " + license);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method");
	}
}
