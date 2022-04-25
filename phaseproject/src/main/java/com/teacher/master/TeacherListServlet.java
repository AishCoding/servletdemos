package com.teacher.master;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/teacherlistServlet")
public class TeacherListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherClassList(request, response);
    }
 
    private void TeacherClassList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDAO dao = new TeacherDAO();
 
        try {
 
            List<TeacherDS> listClass = dao.list();
            request.setAttribute("listClass", listClass);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("assignteachers.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        TeacherClassList(request, response);
    }
}
