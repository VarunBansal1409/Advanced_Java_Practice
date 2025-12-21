package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Load the class
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
		
//		Create / Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "@123qetuo");
		
//		Create a query statement
		Statement s1 = con.createStatement();
		
		String res1 = "insert into java values(1, 'John Doe')";
		String res2 = "insert into java values(2, 'Jane Smith')";
		String res3 = "insert into java values(3, 'Alice Johnson')";
		String res4 = "insert into java values(4, 'Bob Brown')";
		String res5 = "insert into java values(5, 'Charlie Davis')";
		
//		Execute the query
		s1.executeUpdate(res1);
		s1.executeUpdate(res2);
		s1.executeUpdate(res3);
		s1.executeUpdate(res4);
		s1.executeUpdate(res5);
		System.out.println("Data Inserted Successfully");
		
//		Close the connection
		con.close();
		System.out.println("Connection Closed Successfully");
		
	}
	
}
