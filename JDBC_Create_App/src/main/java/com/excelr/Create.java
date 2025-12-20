package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Load the class
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
		
//		Create / Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "@123qetuo");
		System.out.println("Connection Established Successfully");
		
//		Create a query statement
		Statement s1 = con.createStatement();
		
		String res = "create table java(sno int(50), sname varchar(20))";
		
//		Execute the query
		s1.executeUpdate(res);
		System.out.println("Table Created Successfully");
		
//		Close the connection
		con.close();
		System.out.println("Connection Closed Successfully");
	}
	
}
