package com.classreport.master;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/classreportlistServlet")
public class ClassReportListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassReportList(request, response);
    }
 
    private void ClassReportList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassReportDAO dao = new ClassReportDAO();
 
        try {
 
            List<ClassReportDS> listClass = dao.list();
            request.setAttribute("listClass", listClass);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("classreport.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassReportList(request, response);

    }
}
