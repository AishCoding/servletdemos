package com.classreport.master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassReportDAO {
     
    public List<ClassReportDS> list() throws SQLException {
        List<ClassReportDS> listClasses = new ArrayList<>();
        Connection connection=null;
        Statement statement1=null;

        try {
        	Class.forName("com.mysql.jdbc.Driver"); 
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
            statement1 = connection.createStatement();
        		
            String sql1 = "SELECT * FROM classes";
            ResultSet result1 = statement1.executeQuery(sql1);
             
            while (result1.next()) {
                String classname = result1.getString("className");
                ClassReportDS classds = new ClassReportDS(classname);
                     
                listClasses.add(classds);
            }        
            result1.close();
            statement1.close();
            connection.close();
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        finally{  
            //closing the resources..STEP 7
                    try {
                        if (statement1 != null)
                            statement1.close();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
        
        return listClasses;
    }
}
