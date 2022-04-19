package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbctest {
	public static void main(String[] args) {
		System.out.println("JDBC Test");
		
		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from account");
				
				){
			
			//insert
			//int result = statement.executeUpdate("insert into account values(3,'Elle','Jose',5000)");
			//System.out.println("Number of rows inserted: "+result);
		
			//Update
			//int result1 = statement.executeUpdate("update account set balance=1450 where accno=3");
			//System.out.println("Number of rows updated: "+ result);
		
			//Delete
			int result = statement.executeUpdate("delete from account where accno=1");
			//System.out.println("Number of rows deleted: "+ result);
		
			//Read
			while(rs.next()) {
				System.out.println(rs.getInt(1)+". "+rs.getString(2)+", "+rs.getString(3)+": Balance= "+rs.getInt(4));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
