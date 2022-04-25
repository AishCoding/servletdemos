package com.classes.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassList(request, response);
    }
 
    private void ClassList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassDAO dao = new ClassDAO();
 
        try {
 
            List<ClassDS> listClass = dao.list();
            request.setAttribute("listClass", listClass);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("assignclasses.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ClassList(request, response);		
    }
}
