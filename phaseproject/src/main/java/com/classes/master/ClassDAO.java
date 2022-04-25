package com.classes.master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
     
    public List<ClassDS> list() throws SQLException {
        List<ClassDS> listClasses = new ArrayList<>();
        Connection connection=null;
        Statement statement1=null;
        Statement statement2=null;

        try {
        	Class.forName("com.mysql.jdbc.Driver"); 
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
        		
            String sql1 = "SELECT * FROM classes";
            String sql2 = "SELECT subjectname FROM subject";

            ResultSet result1 = statement1.executeQuery(sql1);
            ResultSet result2 = statement2.executeQuery(sql2);
             
            while (result1.next() && result2.next()) {
                String classname = result1.getString("className");
                String subjname = result2.getString("subjectname");
                ClassDS classds = new ClassDS(classname,subjname);
                     
                listClasses.add(classds);
            }        
            result1.close();
            result2.close();
            statement1.close();
            statement2.close();
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
                        if (statement2 != null)
                            statement2.close();
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
